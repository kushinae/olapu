import {LoginParam, LoginResult, RegisterParam} from "@/api/interfaces";
import {httpClient} from '@/api/http'
import requests from "@/api/requests";

export default {
  /* 注册 */
  async registerAccount(payload: RegisterParam): Promise<string> {
    return httpClient.post<string>(requests.REGISTER, {
      data: payload
    });
  },

  /* 登陆 */
  async login(payload: LoginParam, callback?: () => void): Promise<LoginResult> {
      return await httpClient.post<LoginResult>(requests.LOGIN, {
        data: payload
      }, callback);
  },

  /* 获取资源目录 */
  async getResources(payload: {
    parent_id: string,
    name?: string,
  }): Promise<any[]> {
    return await httpClient.get(requests.RESOURCE, {
      params: {
        ...payload
      }
    });
  }
}