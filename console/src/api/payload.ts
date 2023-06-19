interface RegisterParam {
  username: string,
  nickname: string,
  password: string,
}

interface LoginParam {
  username: string,
  password: string,
}

interface CreateResourceParam {
  name: string,
  type: 'directory' | 'file',
  parent_id: number | -1,
  content?: string
}

export {RegisterParam, LoginParam, CreateResourceParam};