import {IExtension} from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";
import {categoryService} from "@/service";

export default class CategoryExtension implements IExtension {
  id: UniqueId = "CategoryExtension";
  name: string = "CategoryExtension";
  activate (extensionCtx: IExtensionService): void {
    categoryService.loadRootFolder();
  }
  dispose (extensionCtx: IExtensionService): void {

  }
}