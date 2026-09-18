package com.example.mykotlinlabapplication.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun translateDate(date: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val outputFormatter = DateTimeFormatter.ofPattern("d MMMM, yyyy")

    val parsedDate = LocalDate.parse(date, inputFormatter)

    return parsedDate.format(outputFormatter)
}

fun getTodaysDate() : String {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString()
}