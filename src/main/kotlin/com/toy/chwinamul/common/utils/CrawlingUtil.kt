package com.toy.chwinamul.common.utils

import com.toy.chwinamul.crawler.domain.JobDescription
import org.openqa.selenium.chrome.ChromeDriver

class CrawlingUtil {

    companion object {
        fun crawl(crawlingFunction: (driver: ChromeDriver) -> List<JobDescription>): List<JobDescription> {
            val jobDescriptions: MutableList<JobDescription> = mutableListOf()

            val crawlingResults: List<JobDescription> = WebDriverUtil.getDriver().use(crawlingFunction)
            jobDescriptions.addAll(crawlingResults)

            return jobDescriptions.toList()
        }
    }

}