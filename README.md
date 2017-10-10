# Kraker-Info

Start each of the modules starting with `kraker-info-eureka` which is registry for all the services.

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

3. Once you change the value at `.yml` file, hit 

```$xslt
http://localhost:${port}/refresh
```
url to make sure those values are refreshed for the context.