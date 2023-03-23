import {defineConfig} from "umi";

export default defineConfig({
  title: 'Olapu | kushinae',
  // favicon: 'images/favicon.png',
  hash: true,
  publicPath: '/',
  base: './',
  ignoreMomentLocale: true,
  targets: {
    ios: false,
  },
  // routes: [
  //   {
  //     path: '/',
  //     component: '@/layout/index',
  //     routes: [
  //       {
  //         path: '/',
  //         component: '@/pages/index',
  //       },
  //     ],
  //   },
  // ],
  chainWebpack(memo, { env }) {
    memo.output.globalObject('this').set('globalObject', 'this');
    memo.entry('sparksql.worker').add('monaco-sql-languages/out/esm/sparksql/sparksql.worker.js');
    memo.entry('sql.worker').add('monaco-sql-languages/out/esm/sql/sql.worker.js');
    memo.entry('hivesql.worker').add('monaco-sql-languages/out/esm/hivesql/hivesql.worker.js');
    memo.entry('mysql.worker').add('monaco-sql-languages/out/esm/mysql/mysql.worker.js');
    memo.entry('flinksql.worker').add('monaco-sql-languages/out/esm/flinksql/flinksql.worker.js');

    const isDev = env === 'development';
    if (!isDev) {
      // ignore *.worker.js hash
      memo.output.set('filename', (pathData: any) => {
        return pathData.chunk.name.endsWith('.worker') ? '[name].js' : `[name].[contenthash:8].js`;
      });
    }
    return memo;
  },
  theme: {
    'primary-color': '#3f87ff',
    'border-radius-base': '0px',
  },
  proxy: {
    '/api': {
      target: 'http://127.0.0.1:8081',
      changeOrigin: true,
      secure: false,
    },
  },
});
