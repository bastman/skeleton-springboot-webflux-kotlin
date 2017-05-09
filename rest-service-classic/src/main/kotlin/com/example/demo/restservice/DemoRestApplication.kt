package com.example.demo.restservice

import com.example.demo.restservice.domain.Tweet
import com.example.demo.restservice.domain.TweetService
import com.example.demo.restservice.util.runWebflux
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import java.time.Instant


//typealias WebMvcRequestMappingInfoHandlerMapping = org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping
//typealias WebMvcRequestMappingInfo = org.springframework.web.servlet.mvc.method.RequestMappingInfo
//typealias WebMvcRequestMappingHandlerMapping = org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

typealias WebFluxRequestMappingInfoHandlerMapping = org.springframework.web.reactive.result.method.RequestMappingInfoHandlerMapping
typealias WebFluxRequestMappingInfo = org.springframework.web.reactive.result.method.RequestMappingInfo
typealias WebFluxRequestMappingHandlerMapping = org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping

@SpringBootApplication
@EnableConfigurationProperties(DemoRestApplicationProperties::class)
open class DemoRestApplication {
    @Bean
    open fun init(
            ctx: ConfigurableApplicationContext,
            @Value("\${app.appName}") appName: String,
            tweetService: TweetService
    ) = CommandLineRunner {
        println("=== init $appName - $ctx =====")

        listOf<Tweet>(
                Tweet(
                        id = "1",
                        createdAt = Instant.now(),
                        author = "seb",
                        message = "msg1"
                ),
                Tweet(
                        id = "2",
                        createdAt = Instant.now(),
                        author = "seb",
                        message = "msg2"
                )
        ).forEach {
            tweetService.submit(it)
        }

    }

    // No qualifying bean of type 'java.util.List<org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping>'
    /*
    @Bean
    open fun webmvcRequestMappingHandlerMapping(
            webfluxMapping: WebFluxRequestMappingHandlerMapping
    ): WebMvcRequestMappingHandlerMapping {
        val mapping = WebMvcRequestMappingHandlerMapping()
        // add properties here
        return mapping
    }
    */
    /*
    @Bean open fun foo(): WebMvcRequestMappingInfoHandlerMapping {
        WebMvcRequestMappingInfo()
        return WebMvcRequestMappingInfoHandlerMapping()
    }
    */
}

fun main(args: Array<String>) {
    runWebflux(DemoRestApplication::class, *args)
}