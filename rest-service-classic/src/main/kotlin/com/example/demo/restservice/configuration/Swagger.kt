package com.example.demo.restservice.configuration

/*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.BasicAuth
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2()
open class SwaggerConfiguration(
        @Value("\${app.appName}") appName: String
) {
    val API_ROUTE_SWAGGER_UI = "/swagger-ui.html"

    private val apiInfo by lazy {
        ApiInfoBuilder()
                .title(appName)
                .description("This is an example microservice application.")
                .build()
    }

    @Bean
    open fun demoApiDocket(): Docket {
        val groupName = "demo-api"
        val basePackage = "com.example.demo.restservice.api"

        return Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .securitySchemes(
                        arrayListOf(
                                BasicAuth("basic-auth-realm")
                        )
                )
    }
}

        */