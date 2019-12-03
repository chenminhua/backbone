package com.github.chenminhua.backbone.sentry

import io.sentry.spring.SentryExceptionResolver
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("sentry")
@ConditionalOnProperty("sentry.dsn")
open class SentryAutoConfiguration() {

    @Value("\${sentry.dsn}")
    lateinit var value: String

    @Bean
    @ConditionalOnMissingBean
    open fun sentryExceptionResolver(): SentryExceptionResolver {
        io.sentry.Sentry.init(value)
        return io.sentry.spring.SentryExceptionResolver()
    }

    @Bean
    @ConditionalOnMissingBean
    open fun sentryServletContextInitializer() = io.sentry.spring.SentryServletContextInitializer()
}