# webflux playground

Note: this is just quick and dirty playground

- https://speakerdeck.com/sdeleuze/functional-web-applications-with-kotlin-and-spring-5
- https://www.infoq.com/articles/reactor-by-example


## findings
- springfox swagger does not work with webflux

    Caused by: java.lang.NoClassDefFoundError: org/springframework/web/servlet/mvc/method/annotation/RequestMappingHandlerAdapter
    	at springfox.documentation.spring.web.ObjectMapperConfigurer.postProcessBeforeInitialization(ObjectMapperConfigurer.java:45) ~[springfox-spring-web-2.6.1.jar:2.6.1]
    	
    	it requires: import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
    	
    	
 todo: try to include mvc, but factory spring boot with webflux
    	
## Api examples

### POST /api/tweet/submit

 
$ curl -H 'Host: localhost:8080' -H 'Accept: application/json;charset=UTF-8' -H 'Origin: http://localhost:8080' -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36' -H 'Content-Type: application/json' -H 'Referer: http://localhost:8080/swagger-ui.html' -H 'Accept-Language: de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4' --data-binary '{
   "author": "seb",
   "message": "Hello World."
 }' --compressed 'http://localhost:8080/api/tweet/submit' -v
    	
    	