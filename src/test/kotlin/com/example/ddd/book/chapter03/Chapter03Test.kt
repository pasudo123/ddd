package com.example.ddd.book.chapter03

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@DisplayName("Chapter03Test 는")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class Chapter03Test {

    @Test
    @Order(10)
    fun `(1) Member 의 동일성을 확인한다`() {

        // given
        val member1 = Member("파수도", 30)
        val member2 = Member("파수도", 30)

        // when
        val identity = member1 == member2

        // then
        identity shouldBe false
        member1.id shouldBe 1
        member2.id shouldBe 2
    }
}