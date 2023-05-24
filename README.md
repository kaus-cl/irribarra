## User Cases
### Good cases
```
curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"me@here.com","password":"myPassword12"}' 'http://localhost:8080/sign-up'

curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"me@here.com","password":"myPassword12","phones":[{"number":555100100,"citycode":5,"contrycode":"1"}]}' 'http://localhost:8080/sign-up'

```

### Validations
```
MISSING email
curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","password":"myPassword12"}' 'http://localhost:8080/sign-up'


BAD email
curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"noEmailHere","password":"myPassword12"}' 'http://localhost:8080/sign-up'


MISSING Password
curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"me@here.com"}' 'http://localhost:8080/sign-up'


BAD Password length
curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"me@here.com","password":"myPassword12aa"}' 'http://localhost:8080/sign-up'


BAD Password format
curl --header 'content-type: application/json' --data '{"name":"Manuel Irribarra","email":"me@here.com","password":"mypassword12"}' 'http://localhost:8080/sign-up'
```