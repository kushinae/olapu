import {create, Workbench} from "@dtinsight/molecule";
import {extensions} from '@/extensions';
import '@dtinsight/molecule/esm/style/mo.css';
import Login from "@/pages/account/login";

const moInstance = create({
  extensions,
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
