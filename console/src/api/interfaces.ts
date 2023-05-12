export interface RegisterParam {
  username: string,
  nickname: string,
  password: string,
}

export interface LoginParam {
  username: string,
  password: string,
}

export interface CreateResourceParam {
  name: string,
  type: 'directory' | 'file',
  parent_id: string | 'ROOT',
  content?: string
}

export interface LoginResult {
  id: string,
  nickname: string,
  avatar: string,
  access_token: string,
  token_type: string,
}