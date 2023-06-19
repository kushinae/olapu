import React, { useState } from 'react';
import { ColumnLabelLayout } from "@/components/sidebar/datasource/style";
import molecule from '@dtinsight/molecule';
import { TbColumns } from 'react-icons/tb';
import { Column } from '@/api/response';


interface ColumnProps {
  database: string;
  table: string;
  datasourceId: number;
  column: Column;
}

/**
 * 资源目录组件
 * @author bnyte
 * @since 1.0.0
 */
const ColumnLabel: React.FC<ColumnProps> = (props, context) => {

  /* 当前资源是否展开 */
  const [expansion, setExpansion] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(false);

  const handlerClick = async () => {
    setExpansion(!expansion);
  }

  return (
    <ColumnLabelLayout>
      <div className="column">
        <div className="icon">
          {expansion ? <molecule.component.Icon type='chevron-down' /> : <molecule.component.Icon type='chevron-right' />}
        </div>
        <div className="logo">
          <TbColumns />
        </div>
        <div className="column-detail">{props.column.name}
          <span className="datatype">
            &nbsp;({props.column.typename})
          </span>
        </div>
      </div>
    </ColumnLabelLayout>
  )
}
export default ColumnLabel;