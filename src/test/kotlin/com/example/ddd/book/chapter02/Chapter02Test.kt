package com.example.ddd.book.chapter02

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.assertThrows

@DisplayName("Chapter02Test 는")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class Chapter02Test {


    @Test
    @Order(10)
    fun `(1) Money 표현력이 풍부하다`() {

        // given
        val money1 = Money(50000, Money.Currency.KRW)
        val money2 = Money(50000, Money.Currency.KRW)

        // when : data keyword 필요
        val isEquals = money1 == money2

        // then
        isEquals shouldBe true
    }

    @Test
    @Order(20)
    fun `(2-1) User 값의 무결성을 유지할 수 있다`() {

        // given & when
        val exception = assertThrows<IllegalArgumentException> {
            User.from("ua", "dalas")
        }

        // then
        exception.message shouldBe "firstName 이 세자리 미만입니다."
    }

    @Test
    @Order(21)
    fun `(2-2) User 값의 무결성을 유지할 수 있다`() {

        // given & when
        val exception = assertThrows<IllegalArgumentException> {
            User.from("uranos", "da")
        }

        // then
        exception.message shouldBe "lastName 이 세자리 미만입니다."
    }

    @Test
    @Order(30)
    fun `(3) 코드가 이곳저곳에서 흩어지는 것을 방지한다`() {

        // given
        val user = User.from("gary", "oldman")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            user.updateFirstName("ci")
        }

        // then
        exception.message shouldBe "firstName 이 세자리 미만입니다."
    }
}