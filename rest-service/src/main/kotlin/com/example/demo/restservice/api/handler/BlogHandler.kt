package com.example.demo.restservice.api.handler

import com.example.demo.restservice.util.json
import org.springframework.http.MediaType.*
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
@Component
class BlogHandler {

    private val repository = Repo()


    fun findOne(req: ServerRequest):Mono<ServerResponse> {
        val blogPost=repository.findOne(req.pathVariable("id"))
        return ok()
                .json()
                .body(blogPost)
    }


    fun findAll(req: ServerRequest) = ok().json().body(repository.findAll())

    class Repo() {
        fun findOne(id:String): Mono<RepoItem> {
            return Mono.just(RepoItem("ONE"))
        }
        fun findAll():Flux<RepoItem> {
            return Flux.just(RepoItem("ONE"),RepoItem("TWO"))
        }
    }

    data class RepoItem(val s:String)

}

