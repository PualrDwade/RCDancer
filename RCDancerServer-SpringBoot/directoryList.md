|-- undefined
    |-- .gitignore
    |-- pom.xml
    |-- src
        |-- main
        |   |-- java
        |   |   |-- com
        |   |       |-- RCDancer
        |   |           |-- Application.java
        |   |           |-- configurer
        |   |           |   |-- MybatisConfigurer.java
        |   |           |   |-- Swagger2.java
        |   |           |   |-- WebMvcConfigurer.java
        |   |           |-- core
        |   |           |   |-- AbstractService.java
        |   |           |   |-- Mapper.java
        |   |           |   |-- MyCondition.java
        |   |           |   |-- ProjectConstant.java
        |   |           |   |-- Result.java
        |   |           |   |-- ResultCode.java
        |   |           |   |-- ResultGenerator.java
        |   |           |   |-- Service.java
        |   |           |   |-- ServiceException.java
        |   |           |-- dao
        |   |           |   |-- UserDetailMapper.java
        |   |           |   |-- UserLoginMapper.java
        |   |           |-- model
        |   |           |   |-- UserDetail.java
        |   |           |   |-- UserLogin.java
        |   |           |-- service
        |   |           |   |-- UserDetailService.java
        |   |           |   |-- UserLoginService.java
        |   |           |   |-- impl
        |   |           |       |-- UserDetailServiceImpl.java
        |   |           |       |-- UserLoginServiceImpl.java
        |   |           |-- web
        |   |               |-- UserDetailController.java
        |   |               |-- UserLoginController.java
        |   |-- resources
        |       |-- application-dev.properties
        |       |-- application-prod.properties
        |       |-- application-test.properties
        |       |-- application.properties
        |       |-- banner.txt
        |       |-- rcdancer.sql
        |       |-- mapper
        |           |-- UserDetailMapper.xml
        |           |-- UserLoginMapper.xml
        |-- test
            |-- java
            |   |-- CodeGenerator.java
            |   |-- com
            |       |-- RCDancer
            |           |-- Tester.java
            |-- resources
                |-- generator
                    |-- template
                        |-- controller-restful.ftl
                        |-- controller.ftl
                        |-- service-impl.ftl
                        |-- service.ftl
