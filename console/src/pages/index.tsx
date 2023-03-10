import { ColorThemeExtensions, EditorExtension, FloderExtension, LocaleExtension, MenuBarExtension } from '@/extensions';
import { create, Workbench } from '@dtinsight/molecule';
import { CategoryExtension } from '@/extensions/category';
import '@dtinsight/molecule/esm/style/mo.css';

const moInstance = create({
  extensions: [
    ColorThemeExtensions,
    LocaleExtension,
    FloderExtension,
    EditorExtension,
    CategoryExtension,
    MenuBarExtension,
  ],
  defaultLocale: 'zh-CN'
});

export default function HomePage() {

  return (
    moInstance.render(<Workbench />)
  );
}
