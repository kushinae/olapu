export interface ICategoryService {

  /** 加载目录树的根目录 */
  loadRootFolder: () => void;

  /**
   * 获取目录树的子节点
   * @param id 需要加载子节点的父节点ID
   */
  loadTreeNode: (id: string) => void;

  /**
   * 获取目录树的子节点
   * @param id 需要加载子节点的父节点ID
   */
  loadTreeNode1: (id: string) => void;
}