package com.example.ddd.book.chapter07.domain.member.repository

import com.example.ddd.book.chapter03.Member

class InMemoryMemberRepository : IMemberRepository{

    override fun save(member: Member): Member {
        return member
    }
}