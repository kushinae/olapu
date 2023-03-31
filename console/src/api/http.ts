import request, {extend, RequestMethod, RequestOptionsInit, ResponseError} from "umi-request";
import {IErrorBodyProps} from "@/interface";
import {message} from "antd";
import {Constant} from "@/commons/constant";

class Http {

  private request: RequestMethod = request;
  private errorCallback: (() => void) | undefined;

  constructor() {
    this.request = extend({
      timeout: 3000,
      headers: {

      },
      errorHandler: async (error: ResponseError<IErrorBodyProps>) => {
        if (error) {
          await message.error(error.data.message);
          if (this.errorCallback) {
            this.errorCallback();
          }
          throw new Error(error.data.message);
        }
      },
    });

    this.request.interceptors.request.use((url: string, options: RequestOptionsInit) => {
      const headers = localStorage.getItem(Constant.Authorization.X_Access_Token)
        ? {
          Authorization: `Bearer ${localStorage.getItem(Constant.Authorization.X_Access_Token)}`
        }
        : new Headers(options.headers);
      console.log('added headers', headers);
      return {
        url,
        options: {
          ...options,
          headers
        }
      }
    }, {global: false})
  };

  post<T>(url: string, options?: RequestOptionsInit, errorCallback?: () => void): Promise<T> {
    if (errorCallback) {
      this.errorCallback = errorCallback;
    }
    return this.request.post<T>(url, options);
  }
}


export const httpClient = new Http();