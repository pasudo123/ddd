package com.example.ddd.book.chapter04

import com.example.ddd.book.MemberTable
import com.example.ddd.book.chapter03.Member

/**
 * 도메인 서비스 ( != 애플리케이션 서비스 )
 */
class MemberService {
    fun isExistMember(currentMember: Member): Boolean {
        val members = MemberTable.findAll()
        members.find { member -> member.isSameAsNameAndAge(currentMember) }
            ?: return false

        return true
    }
}

fun Member.isSameAsNameAndAge(currentMember: Member): Boolean {
    return this.name == currentMember.name && this.age == currentMember.age
}