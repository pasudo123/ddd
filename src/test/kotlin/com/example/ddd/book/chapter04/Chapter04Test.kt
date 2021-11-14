package com.example.ddd.book.chapter04

import com.example.ddd.book.MemberTable
import com.example.ddd.book.chapter03.Member
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@DisplayName("Chapter04Test 는")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class Chapter04Test {

    private val memberService: MemberService = MemberService()

    @BeforeEach
    fun init() {
        val member = Member("파수도", 30)
        MemberTable.save(member)
    }

    @Test
    @Order(10)
    fun `(1) Member 가 존재해서 추가할 수 새로운 Member 를 추가할 수 없다`() {

        // given
        val member = Member("파수도", 30)
        MemberTable.save(member)

        // when
        val exist = memberService.isExistMember(member)

        // then
        exist shouldBe true
    }
}