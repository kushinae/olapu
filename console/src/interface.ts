/**
 * 请求返回体
 */
export interface IErrorBodyProps {
  code: number;
  message: string;
  status: string;
  [key: string]: any;
}

export enum RESOURCE_CATEGORY {

  /**
   * 任务开发
   */
  JOB = 'job',

  /**
   * 资源管理
   */
  RESOURCE = 'resource',

}

export interface IResourceCategory {
  getCategory: () => RESOURCE_CATEGORY;
}