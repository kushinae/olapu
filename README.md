# Olapu

Olapu is a code generation solution designed with programmers in mind.

It can help us generate such as: Java entity class, Controller, Service, Dao, Repository... Help us quickly generate CRUD\Page Search API, reduce repetitive work in development, free our hands and let us focus on business more energy and time development.

## Getting started

### configure

- Initialize the database

execution [database initialization script](./sql/init.sql)

- configure your database connection

编辑 [API服务配置文件](./olapu-api/src/main/resources/application.yaml) 

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver # your data source driver
    url: jdbc:mysql://127.0.0.1:3306/olapu # your data source jdbc
    username: root # your data source username
    password: 123456 # your data source password
server:
  servlet:
    context-path: /api # global resource pre path
```

### build

#### backend service

##### build

```shell
cd ./olapu-api
gradle bootJar
```

##### deploy

```shell
java -jar ./olapu-api/build/libs/olapu-api-1.0-SNAPSHOT.jar
```


#### frontend service

##### build

```shell
cd ./console
yarn build
```

build之后您的静态资源会在 `console/dist` 目录中，您可以使用 `nginx` 或者其他静态资源代理来访问它，

如果您想`本地启动`

```shell
cd ./console
yarn
yarn start
```

或者您想使用`应用程序`启动

```shell
cd ./console
yarn
yarn start
yarn window
```

- preview

![](./docs/quickstart/applicaiton_preview.png)

# Timeline

I'm actively developing this project, I can't push it anytime soon due to work, but I'm keeping active commits every day

# License

[Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)

# Thank you

- 感谢 `JetBrains` 对本项目的帮助

![JetBrainsLogo](https://github.com/rymcu/forest/raw/master/src/main/resources/static/jb_beam.svg)