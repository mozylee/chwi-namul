package com.toy.chwinamul.crawler.service.impl

import com.toy.chwinamul.crawler.dto.JobDescription
import com.toy.chwinamul.crawler.dto.KakaoBankRecruitment
import com.toy.chwinamul.crawler.service.CrawlingService
import com.toy.chwinamul.utils.WebDriverUtil
import lombok.extern.slf4j.Slf4j
import org.openqa.selenium.By
import org.springframework.stereotype.Service

private const val URL = "https://recruit.kakaobank.com/jobs"

@Slf4j
@Service
class CrawlingServiceImpl() : CrawlingService {

    override fun crawlKakaoBank(): List<JobDescription> {
        val driver = WebDriverUtil.getDriver()
        driver.get(URL)

        Thread.sleep(3000);

        return driver.findElements(By.className("link_tit"))
            .map(::KakaoBankRecruitment)
            .map(KakaoBankRecruitment::toJobDescription)
            .toList()
    }

}
