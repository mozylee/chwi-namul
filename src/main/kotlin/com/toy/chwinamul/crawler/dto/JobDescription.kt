package com.toy.chwinamul.crawler.dto

data class JobDescription(
    val companyName: String,
    val title: String = "",
    val dueDate: String = "-",
    val desc: String = "",
    val url: String = "",
    val tags: Set<String> = emptySet()
)
