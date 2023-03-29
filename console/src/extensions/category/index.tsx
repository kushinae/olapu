import { FileTypes, IExtension, TreeNodeModel } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import molecule from "@dtinsight/molecule";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

export default class CategoryExtension implements IExtension {
  id: UniqueId = "CategoryExtension";
  name: string = "Category Extension";
  activate (extensionCtx: IExtensionService): void {
    molecule.folderTree.add(new TreeNodeModel({
      id: "root",
      name: "根节点",
      isLeaf: false,
      fileType: FileTypes.RootFolder,
      isEditable: false,
      data: "root",
      children: []
    }));

    molecule.folderTree.onLoadData((treeNode, callback) => {
      callback(treeNode);
    })
  }
  dispose (extensionCtx: IExtensionService): void {

  }
}