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