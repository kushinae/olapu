import React, {useState} from 'react';
import {DatabaseLabelLayout} from "@/components/sidebar/datasource/style";
import molecule from '@dtinsight/molecule';
import {TbSchema} from 'react-icons/tb';
import api from "@/api";
import TableLabel from "@/components/sidebar/datasource/table_label";

interface DatabaseLabelProps {
  database: string;
  datasourceId: number;
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
  const [tables, setTables] = useState<string[] | undefined>();

  const handlerClick = async () => {
    setExpansion(!expansion);
    const tables = await api.getTables({datasource_id: props.datasourceId, database: props.database});
    setTables(tables);
  }

  return (
    <DatabaseLabelLayout>
      <div className="database" onClick={handlerClick}>
        <div className="icon">
          {expansion ? <molecule.component.Icon type='chevron-down' /> : <molecule.component.Icon type='chevron-right' />}
        </div>
        <div className="logo">
          <TbSchema />
        </div>
        <div className="database">{props.database}</div>
      </div>
      <div className="table">
        {expansion ? tables?.map(e => <TableLabel key={e} table={e} database={props.database} datasourceId={props.datasourceId} />) : <></>}
      </div>
    </DatabaseLabelLayout>
  )
}
export default DatabaseLabel;