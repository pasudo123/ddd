package com.example.ddd.book.chapter13.domain.member

import com.example.ddd.book.chapter13.domain.club.Club
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "member")
class Member(
    name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 50, name = "name")
    var name: String = name
        protected set

    @Column(name = "premium")
    var premium: Boolean = false
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var club: Club? = null
        protected set

    fun applyPremium() {
        this.premium = true
    }

    fun unApplyPremium() {
        this.premium = false
    }

    fun set(club: Club) {
        this.club = club
    }
}