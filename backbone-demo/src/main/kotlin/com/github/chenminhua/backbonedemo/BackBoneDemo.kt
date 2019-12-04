package com.github.chenminhua.backbonedemo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication(exclude= [DataSourceAutoConfiguration::class])
//@MapperScan("com.github.chenminhua.backbonedemo.mapper")
class BackBoneDemo

fun main(args: Array<String>) {
    SpringApplication.run(BackBoneDemo::class.java, *args)
}