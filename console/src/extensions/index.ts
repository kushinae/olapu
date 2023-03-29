import FolderExtension from "./floder/FolderExtension";
import LocaleExtension from './i18n/LocaleExtension';
import EditorExtension from './editor/EditorExtension';
import MenuBarExtension from './menu/MenuBarExtension';
import InitializeExtension from './init';
import CategoryExtension from './category';
import { IExtension } from "@dtinsight/molecule/esm/model";
import ColorThemeExtensions from "@/extensions/themes";

export const extensions: IExtension[] = [
  new ColorThemeExtensions(),
  new FolderExtension(),
  new LocaleExtension(),
  // new EditorExtension(),
  new MenuBarExtension(),
  new InitializeExtension(),
  // new CategoryExtension()
];