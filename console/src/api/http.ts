import {extend, ResponseError} from "umi-request";
import {IErrorBodyProps} from "@/interface";
import {message} from "antd";
import {res} from "pino-std-serializers";
import exp from "constants";

const umiRequest = extend({
  timeout: 3000,
  headers: {

  },
  errorHandler: async (error: ResponseError<IErrorBodyProps>) => {
    await message.error(error.data.message);
  },
})
class Request {
  post<T> (url: any, body?: any, config: Record<string, any> = {}) {
    umiRequest.post(url, {
      data: {...body}
    }).then(resp => {
      return resp.data
    }).catch(error => {
      return undefined;
    })
    return undefined;
  }
}

export default new Request();