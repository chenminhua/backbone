package com.github.chenminhua.backbone.jobqueue

enum class JobStatus{
    READY,
    RUNNING,
    DONE,
    FAILED,
    CANCELED
}

data class Job(
    val jobstr: String,
    val type: String,
    val status: JobStatus,
    val finishedAt: Long,
    val createdAt: Long
)