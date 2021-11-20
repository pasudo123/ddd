package com.example.ddd.book.chapter07.domain.member.application

import com.example.ddd.book.chapter03.Member
import com.example.ddd.book.chapter07.domain.member.repository.IMemberRepository
import kotlin.random.Random

class MemberInteractor(
    private val memberRepository: IMemberRepository
) {

    fun save(member: Member): Long {
        memberRepository.save(member)
        return Random.nextLong(10000, 50000)
    }
}