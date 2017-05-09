package com.example.demo.restservice.api.handler

import com.example.demo.restservice.domain.Tweet
import com.example.demo.restservice.domain.TweetService
import com.example.demo.restservice.util.json
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import java.time.Instant

@Component
class TweetHandler(private val tweetService: TweetService) {

    private data class SubmitRequest(val author:String, val message:String);
    private data class SubmitResponse(val id:String);
    fun submitOne(req: ServerRequest):Mono<ServerResponse> {

       // val m:Mono<SubmitRequest> = req.bodyToMono(SubmitRequest::class.java)
        return req.bodyToMono(SubmitRequest::class.java)
                .flatMap {
                    val tweet=tweetService.create(author = it.author, message = it.message)
                    println("++ request: $it")
                    val tweet2=tweetService.create(author = "foo", message = "bar")

                    ServerResponse.ok().json().body(Mono.just(it))
                }


/*
        val request:SubmitRequest = req.bodyToMono(SubmitRequest::class.java)
                .toFuture()
                .get();
        val tweet=tweetService.create(author = request.author, message = request.message)
*/
        //val tweet2=tweetService.create(author = "foo", message = "bar")
        //return ServerResponse.ok().json().body(Mono.just(tweet2))
    }

    fun findAll(req: ServerRequest) = ServerResponse
            .ok()
            .json()
            .body(tweetService.getAll())

    fun findOne(req: ServerRequest): Mono<ServerResponse> {
        val t=Tweet(id = "1", createdAt = Instant.now(), author = "seb", message = "was here")
        tweetService.submit(t)
        val tweet=tweetService.get(req.pathVariable("id"))

        return ServerResponse.ok()
                .json()
                .body(tweet)
    }
}