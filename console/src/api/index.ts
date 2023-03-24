import {LoginParam, LoginResult, RegisterParam} from "@/api/interfaces";
import request from '@/api/http'
import requests from "@/api/requests";

export default {
  /* 注册 */
  registerAccount(payload: RegisterParam): string | undefined {
    return request.post<string>(requests.REGISTER, payload);
  },

  /* 登陆 */
  login(payload: LoginParam) {
    return request.post<LoginResult>(requests.LOGIN, payload);
  }
}