import requests from "@/api/requests";
import request from "umi-request";

export default {
  // 注册
  registerAccount(payload?: any) {
    request.post(requests.REGISTER, {
      data: {
        ...payload
      }
    }).then((resp: {id: string}) => {
      console.log(resp.id)
    })
  }
}