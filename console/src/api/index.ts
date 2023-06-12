import { CreateResourceParam, LoginParam, LoginResult, RegisterParam } from "@/api/interfaces";
import { httpClient } from '@/api/http'
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
    parent_id: number,
    name?: string,
  }): Promise<any[]> {
    return await httpClient.get(requests.RESOURCE, {
      params: {
        ...payload
      }
    });
  },

  /* 创建资源目录或文件 */
  async createResource(payload: CreateResourceParam): Promise<number> {
    return await httpClient.post(requests.RESOURCE, {
      data: {
        ...payload
      }
    });
  }
}