export interface ISearch<T> {
  current: number;
  query_count: number;
  q?: T;
}

export interface IPage<T> {
  current: number;
  query_count: number;
  total: number;
  records?: T[]
}

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
  parent_id: number | -1,
  content?: string
}

export interface LoginResult {
  id: string,
  nickname: string,
  avatar: string,
  access_token: string,
  token_type: string,
}

export interface DatasourceInfo {
  id: number;
  name: string;
  type: DatasourceType;
}