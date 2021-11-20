package com.example.ddd.book.chapter06.domain.post.service

import com.example.ddd.book.chapter06.domain.post.repository.PostRepository
import com.example.ddd.book.annotation.DomainService

@DomainService
class PostService(
    private val postRepository: PostRepository
) {

    fun existByTitle(title: String): Boolean {
        postRepository.findByTitle(title) ?: return false
        return true
    }
}