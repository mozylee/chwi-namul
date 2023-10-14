package com.toy.chwinamul.crawler.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class JobDescription constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val companyName: String,
    val title: String = "",
    val dueDate: String = "-",
    val desc: String = "",
    val url: String = "",
)
