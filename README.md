# Kraker-Info

Start each of the modules starting with `kraker-info-eureka` which is registry for all the services.

### Architectural Diagram

![Arch Diagram](/kraker-info-docs/arch-diagram.jpg?raw=true "Arch Diagram")

### Test Endpoint

```$xslt
http://localhost:9093/users/yogen
```
#### Flow would be like this:

`Client` -> `kraker-info-gateway` -> `kraker-info-user-svc` -> `kraker-info-bookmark-svc`

#### Tracing component interaction

Start `kraker-info-zipkin` modules and tracing information will be at endpoint:

```
http://localhost:9411/zipkin/
```

#### Externalization of properties:
1. Create a .yml file in `kraker-info-config` directory with application name.
For example: `kraker-info-config/kraker-info-user-svc.yml`

2. Update corresponding component using that property with `@RefreshScope` annotation which indicates that the property value injected needs to be fetched for new request.
For example:

```
@RefreshScope
@RestController
public class UserController {
    @Value("${env.current:local}")
    private String currentEnv;
    
    //...
}
```

3. Once you change the value at `.yml` file, make `POST` request to the endpoint 

```$xslt
http://localhost:${port}/refresh
```
to make sure those values are refreshed for the context.


#### Setup Redis server

Redis is being used for caching with client Jedis.

##### For Mac, install Redis with `brew` as

```
brew install redis
```

Start Redis-server with:

```
brew services start redis
```

If you do not want to start with brew, then you can start Redis server as:

```
redis-server /usr/local/etc/redis.conf
```

Check if redis is running:

```
redis-cli ping
```

Stop Redis-server:

```
brew services stop redis
```

##### For windows
[Download](https://github.com/MicrosoftArchive/redis/releases) and start server to enable caching.


#### Swagger UI

All endpoints are exposed via gateway service. So, swagger-ui for endpoints is at:

```
http://localhost:9093/swagger-ui.html
```


# What is REST?

[Blog](http://blog.miyozinc.com)

# Why REST?
![Arch Diagram](/kraker-info-docs/why-api.png)

# Why Spring Boot?

[Spring Doc](https://spring.io/projects/spring-boot)