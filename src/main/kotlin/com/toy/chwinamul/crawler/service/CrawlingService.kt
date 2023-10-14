package com.toy.chwinamul.crawler.service

import com.toy.chwinamul.crawler.dto.JobDescription

interface CrawlingService {

    fun crawlKakaoBank(): List<JobDescription>

}