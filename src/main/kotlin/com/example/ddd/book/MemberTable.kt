package com.example.ddd.book

import com.example.ddd.book.chapter03.Member

object MemberTable {
    private val memberStore: MutableSet<Member> = mutableSetOf()

    fun save(member: Member) {
        memberStore.add(member)
    }

    fun findAll(): List<Member> {
        return memberStore.toList()
    }

    fun findOneByIdOrNull(id: Long): Member? {
        return memberStore.find { member -> member.id == id }
    }
}