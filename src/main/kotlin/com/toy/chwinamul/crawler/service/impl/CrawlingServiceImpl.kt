package com.toy.chwinamul.crawler.service.impl

import com.toy.chwinamul.common.constant.KAKAO_BANK_RECRUIT
import com.toy.chwinamul.common.constant.WAIT_AMOUNT
import com.toy.chwinamul.common.constant.WAIT_TICK
import com.toy.chwinamul.common.utils.CrawlingUtil
import com.toy.chwinamul.crawler.domain.JobDescription
import com.toy.chwinamul.crawler.domain.JobDescriptionRepository
import com.toy.chwinamul.crawler.dto.KakaoBankRecruitment
import com.toy.chwinamul.crawler.service.CrawlingService
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


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
        driver.get(KAKAO_BANK_RECRUIT)

        Thread.sleep(WAIT_AMOUNT)

        while (true) {
            try {
                val moreButton: WebElement = driver.findElement(By.className("link_more"))
                moreButton.click()
            } catch (e: NoSuchElementException) {
                break
            }

            Thread.sleep(WAIT_TICK)
        }

        return driver.findElements(By.className("link_tit"))
            .map(::KakaoBankRecruitment)
            .map(KakaoBankRecruitment::toJobDescription)
            .toList()
    }

}
