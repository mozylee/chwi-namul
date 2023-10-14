package com.toy.chwinamul.crawler.service

import com.toy.chwinamul.crawler.domain.JobDescription

interface JobDescriptionService {

    fun getJobDescriptions(): List<JobDescription>

}