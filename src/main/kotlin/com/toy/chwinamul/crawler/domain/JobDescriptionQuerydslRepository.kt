package com.toy.chwinamul.crawler.domain

import com.querydsl.jpa.impl.JPAQueryFactory
import com.toy.chwinamul.crawler.domain.QJobDescription.jobDescription
import org.springframework.stereotype.Component

private const val NON_DATE = "-"

@Component
class JobDescriptionQuerydslRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun find(): List<JobDescription> = queryFactory
        .select(jobDescription)
        .from(jobDescription)
        .where(
            jobDescription.dueDate.ne(NON_DATE)
        )
        .fetch()

}