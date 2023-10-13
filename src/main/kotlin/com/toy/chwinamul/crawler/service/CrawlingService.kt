package com.toy.chwinamul.crawler.service

import com.toy.chwinamul.crawler.dto.JobDescription
import org.openqa.selenium.WebElement

interface CrawlingService {

    fun crawlKakaoBank(): List<JobDescription>

}