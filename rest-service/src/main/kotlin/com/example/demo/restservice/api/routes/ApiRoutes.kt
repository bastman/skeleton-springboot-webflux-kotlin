package com.example.demo.restservice.api.routes

import com.example.demo.restservice.api.handler.TweetHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router


@Configuration
open class ApiRoutes(private val tweetHandler: TweetHandler) {

    @Bean
    open fun apiRouter() = router {
        (accept(APPLICATION_JSON) and "/api").nest {
            "/tweet".nest {
                POST("/submit", tweetHandler::submitOne)
                GET("/", tweetHandler::findAll)
                GET("/{id}", tweetHandler::findOne)
            }
        }
    }
}
