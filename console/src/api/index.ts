import { httpClient } from '@/api/http'
import requests from "@/api/requests";
import {CreateResourceParam, LoginParam, RegisterParam} from "@/api/payload";
import {Column, DatasourceInfo, Login, Resource} from "@/api/response";
import {IPage, ISearch} from "@/api/interfaces";

export default {
  /* 注册 */
  async registerAccount(payload: RegisterParam): Promise<string> {
    return httpClient.post<string>(requests.account.register, {
      data: payload
    });
  },

  /* 登陆 */
  async login(payload: LoginParam, callback?: () => void): Promise<Login> {
    return await httpClient.post<Login>(requests.account.login, {
      data: payload
    }, callback);
  },

  /* 获取资源目录 */
  async getResources(payload: {
    parent_id: number,
    name?: string,
  }): Promise<Resource[]> {
    return await httpClient.get(requests.resource.getResources, {
      params: {
        ...payload
      }
    });
  },

  /* 创建资源目录或文件 */
  async createResource(payload: CreateResourceParam): Promise<number> {
    return await httpClient.post(requests.resource.createResource, {
      data: {
        ...payload
      }
    });
  },

  /* 获取数据源列表 */
  async searchDatasource(payload: ISearch<string>): Promise<IPage<DatasourceInfo>> {
    return await httpClient.get(requests.datasource.searchDatasource, {
      params: {
        ...payload
      }
    });
  },

  /* 获取数据库列表 */
  async getDatabases(payload: {
    datasource_id: number;
    all?: boolean;
  }): Promise<string[]> {
    return await httpClient.get(requests.database.getDatabases, {
      params: {
        ...payload
      }
    });
  },

  /* 获取数据库表列表 */
  async getTables(payload: {
    datasource_id: number;
    database?: string;
    all?: boolean;
  }): Promise<string[]> {
    return await httpClient.get(requests.database.getTables, {
      params: {
        ...payload
      }
    });
  },

  /* 获取数据库表列表 */
  async getColumnDetails(payload: {
    datasource_id: number;
    database?: string;
    table: string;
  }): Promise<Column[]> {
    return await httpClient.get(requests.database.getColumnDetails, {
      params: {
        ...payload
      }
    });
  },

  /* 删除资源对象 */
  async deleteResource(payload: {
    id: number;
  }): Promise<void> {
    return await httpClient.delete(requests.resource.delete, {
      params: {
        ...payload
      }
    });
  },
}