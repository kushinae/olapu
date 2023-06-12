import { FolderExtension } from "./folder/FolderExtension";
import { LocaleExtension } from './i18n/LocaleExtension';
// import { EditorExtension } from './editor/EditorExtension';
import { MenuBarExtension } from './menu/MenuBarExtension';
import { InitializeExtension } from './init';
import { CategoryExtension } from './category';
import { IExtension } from "@dtinsight/molecule/esm/model";
import { ColorThemeExtensions } from "@/extensions/themes";
import { ActivityExtension } from "./activity";

export const extensions: IExtension[] = [
  LocaleExtension,
  ColorThemeExtensions,
  InitializeExtension,
  CategoryExtension,
  // new EditorExtension(),
  FolderExtension,
  MenuBarExtension,
  ActivityExtension
];