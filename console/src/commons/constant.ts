import { IActivityBarItem, ISidebarPane } from "@dtinsight/molecule/esm/model";

interface IComponentIdItem {
  id: string,
  title: string,
  icon: string,
}

class Constant {
  public static Authorization = {
    X_Access_Token: 'X-Access-Token',
    Nickname: 'nickname',
    Avatar: 'avatar',
    Header: 'Authorization',
  }
}
const ComponentId = {
  Datasource: <IComponentIdItem>{
    id: <string>'datasource',
    title: <string>'数据源',
    icon: <string>'database'
  },
  LowCode: <IComponentIdItem>{
    id: <string>'code.low',
    title: <string>'低代码',
    icon: <string>'code'
  }
}
const ActivityBar = {
  Datasource: <IActivityBarItem>{
    id: ComponentId.Datasource.id,
    title: ComponentId.Datasource.title,
    icon: ComponentId.Datasource.icon,
  },
  LowCode: <IActivityBarItem>{
    id: ComponentId.LowCode.id,
    title: ComponentId.LowCode.title,
    icon: ComponentId.LowCode.icon,
  }
}
const Sidebar = {
  Datasource: <ISidebarPane>{
    id: ComponentId.Datasource.id,
    title: ComponentId.Datasource.title,
    icon: ComponentId.Datasource.icon,
  },
  LowCode: <ISidebarPane>{
    id: ComponentId.LowCode.id,
    title: ComponentId.LowCode.title,
    icon: ComponentId.LowCode.icon,
  }
}

const PageConstant = {
  defaultCurrentPage: 1,
  defaultQueryCount: 10,
}
const SUPPORTED_LANGUAGES = ['java', 'sql'] as const;

const ROOT_RESOURCE_PARENT_ID = -1;

export { Constant, ComponentId, ActivityBar, Sidebar, PageConstant, SUPPORTED_LANGUAGES, ROOT_RESOURCE_PARENT_ID }
