import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";

export const SidebarExtension: IExtension = {
  id: "SidebarExtension",
  name: "SidebarExtension",
  activate: function (extensionCtx: IExtensionService): void {
    alert('SidebarExtension')
  },
  dispose: function (extensionCtx: IExtensionService): void {
    throw new Error("Function not implemented.");
  }
}