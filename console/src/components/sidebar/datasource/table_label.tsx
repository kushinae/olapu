import React, { useState } from 'react';
import { TableLabelLayout } from "@/components/sidebar/datasource/style";
import molecule from '@dtinsight/molecule';
import { TbTable } from 'react-icons/tb';
import ColumnLabel from "@/components/sidebar/datasource/column_label";
import api from "@/api";
import { Column } from '@/api/response';

interface TableLabelProps {
  database: string;
  table: string;
  datasourceId: number;
}

/**
 * 资源目录组件
 * @author bnyte
 * @since 1.0.0
 */
const TableLabel: React.FC<TableLabelProps> = (props, context) => {

  /* 当前资源是否展开 */
  const [expansion, setExpansion] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(false);
  const [columns, setColumns] = useState<Column[] | undefined>();

  const handlerClick = async () => {
    setExpansion(!expansion);
    const columnDetails = await api.getColumnDetails({ datasource_id: props.datasourceId, database: props.database, table: props.table });
    setColumns(columnDetails);
  }

  return (
    <TableLabelLayout>
      <div className="table" onClick={handlerClick}>
        <div className="icon">
          {expansion ? <molecule.component.Icon type='chevron-down' /> : <molecule.component.Icon type='chevron-right' />}
        </div>
        <div className="logo">
          <TbTable />
        </div>
        <div className="table">{props.table}</div>
      </div>
      <div className="column">
        {
          expansion ? columns?.map(e => <ColumnLabel key={e.name} database={props.database} table={props.table} datasourceId={props.datasourceId} column={e} />) : <></>
        }
      </div>
    </TableLabelLayout>
  )
}
export default TableLabel;