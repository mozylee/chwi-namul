package com.toy.chwinamul.crawler

import com.toy.chwinamul.crawler.service.CrawlingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/crawling")
@RestController
class CrawlingController(
    private val crawlingService: CrawlingService
) {

    @GetMapping("kakao-bank")
    fun crawlKakaoBank() = crawlingService.crawlKakaoBank()

}