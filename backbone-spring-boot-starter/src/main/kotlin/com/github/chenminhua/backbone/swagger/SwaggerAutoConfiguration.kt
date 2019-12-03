package com.github.chenminhua.backbone.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
open class SwaggerAutoConfiguration {

    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("service")
            .apiInfo(info())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/[vV][0-9]+/.*"))
            .build()
    }

    @Bean
    open fun all(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("all")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
    }

    open fun info(): ApiInfo {
        return ApiInfoBuilder()
            .build()
    }

}