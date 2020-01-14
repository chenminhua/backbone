package com.github.chenminhua.backbone.demo;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(exclude= [DataSourceAutoConfiguration::class])
//@MapperScan("com.github.chenminhua.backbonedemo.mapper")
class BackBoneDemo

fun main(args: Array<String>) {
    SpringApplication.run(BackBoneDemo::class.java, *args)
}

@RestController
@RequestMapping("/jobs/v1")
class JobEndpoint {

    @PostMapping("/submit")
    fun submitJob(@RequestBody request: String) {

    }


}