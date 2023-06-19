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