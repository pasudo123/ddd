package com.example.ddd.book.chapter07.domain.member.repository

import com.example.ddd.book.chapter03.Member

interface IMemberRepository {

    fun save(member: Member): Member
}