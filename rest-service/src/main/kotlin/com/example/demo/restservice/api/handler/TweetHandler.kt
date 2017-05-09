package com.example.demo.restservice.api.handler

import com.example.demo.restservice.domain.Tweet
import com.example.demo.restservice.domain.TweetService
import com.example.demo.restservice.util.json
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import kotlin.streams.toList

@Component
class TweetHandler(private val tweetService: TweetService) {

    data class SubmitRequest(val author: String, val message: String)
    data class SubmitResponse(val id: String)
    data class TweetsCollectionResponse(val tweets: List<Tweet>)

    fun submitOne(req: ServerRequest): Mono<ServerResponse> {
        val submitRequest: Mono<SubmitRequest> =
                req.bodyToMono(SubmitRequest::class.java)

        val submitResponse: Mono<SubmitResponse> = submitRequest
                .flatMap {
                    val tweet = tweetService
                            .create(author = it.author, message = it.message)
                    tweetService.submit(tweet)

                    Mono.just(SubmitResponse(id = tweet.id))
                }

        return ServerResponse
                .ok()
                .json()
                .body(submitResponse)
    }

    fun findAll(req: ServerRequest): Mono<ServerResponse> {
        val tweetsResponse = TweetsCollectionResponse(
                tweets = tweetService
                        .getAll()
                        .toStream()
                        .toList()
        )

        return ServerResponse
                .ok()
                .json()
                .body(Mono.just(tweetsResponse))
    }

    fun findOne(req: ServerRequest): Mono<ServerResponse> {
        val tweet = tweetService.get(req.pathVariable("id"))

        return ServerResponse.ok()
                .json()
                .body(tweet)
    }
}