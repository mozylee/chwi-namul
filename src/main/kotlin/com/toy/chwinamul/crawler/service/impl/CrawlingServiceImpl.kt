package com.toy.chwinamul.crawler.service.impl

import com.toy.chwinamul.common.utils.CrawlingUtil
import com.toy.chwinamul.crawler.dto.JobDescription
import com.toy.chwinamul.crawler.dto.KakaoBankRecruitment
import com.toy.chwinamul.crawler.service.CrawlingService
import org.openqa.selenium.By
import org.springframework.stereotype.Service

private const val URL = "https://recruit.kakaobank.com/jobs"

@Service
class CrawlingServiceImpl() : CrawlingService {

    override fun crawlKakaoBank(): List<JobDescription> = CrawlingUtil.crawl { driver ->
        driver.get(URL)

        Thread.sleep(3000);

        driver.findElements(By.className("link_tit"))
            .map(::KakaoBankRecruitment)
            .map(KakaoBankRecruitment::toJobDescription)
            .toList()
    }

}
