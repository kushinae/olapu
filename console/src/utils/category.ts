import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {ICategoryProps} from "@/utils/interface";

export const getTreeNode = (payload: ICategoryProps): IFolderTreeNodeProps => {
  return {
    ...payload
  };
}