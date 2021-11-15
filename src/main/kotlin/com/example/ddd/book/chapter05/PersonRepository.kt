package com.example.ddd.book.chapter05

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

    fun findByName(name: String): Person?
}

fun PersonRepository.findOneByName(name: String): Optional<Person> {
    return Optional.ofNullable(this.findByName(name))
}