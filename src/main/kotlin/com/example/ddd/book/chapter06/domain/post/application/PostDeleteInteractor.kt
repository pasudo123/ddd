package com.example.ddd.book.chapter06.domain.post.application

import com.example.ddd.book.chapter06.domain.post.repository.PostRepository
import com.example.ddd.book.chapter06.domain.post.service.PostService
import com.example.ddd.book.config.ApplicationService

@ApplicationService
class PostDeleteInteractor(
    private val postService: PostService,
    private val postRepository: PostRepository
) {
    fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}