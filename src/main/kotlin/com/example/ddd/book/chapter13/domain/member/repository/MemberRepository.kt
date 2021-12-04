package com.example.ddd.book.chapter13.domain.member.repository

import com.example.ddd.book.chapter13.domain.club.Club
import com.example.ddd.book.chapter13.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {

    fun findAllByClub(club: Club): List<Member>
}