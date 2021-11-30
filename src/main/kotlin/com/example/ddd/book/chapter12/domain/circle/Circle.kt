package com.example.ddd.book.chapter12.domain.circle

import java.util.*

class Circle(
    val name: String
) {

    val id: String = UUID.randomUUID().toString().replace("-", "")

    val userIds: MutableList<String> = mutableListOf()
}