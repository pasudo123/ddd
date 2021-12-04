package com.example.ddd.book.chapter13.domain.club.service

import com.example.ddd.book.chapter13.domain.club.Club
import com.example.ddd.book.chapter13.domain.member.repository.MemberRepository

class ClubJoinSpecification(
    private val memberRepository: MemberRepository
) {

    companion object {
        const val CLUB_PREMIUM_BASE_LINE = 10
        const val CLUB_INCLUDE_PREMIUM_MAX_MEMBER_SIZE = 50
        const val CLUB_DEFAULT_MAX_MEMBER_SIZE = 30
    }

    /**
     * 클럽 내 프리미엄 멤버가 CLUB_PREMIUM_BASE_LINE 값에 따라서
     * 클럽 내 가입 가능한 멤버의 수가 달라진다.
     */
    fun isFull(club: Club): Boolean {
        val members = memberRepository.findAllByClub(club)
        val premiumMembers = members.filter { member -> member.premium }

        if (premiumMembers.size >= CLUB_PREMIUM_BASE_LINE) {
            members.count() >= CLUB_INCLUDE_PREMIUM_MAX_MEMBER_SIZE
        }

        return members.count() >= CLUB_DEFAULT_MAX_MEMBER_SIZE
    }
}