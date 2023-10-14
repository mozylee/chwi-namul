package com.toy.chwinamul.crawler.service.impl

import com.toy.chwinamul.common.utils.CrawlingUtil
import com.toy.chwinamul.crawler.domain.JobDescription
import com.toy.chwinamul.crawler.domain.JobDescriptionRepository
import com.toy.chwinamul.crawler.dto.KakaoBankRecruitment
import com.toy.chwinamul.crawler.service.CrawlingService
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private const val URL = "https://recruit.kakaobank.com/jobs"

@Service
class CrawlingServiceImpl(
    private val jobDescriptionRepository: JobDescriptionRepository
) : CrawlingService {

    @Transactional
    override fun crawlKakaoBank(): List<JobDescription> {
        val jobDescriptions = CrawlingUtil.crawl(::findJobDescriptions)

        return jobDescriptionRepository.saveAll(jobDescriptions).toList()
    }

    private fun findJobDescriptions(driver: ChromeDriver): List<JobDescription> {
        driver.get(URL)

        Thread.sleep(3000);

        return driver.findElements(By.className("link_tit"))
            .map(::KakaoBankRecruitment)
            .map(KakaoBankRecruitment::toJobDescription)
            .toList()
    }

}
