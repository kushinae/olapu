import {
  ColorThemeExtensions,
  EditorExtension,
  FloderExtension,
  InitializeExtension,
  LocaleExtension,
  MenuBarExtension
} from '@/extensions';
import { create, Workbench } from '@dtinsight/molecule';
import { CategoryExtension } from '@/extensions/category';
import '@dtinsight/molecule/esm/style/mo.css';
import Login from "@/pages/account/login";

const moInstance = create({
  extensions: [
    ColorThemeExtensions,
    LocaleExtension,
    FloderExtension,
    EditorExtension,
    CategoryExtension,
    MenuBarExtension,
    InitializeExtension
  ],
  defaultLocale: 'zh-CN'
});

const MoleculeProvider = () => moInstance.render(<Workbench />);

export default function HomePage() {

  return (
    <>
      <MoleculeProvider />
      <Login />
    </>
  );
}
