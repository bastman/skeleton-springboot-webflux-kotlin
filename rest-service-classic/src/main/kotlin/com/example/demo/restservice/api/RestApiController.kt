package com.example.demo.restservice.api

import com.example.demo.restservice.api.handler.TweetHandler
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class RestApiController(private val tweetHandler: TweetHandler) {

    @GetMapping("/api/tweets")
    fun findAllTweets(): Mono<TweetHandler.TweetsCollectionResponse>
            = tweetHandler.findAll()

    @GetMapping("/api/tweet/{id}")
    fun getTweetById(@PathVariable id: String)
            = tweetHandler.findOne(id = id)

    @PostMapping("/api/tweet/submit")
    fun submitTweet(
            @RequestBody body: Mono<TweetHandler.SubmitRequest>
    ): Mono<TweetHandler.SubmitResponse>
            = tweetHandler.submitOne(body)
}


