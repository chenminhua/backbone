package com.github.chenminhua.backbonedemo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@SpringBootApplication(exclude= [DataSourceAutoConfiguration::class])
//@MapperScan("com.github.chenminhua.backbonedemo.mapper")
class BackBoneDemo

fun main(args: Array<String>) {
    SpringApplication.run(BackBoneDemo::class.java, *args)
}

data class Foo(
    val v1: String = "",
    val v2: String = ""
)

@RestController
@RequestMapping("/jobs/v1")
class JobEndpoint {

    // 提交任务
    @PostMapping("/submit")
    fun submitJob(@RequestBody request: String) {

    }

    // 结束任务
    @PostMapping("/finish")
    fun finishJob() {}

    // 完成任务
    @PostMapping("让任务失败")
    fun failJob() {

    }



}