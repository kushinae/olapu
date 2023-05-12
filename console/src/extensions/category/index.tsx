import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import { categoryService } from "@/service";

export const CategoryExtension: IExtension = {
  id: "CategoryExtension",
  name: "CategoryExtension",
  activate(extensionCtx: IExtensionService): void {
    categoryService.loadRootFolder();
  },
  dispose(extensionCtx: IExtensionService): void {

  }
}