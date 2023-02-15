import molecule from "@dtinsight/molecule";
import { UniqueId } from "@dtinsight/molecule/esm/common/types";
import { ColorThemeMode, FileType, IExplorerPanelItem, IExtension, IFolderTreeNodeProps } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import { Empty } from "antd";

export const FloderExtension: IExtension = {
  id: "FloderExtension",
  name: "Floder Extension",
  activate: function (extensionCtx: IExtensionService): void {

    const currentMode = molecule.colorTheme.getColorThemeMode();

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
      molecule.editor.open({
        id: 'test',
        name: 'test.java',
        data: {
          value: 'select * from test',
          language: 'java',
        },
      });
    });

    // Listen to the remove node event
    molecule.folderTree.onRemove((id?: UniqueId) => {
      // do something
    });

    // Listen to the select node event
    molecule.folderTree.onSelectFile((file: IFolderTreeNodeProps) => {
      // do something
    });


  },
  dispose: function (extensionCtx: IExtensionService): void {
    throw new Error("Function not implemented.");
  }
}