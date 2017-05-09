package com.example.demo.restservice

import com.example.demo.restservice.util.runWebflux
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean


//typealias WebMvcRequestMappingInfoHandlerMapping = org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping
//typealias WebMvcRequestMappingInfo = org.springframework.web.servlet.mvc.method.RequestMappingInfo
//typealias WebMvcRequestMappingHandlerMapping = org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

typealias WebFluxRequestMappingInfoHandlerMapping = org.springframework.web.reactive.result.method.RequestMappingInfoHandlerMapping
typealias WebFluxRequestMappingInfo = org.springframework.web.reactive.result.method.RequestMappingInfo
typealias WebFluxRequestMappingHandlerMapping =org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping

@SpringBootApplication
@EnableConfigurationProperties(DemoRestApplicationProperties::class)
open class DemoRestApplication {
    @Bean
    open fun init(
            ctx: ConfigurableApplicationContext,
            @Value("\${app.appName}") appName: String
    ) = CommandLineRunner {
        println("=== init $appName - $ctx =====")
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