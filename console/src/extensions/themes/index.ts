import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";

export const ColorThemeExtensions: IExtension = {
  id: 'colorTheme',
  name: 'colorTheme',
  activate(extensionCtx: IExtensionService): void {
    // molecule.colorTheme.setTheme('GitHub Plus');
  },
  dispose(extensionCtx: IExtensionService): void {

  }
}