package com.example.ddd.book.chapter05

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Person private constructor (
    name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        private set

    var name: String = name
        private set

    companion object {
        fun create(name: String): Person {
            require(name.length >= 3) { "person name 은 최소 3자리 이상이어야 합니다." }
            return Person(name)
        }
    }
}