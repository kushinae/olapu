import React, {useEffect, useState} from 'react';
import {Datasource as DatasourceParent} from "@/components/sidebar/datasource/style";
import DatasourceLabel from "@/components/sidebar/datasource/datasource_label";
import {DatasourceInfo} from "@/api/interfaces";
import api from "@/api";
import {PageConstant} from "@/commons/constant";

interface DatasourceProps {
}

/**
 * 资源目录组件
 * @author bnyte
 * @since 1.0.0
 */
const Datasource: React.FC<DatasourceProps> = () => {

  const [records, setRecords] = useState<DatasourceInfo[] | undefined>();
  const [current, setCurrent] = useState<number>(PageConstant.defaultCurrentPage);
  const [total, setTotal] = useState<number | undefined>();
  const [queryCount, setQueryCount] = useState<number>(PageConstant.defaultQueryCount);
  const [query, setQuery] = useState<string | undefined>();

  /**
   * 钩子函数
   */
  useEffect(() => {
    // 创建之前等
    api.searchDatasource({current, query_count: queryCount, q: query}).then(r => {
      setRecords(r.records);
      setTotal(r.total);
    });
    return () => {
      // return出来的函数本来就是更新前，销毁前执行的函数，现在不监听任何状态，所以只在销毁前执行
    };
  }, []);
  return (
    <DatasourceParent className='datasource_container'>
      <div className='datasource_content'>
        {
          records?.map(e => <DatasourceLabel key={e.id} id={e.id} name={e.name} />)
        }
      </div>
    </DatasourceParent>
  )
}
export default Datasource;