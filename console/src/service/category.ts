import {ICategoryService} from "@/service/interface";
import api from "@/api";
import {ROOT_CATEGORY_ID} from "@/commons/constant";
import molecule from "@dtinsight/molecule";
import {getTreeNode} from "@/utils/category";
import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {GlobalEvent} from "@dtinsight/molecule/esm/common/event";

export default class CategoryService extends GlobalEvent implements ICategoryService {

  private getCategoryViaNode = async (node: {parent_id: string, name?: string}): Promise<any[]> => {
    return await api.getResources({...node});
  }

  public loadRootFolder = () => {
    this.getCategoryViaNode({parent_id: ROOT_CATEGORY_ID}).then(resp => {
      if (!resp || resp.length < 1) {
        return;
      }
      const element = resp[0];

      const treeNode = getTreeNode({
        id: element.id,
        children: [],
        content: element.content,
        disabled: false,
        fileType: "RootFolder",
        isEditable: false,
        isLeaf: false,
        name: element.name
      });
      molecule.folderTree.add(treeNode);
      // 获取当前根目录的下级目录,确保打开Explorer有数据展示
      this.loadTreeNode(element.id)
    });
  }

  public loadTreeNode = async (id: string) => {
    const categoryViaNode = await this.getCategoryViaNode({parent_id: id});
    if (categoryViaNode) {
      const childrenNodes = <molecule.model.TreeNodeModel[]>(
        (categoryViaNode.map((child) =>  getTreeNode({
          id: child.id,
          children: [],
          content: child.content,
          disabled: false,
          fileType: "Folder",
          isEditable: false,
          isLeaf: false,
          name: child.name
        })))
      )
      const source: IFolderTreeNodeProps | null = molecule.folderTree.get(id);
      molecule.folderTree.update({
        id: source?.id ? source.id : '',
        ...source,
        children: childrenNodes
      });
      this.emit('catalogue.update')
    }
    molecule.folderTree.setActive(id);
    molecule.explorer.forceUpdate();

  }

  loadTreeNode1(id: string): void {
  }
}