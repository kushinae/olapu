export const BASE_URI = '/api'

export default {
  /* 账户 */
  account: {
    register: `${BASE_URI}/register`,
    login: `${BASE_URI}/login`,
  },

  /* 资源 */
  resource: {
    getResources: `${BASE_URI}/resource`,
    createResource: `${BASE_URI}/resource`,
    delete: `${BASE_URI}/resource`,
  },

  /* 数据源 */
  datasource: {
    searchDatasource: `${BASE_URI}/datasource/search`,
  },

  /* 数据库 */
  database: {
    getDatabases: `${BASE_URI}/database/databases`,
    getTables: `${BASE_URI}/database/tables`,
    getColumnDetails: `${BASE_URI}/database/columns/detail`,
  }
}
