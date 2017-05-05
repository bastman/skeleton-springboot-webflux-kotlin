package com.example.demo.restservice

import com.example.demo.restservice.util.run
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean

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
}

fun main(args: Array<String>) {
    run(DemoRestApplication::class, *args)
}