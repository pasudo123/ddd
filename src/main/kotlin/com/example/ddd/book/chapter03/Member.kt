package com.example.ddd.book.chapter03

import java.io.Serializable

class Member(
    name: String,
    age: Int
): Serializable {

    var id: Long? = Generator.getMemberId()
        private set
    var name: String = name
        private set
    var age: Int = age
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (id != other.id) return false
        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + age
        return result
    }
}