import { defineConfig } from "umi";

export default defineConfig({
  title: 'Olapu | kushinae',
  theme: {
    'primary-color': '#3f87ff',
    'border-radius-base': '0px',
  },
  proxy: {
    '/api': {
      target: 'http://127.0.0.1:8080',
      changeOrigin: true,
      secure: false,
    },
  },
  chainWebpack(config) {
    config.module.rule('mjs-rule').test(/.m?js/).resolve.set('fullySpecified', false);
  },
});
