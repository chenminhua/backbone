package com.github.chenminhua.backbone.jobqueue


interface JobProcessor {
    fun doJob()

    fun successCallback()

    fun failureCallback()
}