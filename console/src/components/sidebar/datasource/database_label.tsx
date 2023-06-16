import React, {useState} from 'react';
import {DatabaseLabelLayout} from "@/components/sidebar/datasource/style";
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
  const [tables, setTables] = useState<string | undefined>();

  const handlerClick = async () => {
    setExpansion(!expansion);
  }

  return (
    <DatabaseLabelLayout key={props.database.toString()}>
      <div className="database" onClick={handlerClick}>
        <div className="icon">
          {expansion ? <molecule.component.Icon type='chevron-down' /> : <molecule.component.Icon type='chevron-right' />}
        </div>
        <div className="logo">
          <TbSchema />
        </div>
        <div className="database">{props.database}</div>
      </div>
    </DatabaseLabelLayout>
  )
}
export default DatabaseLabel;