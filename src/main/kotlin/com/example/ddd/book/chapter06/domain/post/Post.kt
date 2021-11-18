package com.example.ddd.book.chapter06.domain.post

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "post")
class Post(
    title: String,
    content: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(nullable = false)
    var content: String = content
        protected set
}