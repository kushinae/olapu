import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

export default class LocaleExtension implements IExtension {
  id: UniqueId = "LocaleExtension";
  name: string = "Locale Extension";
  activate (extensionCtx: IExtensionService): void {

  }
  dispose (extensionCtx: IExtensionService): void {

  }
}