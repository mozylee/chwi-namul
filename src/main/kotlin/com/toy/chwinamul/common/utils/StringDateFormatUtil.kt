package com.toy.chwinamul.common.utils

import java.time.LocalDate

fun String.parseDueDateKakaoBank(): String {
    if (!this.startsWith("D-")) {
        return "-"
    }

    return LocalDate.now()
        .plusDays(this.split("-")[1].toLong())
        .toString()
}