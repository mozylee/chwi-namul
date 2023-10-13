package com.toy.chwinamul.example

import com.toy.chwinamul.example.domain.Example
import com.toy.chwinamul.example.domain.ExampleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/ex")
@RestController
class ExampleController(
    private val exampleRepository: ExampleRepository,
) {

    @PostMapping
    fun testPostMapping(@RequestBody request: String) = exampleRepository.save(Example.fixture())

    @GetMapping
    fun testGetMapping() = exampleRepository.findAll()

}