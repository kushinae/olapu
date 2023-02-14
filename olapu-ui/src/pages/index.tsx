import { ColorThemeExtensions, EditorExtension, FloderExtension, LocaleExtension } from '@/extensions';
import molecule, { create, Workbench } from '@dtinsight/molecule';
import '@dtinsight/molecule/esm/style/mo.css';

const moInstance = create({
  extensions: [
    ColorThemeExtensions,
    LocaleExtension,
    FloderExtension,
    EditorExtension,
  ],
  defaultLocale: 'zh-CN'
});

export default function HomePage() {

  return (
    moInstance.render(<Workbench />)
  );
}
