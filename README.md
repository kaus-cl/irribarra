# SpringBoot practical exercise

This is a full Springboot exercise using Spring Web, Spring Data, Spring Security and Validation packages.

This create a single endpoint `/sign-up` to create new users into a H2 database (persisted in /data/sample file).

Details about all the requirements, can be found into `./doc/Updated_Ejercicio_1_-_BCI_1.pdf` file (contents in spanish)


## Requirements

To use this application, you need a Java JDK version 1.8. You can check your java version using the following command. The expected output is displayed too

```
$> java -version
openjdk version "1.8.0_362"
OpenJDK Runtime Environment (build 1.8.0_362-8u372-ga~us1-0ubuntu1~22.04-b09)
OpenJDK 64-Bit Server VM (build 25.362-b09, mixed mode)
```


## How to build it

You need to download/checkout sources and then execute:

In Linux/MacOs/Cygwin/WSL:
```
$> ./gradlew build
```

In Windows:
```
C:\...\> gradlew.bat build
```
This will download all the required libraries, compile the code and execute the unit tests. The expected output should look similar to:

```
$> ./gradlew build

> Task :test
2023-05-24 20:00:48.324  INFO 20615 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2023-05-24 20:00:48.326  INFO 20615 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-05-24 20:00:48.330  INFO 20615 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

When the build is done, you can check the unit test result opening `./build/reports/test/test/index.html` file in your browser


## How to run it

After build, you can start the server executing

In Linux/MacOs/Cygwin/WSL:
```
$> ./gradlew bootrun
```

In Windows:
```
C:\...\> gradlew.bat bootrun
```

The expected output should looks similar to:

```
$> ./gradlew bootrun

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.12)

2023-05-24 20:28:46.757  INFO 29292 --- [           main] c.g.irribarra.IrribarraApplication       : Starting IrribarraApplication using Java 1.8.0_362 on Kaus with PID 29292 (/mnt/c/Users/manue/OneDrive/Documentos/workspace/java/irribarra/build/classes/java/main started by manuel in /mnt/c/Users/manue/OneDrive/Documentos/workspace/java/irribarra)
2023-05-24 20:28:46.776  INFO 29292 --- [           main] c.g.irribarra.IrribarraApplication       : No active profile set, falling back to 1 default profile: "default"
2023-05-24 20:28:52.547  INFO 29292 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2023-05-24 20:28:53.634  INFO 29292 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 990 ms. Found 2 JPA repository interfaces.
2023-05-24 20:28:58.684  INFO 29292 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-05-24 20:28:58.763  INFO 29292 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-05-24 20:28:58.763  INFO 29292 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.75]
2023-05-24 20:28:59.236  INFO 29292 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-05-24 20:28:59.237  INFO 29292 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 12207 ms
2023-05-24 20:29:00.210  INFO 29292 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-05-24 20:29:01.692  INFO 29292 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-05-24 20:29:02.292  INFO 29292 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2023-05-24 20:29:03.053  INFO 29292 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.15.Final
2023-05-24 20:29:05.188  INFO 29292 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2023-05-24 20:29:07.037  INFO 29292 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2023-05-24 20:29:15.874  INFO 29292 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2023-05-24 20:29:16.071  INFO 29292 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2023-05-24 20:29:18.957  WARN 29292 --- [           main] .s.s.UserDetailsServiceAutoConfiguration : 

Using generated security password: 5431f5b8-6bc9-4d12-b734-229bebd2bbf4

This generated password is for development use only. Your security configuration must be updated before running your application in production.

2023-05-24 20:29:20.271  INFO 29292 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@17216605, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@10a907ec, org.springframework.security.web.context.SecurityContextPersistenceFilter@6bce4140, org.springframework.security.web.header.HeaderWriterFilter@74fb5b59, org.springframework.security.web.authentication.logout.LogoutFilter@59918c8f, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@5882b202, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@b506ed0, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@59b492ec, org.springframework.security.web.session.SessionManagementFilter@2baac4a7, org.springframework.security.web.access.ExceptionTranslationFilter@44fd7ba4, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@799f354a]
2023-05-24 20:29:23.410  INFO 29292 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-05-24 20:29:23.440  INFO 29292 --- [           main] c.g.irribarra.IrribarraApplication       : Started IrribarraApplication in 40.463 seconds (JVM running for 41.918)
<==========---> 80% EXECUTING [3m 56s]
> :bootRun
```

By default, server listen `8080` port.


## How to test it

Once server is running, you can POST request to the server. If nothing was updated, the default location will be `http://localhost:8080/sign-up`. The expected request format is

```
{
   "name": String,
   "email": String,
   "password": String,
   "phones": [
      {
         "number": long,
         "citycode": int,
         "contrycode": String
      }
   ]
}
```
Where **email** and **password** are mandatory, while **name** and **phones** are optional.

You can use commands like `curl` to post requests or you could use some softwares like `postman` or even some IDE plugins like `insomnia` or `httpYac`.

The following samples uses `curl` command:

### Good cases
```
curl --header 'content-type: application/json' --data '{"email":"me@here.com","password":"myPassword12"}' 'http://localhost:8080/sign-up'

curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"me@here.com","password":"myPassword12","phones":[{"number":555100100,"citycode":5,"contrycode":"1"}]}' 'http://localhost:8080/sign-up'

```

### Bad cases (testing validations)
```
MISSING email
curl --header 'content-type: application/json' --data '{"password":"myPassword12"}' 'http://localhost:8080/sign-up'


BAD email
curl --header 'content-type: application/json' --data '{"email":"noEmailHere","password":"myPassword12"}' 'http://localhost:8080/sign-up'


MISSING Password
curl --header 'content-type: application/json' --data '{"email":"me@here.com"}' 'http://localhost:8080/sign-up'


BAD Password length
curl --header 'content-type: application/json' --data '{"email":"me@here.com","password":"myPassword12aa"}' 'http://localhost:8080/sign-up'


BAD Password format
curl --header 'content-type: application/json' --data '{"email":"me@here.com","password":"mypassword12"}' 'http://localhost:8080/sign-up'
```