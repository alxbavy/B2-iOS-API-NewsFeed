# AuthApp

Application is running on localhost:8132

Swagger http://localhost:8132/api/integration/swagger-ui/index.html



## KeyCloak

### Application properties config
```
spring:
  profiles:
    active: production
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8080/admin/realms/AuthB2
                                        ^                   ^         
                                        |                   |
                                    your host         your realm name


keycloak:
  realm: AuthB2 //realm-name
  domain: localhost:8080 //your domain
  adminClientId: admin-cli //admin client id
  adminClientSecret: tClZUM5repAOiO5NbLbVuytjA0beEJZ0 //admin-client secret
  client: authClientId //custom client name
  urls:
    auth: http://${keycloak.domain}
```
### MailHog 

```
Runs on localhost:8025
Connect to check if email sent
```

## Test API
```
To test API 
1. docker-compose up -d
2. Login to KeyCloak admin on localhost:8080 {admin, admin}
3. Go to your realm, users to chech if users operations are valid