package com.toy.chwinamul.example.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ExampleRepository : JpaRepository<Example, Long> {

    fun findByName(bookName: String): Example?

}