import React, {useState} from 'react';
import {TableLabelLayout} from "@/components/sidebar/datasource/style";
import molecule from '@dtinsight/molecule';
import {TbSchema} from 'react-icons/tb';

interface DatabaseLabelProps {
  database: string;
}

/**
 * 资源目录组件
 * @author bnyte
 * @since 1.0.0
 */
const DatabaseLabel: React.FC<DatabaseLabelProps> = (props, context) => {

  /* 当前资源是否展开 */
  const [expansion, setExpansion] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(false);

  const handlerClick1 = async () => {
    setExpansion(!expansion);
  }

  return (
    <TableLabelLayout key={props.database.toString()} onClick={handlerClick1}>
      <div className="database">
        <div className="icon">
          {expansion ? <molecule.component.Icon type='chevron-down' /> : <molecule.component.Icon type='chevron-right' />}
        </div>
        <div className="logo">
          <TbSchema />
        </div>
        <div className="database">{props.database}</div>
      </div>
    </TableLabelLayout>
  )
}
export default DatabaseLabel;