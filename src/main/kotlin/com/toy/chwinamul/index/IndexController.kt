package com.toy.chwinamul.index

import com.toy.chwinamul.crawler.service.JobDescriptionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController(
    private val jobDescriptionService: JobDescriptionService
) {

    @RequestMapping("/")
    fun index(): String = "index"

    @GetMapping("/list")
    fun getRecruitments(model: Model): String {
        model.addAttribute("jobDescriptions", jobDescriptionService.getJobDescriptions())

        return "list"
    }

}