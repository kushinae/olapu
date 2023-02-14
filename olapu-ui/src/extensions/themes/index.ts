import molecule from "@dtinsight/molecule";
import { UniqueId } from "@dtinsight/molecule/esm/common/types";
import { IContribute, IExtension, IExtensionType } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";

export const ColorThemeExtensions: IExtension = {
  id: 'colorTheme',
  name: 'color theme',
  activate(extensionCtx: IExtensionService): void {
    molecule.colorTheme.setTheme('GitHub Plus');
  },
  dispose(extensionCtx: IExtensionService): void {

  },
}