package com.github.chenminhua.backbone.jobqueue

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

interface JobBroker {
    fun submitJob(job: Job)
    fun takeJob(): Job
}

@Repository
interface JobMapper {
    fun getAnReadyJob(): Job
}

class MysqlJobBroker: JobBroker {

    @Autowired private lateinit var jobMapper: JobMapper

    override fun submitJob(job: Job) {
    }

    override fun takeJob(): Job {
        return jobMapper.getAnReadyJob()
    }
}