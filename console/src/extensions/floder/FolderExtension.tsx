import molecule from "@dtinsight/molecule";
import {
  FileType, FileTypes,
  IExplorerPanelItem,
  IExtension,
  IFolderTreeNodeProps,
  TreeNodeModel
} from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {Empty, message} from "antd";
import { uniqueId } from 'lodash';
import { UniqueId } from "@dtinsight/molecule/esm/common/types";
import {Constant} from "@/commons/constant";

export default class FolderExtension implements IExtension {
  id: UniqueId = "FolderExtension";
  name: string = "FolderExtension";
  activate (extensionCtx: IExtensionService): void {

    molecule.folderTree.onLoadData((treeNode) => { })

    // 改默认的初始化无文件样式
    molecule.folderTree.setEntry(
      <div>
        没有数据
      </div>
    );

    // 监听面板 Toolbar 单击事件
    molecule.explorer.onPanelToolbarClick(
      (panel: IExplorerPanelItem, toolbarId: string) => {
        console.log('panel', panel);
        console.log('toolbarId', toolbarId)
        alert('被点击了呜呜呜')
      }
    );

    molecule.folderTree.onCreate(async (type: FileType, id?: UniqueId) => {

    });
    // Listen to the remove node event
    molecule.folderTree.onRemove((id?: UniqueId) => {
      // do something
    });

    // Listen to the select node event
    molecule.folderTree.onSelectFile((file: IFolderTreeNodeProps) => {
      molecule.editor.open({
        id: file.id,
        name: file.name,
        data: {
          value: file.data,
          language: file.name?.substring(file.name?.lastIndexOf(".") + 1),
        },
      });
    });
  }
  dispose (extensionCtx: IExtensionService): void {
    throw new Error("Function not implemented.");
  }
}