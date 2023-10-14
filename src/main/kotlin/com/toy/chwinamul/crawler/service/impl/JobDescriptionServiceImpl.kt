package com.toy.chwinamul.crawler.service.impl

import com.toy.chwinamul.crawler.domain.JobDescription
import com.toy.chwinamul.crawler.domain.JobDescriptionRepository
import com.toy.chwinamul.crawler.service.JobDescriptionService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JobDescriptionServiceImpl(
    private val jobDescriptionRepository: JobDescriptionRepository
) : JobDescriptionService {

    @Transactional(readOnly = true)
    override fun getJobDescriptions(): List<JobDescription> = jobDescriptionRepository.findAll()

}