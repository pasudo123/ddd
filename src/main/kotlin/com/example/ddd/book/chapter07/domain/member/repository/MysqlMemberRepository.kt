package com.example.ddd.book.chapter07.domain.member.repository

import com.example.ddd.book.chapter03.Member

class MysqlMemberRepository : IMemberRepository {

    override fun save(member: Member): Member {
        return member
    }
}