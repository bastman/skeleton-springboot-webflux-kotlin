package com.example.demo.configuration

class AppConfigurationException(
        message: String? = null,
        cause: Throwable? = null
) : RuntimeException(message, cause)