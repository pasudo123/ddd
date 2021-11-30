package com.example.ddd.book.chapter12.domain.user

import java.util.*

class User(
    val name: String
) {

    val id: String = UUID.randomUUID().toString().replace("-", "")
}