/**
 * 请求返回体
 */
export interface IResponseBodyProps<T = any> {
  code: number;
  data: T;
  message: string;
  success: boolean;

  [key: string]: any;
}