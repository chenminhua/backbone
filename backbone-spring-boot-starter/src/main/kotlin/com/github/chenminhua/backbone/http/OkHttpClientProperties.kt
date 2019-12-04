package com.github.chenminhua.backbone.http

import org.springframework.boot.context.properties.ConfigurationProperties


/**
 * connectTimeout表示发起TCP连接的超时时间，默认就是10s
 * readTimeout表示数据返回时间，如果对面超过这个时间没有返回，则readTimeout，默认就是10s
 * writeTimeout表示数据发不出去，默认10s
 * pingInterval是个心跳机制，默认设置为0，表示关闭
 */
@ConfigurationProperties("barren.okhttp")
class OkHttpClientProperties {

    var maxRequests = 1024
    var maxRequestsPerHost = 64
    var maxIdleConnections = 64

    var callTimeout = 0
    var connectTimeout = 10
    var readTimeout = 10
    var writeTimeout = 10
    var followRedirects = false
    var pingInterval = 0

    var enableEventListener = false
    var enableCat = true
    var enableHttpLogger = true
    var httpLogLevel = "BODY"

    var metricsPrefix = "barren.okhttp"
}