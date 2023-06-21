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
  Job: <IComponentIdItem>{
    id: <string>'task',
    title: <string>'低代码',
    icon: <string>'checklist'
  }
}
const ActivityBar = {
  Datasource: <IActivityBarItem>{
    id: ComponentId.Datasource.id,
    title: ComponentId.Datasource.title,
    icon: ComponentId.Datasource.icon,
  },
  Task: <IActivityBarItem>{
    id: ComponentId.Job.id,
    title: ComponentId.Job.title,
    icon: ComponentId.Job.icon,
  }
}
const Sidebar = {
  Datasource: <ISidebarPane>{
    id: ComponentId.Datasource.id,
    title: ComponentId.Datasource.title,
    icon: ComponentId.Datasource.icon,
  },
  Job: <ISidebarPane>{
    id: ComponentId.Job.id,
    title: ComponentId.Job.title,
    icon: ComponentId.Job.icon,
  }
}

const PageConstant = {
  defaultCurrentPage: 1,
  defaultQueryCount: 10,
}
const SUPPORTED_LANGUAGES = ['java', 'sql'] as const;

const ROOT_RESOURCE_PARENT_ID = -1;

export { Constant, ComponentId, ActivityBar, Sidebar, PageConstant, SUPPORTED_LANGUAGES, ROOT_RESOURCE_PARENT_ID }
