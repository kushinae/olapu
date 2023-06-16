import React, {useState} from 'react';
import { DatasourceLabelLayout } from "@/components/sidebar/datasource/style";
import molecule from '@dtinsight/molecule';
import {TbBrandMysql} from 'react-icons/tb';
import api from "@/api";
import DatabaseLabel from "@/components/sidebar/datasource/database_label";

interface DatasourceLabelProps {
  id: number;
  name: string;
  expansion?: boolean;
}

/**
 * 资源目录组件
 * @author bnyte
 * @since 1.0.0
 */
const DatasourceLabel: React.FC<DatasourceLabelProps> = (props, context) => {

  /* 当前资源是否展开 */
  const [expansion, setExpansion] = useState<boolean>(!!props?.expansion);
  const [loading, setLoading] = useState<boolean>(false);
  const [databases, setDatabases] = useState<string[] | undefined>();

  const handlerClick = async () => {
    if (!expansion) {
      setLoading(true);
      const databases = await api.getDatabases({datasource_id: props.id});
      setDatabases(databases);
      setLoading(false);
    }
    setExpansion(!expansion);
  }

  return (
    <DatasourceLabelLayout key={props?.id?.toString()}>
      <div className="datasource" onClick={handlerClick}>
        <div className="icon">
          {expansion ? <molecule.component.Icon type='chevron-down' /> : <molecule.component.Icon type='chevron-right' />}
        </div>
        <div className="logo">
          <TbBrandMysql />
        </div>
        <div className="name">{props.name}</div>
      </div>
      {expansion ? databases?.map(e => <div className="database">
        <DatabaseLabel database={e} />
      </div>) : <></>}
    </DatasourceLabelLayout>
  )
}
export default DatasourceLabel;