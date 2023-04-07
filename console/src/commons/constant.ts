import { IActivityBarItem } from "@dtinsight/molecule/esm/model";

export class Constant {
  public static Authorization = {
    X_Access_Token: 'X-Access-Token',
    Nickname: 'nickname',
    Avatar: 'avatar',
    Header: 'Authorization',
  }
  static ActivityBar: any;
}

export const ActivityBar = {
  DataSourceId: <string>'datasource',
  LowCodeId: <string>'lowcode',
  DataSourceActivityBar: <IActivityBarItem>{
    id: 'datasource',
    title: '数据源',
    icon: 'database',
  },
  LowCodeActivityBar: <IActivityBarItem>{
    id: 'lowcode',
    title: '低代码',
    icon: 'code',
  }
}

export const SUPPORTED_LANGUAGES = ['java', 'sql'] as const;

export const ROOT_CATEGORY_ID = 'ROOT';

