package com.example.demo.restservice.api.routes

import com.example.demo.restservice.api.handler.BlogHandler
import com.example.demo.restservice.api.handler.TweetHandler
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.router


@Configuration
open class ApiRoutes(
        private val blogHandler: BlogHandler,
        private val tweetHandler: TweetHandler
) {

    @Bean
    open fun apiRouter() = router {
        (accept(APPLICATION_JSON) and "/api").nest {
            "/blog".nest {
                GET("/", blogHandler::findAll)
               GET("/{id}", blogHandler::findOne)
            }

            "/tweet".nest {
                POST("/submit", tweetHandler::submitOne)
                GET("/", tweetHandler::findAll)
                GET("/tweet/{id}", tweetHandler::findOne)
            }

        }
    }
}

/*
@RestController
@CrossOrigin(origins = arrayOf("*"))
open class ApiController(private val blogHandler: BlogHandler) {
    data class Speaker(val name:String)

    @GetMapping("/speaker")
    fun speakers(
          req: ServerRequest
    )=Mono.just(Speaker(name = "seb"))

}
*/