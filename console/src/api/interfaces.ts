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
  username: string,
  password: string,
}