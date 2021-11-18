package com.example.ddd.book.chapter06.domain.post.application

import com.example.ddd.book.chapter06.domain.post.repository.PostRepository
import com.example.ddd.book.chapter06.domain.post.resources.PostResources
import com.example.ddd.book.config.ApplicationService

@ApplicationService
class PostCreateInteractor(
    private val postRepository: PostRepository
) {

    fun create(request: PostResources.CreateRequest): Long {
        TODO("Not yet implemented")
    }
}