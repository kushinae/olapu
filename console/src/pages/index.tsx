import { ColorThemeExtensions, EditorExtension, FloderExtension, LocaleExtension } from '@/extensions';
import { CategoryExtension } from '@/extensions/category';
import { create, Workbench } from '@dtinsight/molecule';
import '@dtinsight/molecule/esm/style/mo.css';

const moInstance = create({
  extensions: [
    ColorThemeExtensions,
    LocaleExtension,
    FloderExtension,
    EditorExtension,
    CategoryExtension,
  ],
  defaultLocale: 'zh-CN'
});

export default function HomePage() {

  return (
    moInstance.render(<Workbench />)
  );
}
