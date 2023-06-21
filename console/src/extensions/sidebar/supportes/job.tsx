import {ISidebarPane} from "@dtinsight/molecule/esm/model";
import {Sidebar} from "@/commons/constant";
import {Job} from "@/components/sidebar/job/job";

export const JobPane: ISidebarPane = {
  id: Sidebar.Job.id,
  title: Sidebar.Job.title,
  render: () => {
    return <Job />
  }
}