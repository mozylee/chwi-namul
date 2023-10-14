package com.toy.chwinamul.crawler.dto

import com.toy.chwinamul.crawler.domain.JobDescription
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.time.LocalDate

private const val COMPANY_NAME = "카카오 뱅크"

data class KakaoBankRecruitment(
    private val link: WebElement,
) {

    fun toJobDescription(): JobDescription {
        val (title, dueDate) = parseBoard()

        return JobDescription(
            companyName = COMPANY_NAME,
            url = link.getAttribute("href"),
            title = title,
            dueDate = dueDate,
            desc = link.findElement(By.className("txt_desc")).text,
        )
    }

    private fun parseBoard(): Pair<String, String> {
        val (title, dueDate) = link.findElement(By.className("tit_board")).text.split("\n")

        return Pair(title, parseDueDate(dueDate))
    }

    private fun parseDueDate(dueDate: String): String {
        if (!dueDate.startsWith("D-")) {
            return "-"
        }

        val amount: String = dueDate.split("-")[1]

        return LocalDate.now().plusDays(amount.toLong()).toString()
    }

}

