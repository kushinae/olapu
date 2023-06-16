import { ISidebarPane } from "@dtinsight/molecule/esm/model";
import { Sidebar } from "@/commons/constant";
import Datasource from "@/components/sidebar/datasource/datasource";

export const DatasourcePane: ISidebarPane = {
  id: Sidebar.Datasource.id,
  title: Sidebar.Datasource.title,
  render: () => {
    return <Datasource />
  }
}