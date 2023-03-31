import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

export default class ColorThemeExtensions implements IExtension {
  id: UniqueId = 'colorTheme';
  name = 'colorTheme';
  activate(extensionCtx: IExtensionService): void {
    // molecule.colorTheme.setTheme('GitHub Plus');
  }
  dispose(extensionCtx: IExtensionService): void {

  };
}