# RCDancer项目README

Intel[:cloud:](英特尔) | together[:couple:](协作) |document[:floppy_disk:](文档)| code [:coffee:](编码)

#### 项目框架结构详解

---
#### #1.  **RCDancer-FrontEnd**

* 简介:
   集成`Vue`,`Vuex`,`Vuetify`组件库,结合`tensorflow.js`技术的前端单页应用框架
* 目录结构:
```
'    |-- .gitignore',----(ide生成文件)
'    |-- babel.config.js',----(es6转es5插件配置)
'    |-- package-lock.json',----(npm包管理)
'    |-- package.json',----(npm包管理)
'    |-- vue.config.js',----(vue项目配置)
'    |-- public',----(存放公共静态资源)
'    |   |-- index.html',----(SPA应用根节点)
'    |-- src',----(源码文件夹)
'        |-- App.vue',----(根组件)
'        |-- main.js',----(全局配置)
'        |-- Test.vue',----(vue组件单元测试)
'        |-- assets',----(存放静态资源)
'        |   |-- css',
'        |   |-- img',
'        |   |-- video',
'        |-- components',----(存放公用组件)
'        |   |-- custom_related',
'        |   |-- sidebar_related',
'        |   |-- video_related',
'        |-- plugins',----(项目使用的插件)
'        |   |-- vuetify.js',
'        |-- router',----(vue-router路由配置)
'        |   |-- index.js',
'        |-- store',----(vuex全局状态管理)
'        |   |-- index.js',
'        |   |-- status.js',
'        |   |-- modules',
'        |-- views',
```
#### #2.  **RCDancerServer-Flask**

* 简介:
   `python-Flask`微服务`api`,用来处理系统的视频上传.下载.保存等请求,提供前端需要的预处理操作
* 目录结构:
```
'    |-- app.py',----(提供api)
'    |-- __init__.py',
'    |-- core',----(核心core代码包)
'    |   |-- __init__.py',
'    |-- static',
'    |   |-- video', ----(暂时存放视频文件)
'    |       |-- handle',
'    |-- templates',
'    |-- utils',----(存放工具类)
'        |-- Upload2Oss.py',
'        |-- Video.py',
'        |-- __init__.py',
```
#### #3.  **RCDancerServer-SpringBoot**

* 简介:
  集成SpringBoot,SpringMVC,Mybatis,Swagger,Mybatis通用插件,PageHelper插件,JsonWebToken技术,阿里Fastjson以及Druid-SpringBootStarter集成Druid数据库连接池与监控的项目框架.
* 目录结构:
```
'    |-- .gitignore',----(ide配置文件)
'    |-- pom.xml', ----(maven依赖文件)
'    |-- src',----(源代码文件夹)
'        |-- main',
'        |   |-- java',
'        |   |   |-- com',
'        |   |       |-- RCDancer',
'        |   |           |-- Application.java',----(SpringBoot启动程序)
'        |   |           |-- configurer',----(配置文件夹)
'        |   |           |   |-- MybatisConfigurer.java',----(Mybatis统一配置)
'        |   |           |   |-- Swagger2.java',----(Swagger2接口文档框架统一配置)
'        |   |           |   |-- WebMvcConfigurer.java',----(SpringMVC统一配置:拦截器,过滤器)
'        |   |           |-- core',----(项目底层核心代码)
'        |   |           |   |-- AbstractService.java',----(抽象服务层,实现基本功能)
'        |   |           |   |-- Mapper.java',----(抽象Mapper,继承mybatis通用插件)
'        |   |           |   |-- MyCondition.java',----(条件查询类)
'        |   |           |   |-- ProjectConstant.java',----(工程常量)
'        |   |           |   |-- Result.java',----(统一结果响应封装)
'        |   |           |   |-- ResultCode.java',----(响应状态码)
'        |   |           |   |-- ResultGenerator.java',----(请求响应生成类)
'        |   |           |   |-- Service.java',----(服务层父接口,规定基本接口方法)
'        |   |           |   |-- ServiceException.java',----(统一服务异常类)
'        |   |           |-- dao',----(持久化层)
'        |   |           |-- model',----(实体bean)
'        |   |           |-- service',----(服务层,dao层的聚合)
'        |   |           |   |-- impl',----(service实现类,运行时动态注入)
'        |   |           |-- web',----(web控制层,提供restapi)
'        |   |-- resources',
'        |       |-- application-dev.properties',----(开发环境配置)
'        |       |-- application-prod.properties',----(生产环境配置)
'        |       |-- application-test.properties',----(测试环境配置)
'        |       |-- application.properties',----(配置选择)
'        |       |-- rcdancer.sql',----(数据库脚本,供本地测试用)
'        |       |-- mapper',----(mapper文件,crud操作)
'        |-- test',----(测试用例文件夹)
```
#### 部署指南
---
由于生产环境使用linux机器,所以只考虑在linux系统下的部署流程
1. 下载项目到本地
```git
git clone http://git.swcontest.cn/swc_20180160/rcdancer.git
或者直接下载源代码zip压缩到到本地并解压
```
2. 进入`Scrpits`文件夹,执行本地部署脚本
```shell
(注:如果不能执行,请修改赋予文件权限为可执行 `chmod 777 ubuntu_run.sh`)
ubuntu系统请直接使用 ./ubuntu_run.sh 执行脚本,期间可能需要输入密码
centos系统请直接使用 ./cenos_run.sh 执行脚本,期间可能需要输入密码
```
3. 完成部署之后,日志文件将会记录在src同级目录下的`nohup.out`文件中
```
(说明):如果在启动ubuntu_run.sh时,发生了等待现在并且在执行node依赖下载卡顿的情况,请break之后(ctrl+c),重新启动ubuntu_run.sh进行代码的本地部署.(cenos也一样)
(特殊说明:!!!)如果一直出错,可能是您系统的内核版本不支持脚本中的node环境配置安装,如果是这种情况,请自行搭建nodejs+npm环境,然后再重新运行ubuntu_run.sh(cenos也一样)
```
4. 完成部署之后,便可以访问demo:
```
使用http协议访问http://localhost:8080(若端口被占用,请查看nohup.out启动文件中调整的启动端口)
便可以查看项目初步原型
```
5. 您同时也可以直接查看在线demo,免除部署的步骤
([RCDancer在线demo](http://120.79.206.32:8080))
#### 技术选型&文档
---
- Spring Boot（[查看Spring Boot学习&使用指南](http://www.jianshu.com/p/1a9fd8936bd8)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatis通用Mapper插件（[查看官方中文文档](https://mapperhelper.github.io/docs/)）
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- Fastjson（[查看官方中文文档](https://github.com/Alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5)）