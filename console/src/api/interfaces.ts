export interface RegisterParam {
  username: string,
  nickname: string,
  password: string,
}

export interface LoginParam {
  username: string,
  password: string,
}

export interface LoginResult {
  id: string,
  nickname: string,
  avatar: string,
  access_token: string,
  token_type: string,
}