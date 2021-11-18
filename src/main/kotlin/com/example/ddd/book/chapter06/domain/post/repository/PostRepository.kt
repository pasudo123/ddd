package com.example.ddd.book.chapter06.domain.post.repository

import com.example.ddd.book.chapter06.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long>