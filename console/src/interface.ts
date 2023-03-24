/**
 * 请求返回体
 */
export interface IErrorBodyProps {
  code: number;
  message: string;
  status: string;
  [key: string]: any;
}