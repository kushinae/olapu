import molecule from "@dtinsight/molecule";
import {
  ColorThemeMode,
  FileType, FileTypes,
  IExplorerPanelItem,
  IExtension,
  IFolderTreeNodeProps,
  TreeNodeModel
} from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import { Empty } from "antd";
import { uniqueId } from 'lodash';
import { UniqueId } from "@dtinsight/molecule/esm/common/types";

export const FloderExtension: IExtension = {
  id: "FloderExtension",
  name: "Floder Extension",
  activate: function (extensionCtx: IExtensionService): void {

    const currentMode = molecule.colorTheme.getColorThemeMode();

    molecule.folderTree.onLoadData((treeNode) => { })

    // 改默认的初始化无文件样式
    molecule.folderTree.setEntry(
      <div>
        <Empty
          image={Empty.PRESENTED_IMAGE_SIMPLE}
          description={<div style={{ color: currentMode === ColorThemeMode.dark ? '#fff' : '#000' }}>没有数据</div>} />
      </div>
    );

    // 监听面板 Toolbar 单击事件
    molecule.explorer.onPanelToolbarClick(
      (panel: IExplorerPanelItem, toolbarId: string) => {
        console.log('panel', panel);
        console.log('toolbarId', toolbarId)
        // do something
        alert('被点击了呜呜呜')
      }
    );

    molecule.folderTree.onCreate((type: FileType, id?: UniqueId) => {

      const folderTree = molecule.folderTree.getState().folderTree;

      const parentId = typeof id === 'string' ? id : folderTree?.data?.[0]?.id;

      const fileData = new TreeNodeModel({
        id: uniqueId(),
        name: '',
        isLeaf: type === FileTypes.File,
        fileType: type,
        isEditable: true,
        data: type === FileTypes.File ? null : parentId
      });
      molecule.folderTree.add(fileData, parentId);
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
  },
  dispose: function (extensionCtx: IExtensionService): void {
    throw new Error("Function not implemented.");
  }
}