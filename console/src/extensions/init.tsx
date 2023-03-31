import {IActivityMenuItemProps, IExtension} from "@dtinsight/molecule/esm/model";
import {IExtensionService} from "@dtinsight/molecule/esm/services";
import {molecule} from "@dtinsight/molecule";
import {logoutStorage, openLoginModal} from "@/pages/account/login";
import {Constant} from "@/commons/constant";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

export default class InitializeExtension implements IExtension {
  id: UniqueId = "InitializeExtension";
  name: string = "Initialize Extension";
  activate(extensionCtx: IExtensionService) {
    initLogin();

  }
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
  const {ACTIVITY_BAR_GLOBAL_ACCOUNT} = molecule.builtin.getConstants();
  const target = items.find((item) => item.id === ACTIVITY_BAR_GLOBAL_ACCOUNT);
  if (target) {
    target.contextMenu = contextMenu
  }
  molecule.activityBar.setState({ data: items })
}