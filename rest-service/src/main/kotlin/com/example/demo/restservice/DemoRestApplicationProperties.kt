package com.example.demo.restservice

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app")
class DemoRestApplicationProperties {
    var appName: String? = null
}