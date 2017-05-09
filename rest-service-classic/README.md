## classic - RestController, but reactive

- https://www.infoq.com/articles/reactor-by-example

## Api

- GET http://localhost:8080/api/tweets
- GET http://localhost:8080/api/tweet/{id}
- POST http://localhost:8080/api/tweet/submit

Example:

$ curl -H 'Host: localhost:8080' -H 'Acceptost:8080' -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36' -H 'Content-Type: application/json' -H 'Referer: http://localhost:8080/swagger-ui.html' -H 'Accept-Language: de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4' --data-binary '{
     "author": "seb",
     "message": "Hello World."
   }' --compressed 'http://localhost:8080/api/tweet/submit' -v
   
