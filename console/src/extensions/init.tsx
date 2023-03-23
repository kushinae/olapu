import {IActivityMenuItemProps, IExtension} from "@dtinsight/molecule/esm/model";
import {IExtensionService} from "@dtinsight/molecule/esm/services";
import {getCookie} from "@/utils/cookie";
import {molecule} from "@dtinsight/molecule";
import React from "react";
import {openLoginModal} from "@/pages/account/login";

export const InitializeExtension: IExtension = {
  id: "InitializeExtension",
  name: "Initialize Extension",
  activate(extensionCtx: IExtensionService) {
    initLogin();
  },
  dispose(extensionCtx: IExtensionService) {

  },
}

const initLogin = () => {
  const nickname = getCookie("nickname");
  updateAccountContent([
    {
      id: 'login',
      name: '去登陆',
      icon: 'log-in',
      onClick: () => openLoginModal(),
    }
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