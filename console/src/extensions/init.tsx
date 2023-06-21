import { IActivityMenuItemProps, IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import { molecule } from "@dtinsight/molecule";
import { logoutStorage, openLoginModal } from "@/pages/account/login";
import { ActivityBar, Constant } from "@/commons/constant";
import { UniqueId } from "@dtinsight/molecule/esm/common/types";
import { DatasourcePane } from "./sidebar/supportes/datasource";
import {JobPane} from "@/extensions/sidebar/supportes/job";
import {jobTree} from "@/service/job_tree";

export const InitializeExtension: IExtension = {
  id: "InitializeExtension",
  name: "Initialize Extension",
  activate(extensionCtx: IExtensionService) {
    initLogin();
    // 初始化左侧菜单侧边栏
    initActiveBar();
    // 初始化左侧边栏
    initSideBar();
    // 初始化任务管理
    jobTree.setEntry(
      <div>没有东西吗</div>
    );
  },
  dispose(extensionCtx: IExtensionService) {

  }
}

const initLogin = () => {
  const nickname = localStorage.getItem(Constant.Authorization.Nickname);
  updateAccountContent(!nickname ? [
    {
      id: 'login',
      name: '去登陆',
      icon: 'log-in',
      onClick: () => openLoginModal(),
    }
  ] : [
    {
      id: 'username',
      disabled: !!nickname,
      icon: 'person',
      name: nickname,
    },
    {
      id: 'divider',
      type: 'divider',
    },
    {
      id: 'logout',
      icon: 'log-out',
      name: '登出',
      onClick: () => {
        logoutStorage();
        window.location.reload();
      },
    },
  ])
}

const updateAccountContent = (contextMenu: IActivityMenuItemProps[]) => {
  const items = molecule.activityBar.getState().data || [];
  const { ACTIVITY_BAR_GLOBAL_ACCOUNT } = molecule.builtin.getConstants();
  const target = items.find((item) => item.id === ACTIVITY_BAR_GLOBAL_ACCOUNT);
  if (target) {
    target.contextMenu = contextMenu
  }
  molecule.activityBar.setState({ data: items })
}

const initActiveBar = () => {
  molecule.activityBar.add(ActivityBar.Datasource);
  molecule.activityBar.add(ActivityBar.Task);
}

const initSideBar = () => {
  molecule.sidebar.add(DatasourcePane);
  molecule.sidebar.add(JobPane);
}
