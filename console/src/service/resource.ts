import {ICategoryService} from "@/service/interface";
import api from "@/api";
import {ROOT_RESOURCE_PARENT_ID} from "@/commons/constant";
import molecule from "@dtinsight/molecule";
import {getTreeNode} from "@/utils/resource";
import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {GlobalEvent} from "@dtinsight/molecule/esm/common/event";
import {Resource} from "@/api/response";

export default class ResourceCategoryService extends GlobalEvent implements ICategoryService {

  private getResourceNodes = async (node: { parent_id: number, name?: string }): Promise<Resource[]> => {
    return await api.getResources({ ...node });
  }

  public loadRootFolder = async () => {
    const resources = await this.getResourceNodes({ parent_id: ROOT_RESOURCE_PARENT_ID });
    if (!resources || resources.length < 1) {
      return;
    }
    const treeNode = getTreeNode(resources[0]);
    // 加载根目录数据, 方式没有数据
    treeNode.children = await this.loadTreeNode(resources[0].id);
    molecule.folderTree.add(treeNode);
  }

  public loadTreeNode = async (id: number): Promise<IFolderTreeNodeProps[] | undefined> => {
    const resources = await this.getResourceNodes({ parent_id: id });
    if (resources) {
      return resources.map(child => getTreeNode(child));
    }
  };
}