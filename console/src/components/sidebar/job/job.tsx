import React from "react";
import {Resource} from "@/components/resource";
import {IActionBarItemProps} from "@dtinsight/molecule/esm/components";
import molecule from "@dtinsight/molecule";

interface JobProps {

}

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

const jobManager: molecule.model.IActivityBarItem = {
  id: 'task',
  icon: 'package',
  name: '任务管理',
  title: '任务管理',
};

const Job: React.FC<JobProps> = () => {
  return (
    <>
      <Resource
        resource={{headerToolBar: headerToolBar, panel: jobManager}}
        title='任务管理'
      />
    </>
  );
}

export {Job};