import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

export default class LocaleExtension implements IExtension {
  id: UniqueId = "LocaleExtension";
  name: string = "LocaleExtension";
  activate (extensionCtx: IExtensionService): void {

  }
  dispose (extensionCtx: IExtensionService): void {

  }
}