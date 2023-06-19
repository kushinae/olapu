import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {Resource} from "@/api/response";
import {ResourceType} from "@/commons/enums";
import {ROOT_RESOURCE_PARENT_ID} from "@/commons/constant";

export const getTreeNode = (payload: Resource): IFolderTreeNodeProps => {
  return {
    data: {
      parentId: payload.parent_id
    },
    disabled: false,
    icon: undefined,
    id: payload.id.toString(),
    isEditable: false,
    isLeaf: payload.type === ResourceType.file,
    name: payload.name,
    fileType: payload.parent_id === ROOT_RESOURCE_PARENT_ID ? "RootFolder" : payload.type === ResourceType.file ? 'File' : 'Folder'
  };
}