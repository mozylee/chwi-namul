package com.toy.chwinamul.crawler.domain

import com.querydsl.jpa.impl.JPAQueryFactory
import com.toy.chwinamul.crawler.domain.QJobDescription.jobDescription
import org.springframework.stereotype.Component

@Component
class JobDescriptionQuerydslRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun find(): List<JobDescription> = queryFactory
        .select(jobDescription)
        .from(jobDescription)
        .where(
            jobDescription.dueDate.ne("-")
        )
        .fetch()

}