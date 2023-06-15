import molecule from "@dtinsight/molecule";
import {
  FileType,
  IExplorerPanelItem,
  IExtension,
  IFolderTreeNodeProps,
} from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {Button, notification} from "antd";
import { UniqueId } from "@dtinsight/molecule/esm/common/types";
import { EmptyFolder } from "@/extensions/folder/style";
import { getTreeNode } from "@/utils/category";
import api from "@/api";
import { randomId } from "@/utils/id";
import {categoryService} from "@/service";

/** 文件树异步加载 */
const onLoadTree = () => {
}

export const FolderExtension: IExtension = {
  id: "FolderExtension",
  name: "FolderExtension",
  activate(extensionCtx: IExtensionService): void {

    // 加载树目录
    onLoadTree();

    // 改默认的初始化无文件样式
    defaultEntity();

    // 监听面板 Toolbar 单击事件
    onPanelToolbarClick()

    // 创建资源对象数据
    createResource();

    // 更新文件/文件夹名称
    onUpdateResourceName();

    // Listen to the remove node event
    molecule.folderTree.onRemove((id?: UniqueId) => {
      // do something
      alert("删除了");
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
  dispose(extensionCtx: IExtensionService): void {
    throw new Error("Function not implemented.");
  },
}

const defaultEntity = () => {
  molecule.folderTree.setEntry(
    <EmptyFolder>
      未初始化,<Button type='link' onClick={() => {
        alert('主打初始化');
      }}>点我</Button>初始化
    </EmptyFolder>
  );
}

const onPanelToolbarClick = () => {
  molecule.explorer.onPanelToolbarClick(
    (panel: IExplorerPanelItem, toolbarId: string) => {
      console.log('panel', panel);
      console.log('toolbarId', toolbarId);
      alert('刷新');
    }
  );
}

const onUpdateResourceName = () => {
  molecule.folderTree.onUpdateFileName(async (resource: IFolderTreeNodeProps) => {
    const {name, data: { parentId }, id} = resource;
    if (!name || name.length > 64) {
      notification.error({ key: 'create', message: '目录名称不得超过64个字符且不为空！' });
      if (molecule.folderTree.get(id)) {
        molecule.folderTree.remove(id);
      }
      return;
    }
    try {
      await api.createResource({
        name: name,
        type: "directory",
        parent_id: parentId
      });
      await categoryService.loadTreeNode(parentId);
      molecule.explorer.forceUpdate();
    } catch (e) {
      molecule.folderTree.remove(id);
    }

  });

}

const createResource = () => {
  molecule.folderTree.onCreate(async (type: FileType, id?: UniqueId) => {
    const parentId = id ? Number(id) : -1;
    console.log(parentId);
    switch (type) {
      case "Folder":
        molecule.folderTree.add(getTreeNode({
          id: randomId(),
          name: '',
          children: undefined,
          data: {
            parentId
          },
          disabled: false,
          fileType: 'Folder',
          isEditable: true,
          isLeaf: false,
        }), parentId);
        break;
      case "File":
        alert("文件" + id);
        break;
      case "RootFolder":
        molecule.folderTree.add(getTreeNode({
          id: 'work_directory',
          name: "工作栏",
          children: undefined,
          data: undefined,
          disabled: false,
          fileType: 'RootFolder',
          isEditable: false,
          isLeaf: false,
        }));
        break;
    }
  });
}