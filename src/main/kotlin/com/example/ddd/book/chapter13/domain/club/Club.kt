package com.example.ddd.book.chapter13.domain.club

import com.example.ddd.book.chapter13.domain.member.Member
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "club")
class Club(
    name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(length = 50, name = "name", nullable = false)
    var name: String = name
        protected set

    @OneToMany(targetEntity = Member::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var members: MutableList<Member> = mutableListOf()
        protected set

    fun addMember(member: Member) {
        if (members.contains(member)) {
            return
        }

        members.add(member)
        member.set(this)
    }
}