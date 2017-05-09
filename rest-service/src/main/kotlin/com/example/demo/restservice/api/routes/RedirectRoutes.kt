package com.example.demo.restservice.api.routes

import com.example.demo.restservice.api.handler.TweetHandler
import com.example.demo.restservice.util.permanentRedirect
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class RedirectRoutes(private val tweetHandler: TweetHandler) {

    @Bean
    fun redirectRouter() = router {
        accept(TEXT_HTML).nest {
            "/tweet".nest {
                GET("/") { permanentRedirect("/api/tweet") }
                (GET("/{id}") or GET("/{id}/")).invoke(tweetHandler::findOne)
            }
        }
    }
}