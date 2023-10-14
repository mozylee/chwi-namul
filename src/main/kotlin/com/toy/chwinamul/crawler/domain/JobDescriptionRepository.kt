package com.toy.chwinamul.crawler.domain

import org.springframework.data.jpa.repository.JpaRepository

interface JobDescriptionRepository : JpaRepository<JobDescription, Long> {
}