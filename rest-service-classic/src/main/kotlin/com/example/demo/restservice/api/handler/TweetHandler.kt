package com.example.demo.restservice.api.handler

import com.example.demo.restservice.domain.Tweet
import com.example.demo.restservice.domain.TweetService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Mono
import kotlin.streams.toList

@Component
class TweetHandler(private val tweetService: TweetService) {

    data class SubmitRequest(val author: String, val message: String)
    data class SubmitResponse(val id: String)
    data class TweetsCollectionResponse(val tweets: List<Tweet>)

    fun submitOne(body: Mono<SubmitRequest>): Mono<SubmitResponse> {
        return body.flatMap {
            val tweet = tweetService.create(it.author, it.message)
            tweetService.submit(tweet)

            Mono.just(SubmitResponse(id = tweet.id))
        }
    }

    fun findOne(@PathVariable id: String): Mono<Tweet> {
        return tweetService.get(tweetId = id)
    }

    fun findAll(): Mono<TweetsCollectionResponse> {
        val tweets = tweetService.getAll()
                .toStream()
                .toList()

        return Mono.just(
                TweetsCollectionResponse(tweets = tweets)
        )
    }
}