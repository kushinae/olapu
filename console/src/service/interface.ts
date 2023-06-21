import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {RESOURCE_CATEGORY} from "@/interface";

export interface ICategoryService {

  /** 加载目录树的根目录 */
  loadRootFolder: () => Promise<void>;

  /**
   * 获取目录树的子节点
   * @param id 需要加载子节点的父节点ID
   */
  loadTreeNode: (id: number, category: RESOURCE_CATEGORY) => Promise<IFolderTreeNodeProps[] | undefined>;

}