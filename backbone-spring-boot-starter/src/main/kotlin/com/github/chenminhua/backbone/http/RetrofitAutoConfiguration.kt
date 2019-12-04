package com.github.chenminhua.backbone.http

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import okhttp3.OkHttpClient
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
@AutoConfigureAfter(OkHttpAutoConfiguration::class)
open class RetrofitAutoConfiguration {
    @Bean
    fun retrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create(getRetrofitObjectMapper()))
            .client(okHttpClient)
    }

    private fun getRetrofitObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()

        // 序列化容错：如果bean上无任何public property，则不会抛错
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        // 反序列化容错：遇到未知的字段忽略
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        // JSON规范: 空字段和null字段都要参与序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        return objectMapper
    }
}