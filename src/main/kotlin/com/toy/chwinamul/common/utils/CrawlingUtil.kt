package com.toy.chwinamul.common.utils

import com.toy.chwinamul.crawler.domain.JobDescription
import org.openqa.selenium.chrome.ChromeDriver

typealias CrawlingFunction = (driver: ChromeDriver) -> List<JobDescription>

class CrawlingUtil {

    companion object {
        fun crawl(crawlingFunction: CrawlingFunction): List<JobDescription> = WebDriverUtil.getDriver()
            .use(crawlingFunction)
            .toList()

    }

}