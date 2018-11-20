const path = require('path')
module.exports = {
  baseUrl: '/',
  outputDir: 'dist',
  lintOnSave: true,
  productionSourceMap: false,
  css: {
    sourceMap: false,
    modules: false,
    loaderOptions: {
      stylus: {
        import: [path.resolve(__dirname, 'src/assets/css') + '/*styl']
      }
    }
  }
}
