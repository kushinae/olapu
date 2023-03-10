import { FileTypes, IExtension, TreeNodeModel } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import molecule from "@dtinsight/molecule";

export const CategoryExtension: IExtension = {
  id: "CategoryExtension",
  name: "Category Extension",
  activate: function (extensionCtx: IExtensionService): void {
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
  },
  dispose: function (extensionCtx: IExtensionService): void {

  }
}