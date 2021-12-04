package com.example.ddd.book.chapter13.domain.member.service

import com.example.ddd.book.annotation.DomainService
import com.example.ddd.book.chapter13.domain.member.Member
import com.example.ddd.book.chapter13.domain.member.repository.MemberRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
@DomainService
class MemberDomainService(
    private val memberRepository: MemberRepository
) {

    fun save(member: Member): Member {
        return memberRepository.save(member)
    }
}