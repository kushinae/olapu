import { ISidebarPane } from "@dtinsight/molecule/esm/model";
import { Sidebar } from "@/commons/constant";
import {Datasource} from "@/components/sidebar/datasource/datasource";
import molecule from "@dtinsight/molecule";
import {IActionBarItemProps} from "@dtinsight/molecule/esm/components";

const headerToolBar: IActionBarItemProps[] = [
  {
    id: 'refresh',
    title: '刷新',
    icon: 'refresh',
  },
  {
    id: 'menus',
    title: '更多操作',
    icon: 'menu',
    contextMenu: [],
  },
];

const datasourceManager: molecule.model.IActivityBarItem = {
  id: 'Datasource',
  icon: 'package',
  name: '数据源管理',
  title: '数据源管理',
};

export const DatasourcePane: ISidebarPane = {
  id: Sidebar.Datasource.id,
  title: Sidebar.Datasource.title,
  render: () => {
    return <Datasource resource={{headerToolBar: headerToolBar, panel: datasourceManager}}/>
  }
}