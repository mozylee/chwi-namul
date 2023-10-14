package com.toy.chwinamul.crawler.service

import com.toy.chwinamul.crawler.domain.JobDescription

interface CrawlingService {

    fun crawlKakaoBank(): List<JobDescription>

}