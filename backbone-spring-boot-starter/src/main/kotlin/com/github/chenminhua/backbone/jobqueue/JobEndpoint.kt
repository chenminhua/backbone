package com.github.chenminhua.backbone.jobqueue

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/jobs/v1")
class JobEndpoint {

    @PostMapping("/submit")
    fun submitJob(
        request: HttpServletRequest) {
        request.reader.read()
    }

}