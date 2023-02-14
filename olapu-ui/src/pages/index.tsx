import molecule, { create, Workbench } from '@dtinsight/molecule';
import '@dtinsight/molecule/esm/style/mo.css';
import { Button, Empty } from 'antd';
import uniqueId from 'lodash';

const moInstance = create({
  extensions: [],
});

// 设置默认系统语言
molecule.i18n.setCurrentLocale('zh-CN');
molecule.colorTheme.setTheme('GitHub Plus');

// molecule.folderTree.setEntry(
//   <div>
//     <Empty
//       image={Empty.PRESENTED_IMAGE_SIMPLE}
//       description={<div style={{ color: 'pink' }}>没有数据</div>} />
//   </div>
// );



export default function HomePage() {
  return (
    moInstance.render(<Workbench />)
  );
}
