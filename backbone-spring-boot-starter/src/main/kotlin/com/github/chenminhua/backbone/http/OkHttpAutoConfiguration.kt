package com.github.chenminhua.backbone.http

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
@EnableConfigurationProperties(OkHttpClientProperties::class)
class OkHttpAutoConfiguration {
    @Autowired
    private lateinit var properties: OkHttpClientProperties

    @Bean
    fun okHttpClient(): OkHttpClient {
        val connectionPool = ConnectionPool(properties.maxIdleConnections, 5, TimeUnit.MINUTES);

        val builder = OkHttpClient.Builder()
            .connectTimeout(properties.connectTimeout.toLong(), TimeUnit.SECONDS)
            .readTimeout(properties.readTimeout.toLong(), TimeUnit.SECONDS)
            .writeTimeout(properties.writeTimeout.toLong(), TimeUnit.SECONDS)
            .followRedirects(properties.followRedirects)
            .pingInterval(properties.pingInterval.toLong(), TimeUnit.SECONDS)
            .connectionPool(connectionPool)

        return builder.build()
    }
}