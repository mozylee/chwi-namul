package com.toy.chwinamul.example.domain

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
class Example constructor(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    val name: String,
    @Enumerated(EnumType.STRING)
    val type: ExampleType,
) {

    init {
        require(name.isNotBlank()) { "이름은 비어 있을 수 없습니다" }
    }

    companion object {
        fun fixture(
            name: String = "예시 이름",
            type: ExampleType = ExampleType.COMPUTER,
            id: Long? = null,
        ): Example = Example(
            id = id,
            name = name,
            type = type,
        )
    }

}