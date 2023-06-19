interface Login {
  id: string,
  nickname: string,
  avatar: string,
  access_token: string,
  token_type: string,
}

interface DatasourceInfo {
  id: number;
  name: string;
  type: DatasourceType;
}

interface Column {
  name: string;
  comment: string;
  datatype: string;
  typename: string;
}

interface Resource {
  id: number;
  type: ResourceType;
  name: string;
  content?: string;
  uid: string;
  parent_id: number;
}

export {Login, DatasourceInfo, Column, Resource};