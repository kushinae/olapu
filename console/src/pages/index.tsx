import molecule, { create, Workbench } from "@dtinsight/molecule";
import { extensions } from '@/extensions';
import '@dtinsight/molecule/esm/style/mo.css';
import Login from "@/pages/account/login";
import { randomId } from "@/utils/id";

const moInstance = create({
  extensions,
  defaultLocale: 'zh-CN'
});

alert(randomId())

moInstance.onBeforeInit(() => {
  molecule.builtin.inactiveModule('builtInOutputPanel');
  molecule.builtin.inactiveModule('FOLDER_PANEL_CONTEXT_MENU');
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
