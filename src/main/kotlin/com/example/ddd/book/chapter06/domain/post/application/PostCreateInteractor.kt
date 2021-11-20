package com.example.ddd.book.chapter06.domain.post.application

import com.example.ddd.book.chapter06.domain.post.Post
import com.example.ddd.book.chapter06.domain.post.repository.PostRepository
import com.example.ddd.book.chapter06.domain.post.resources.PostResources
import com.example.ddd.book.chapter06.domain.post.service.PostService
import com.example.ddd.book.annotation.ApplicationService

@ApplicationService
class PostCreateInteractor(
    private val postService: PostService,
    private val postRepository: PostRepository
) {

    fun create(request: PostResources.CreateRequest): Long {
        if(postService.existByTitle(request.title)) {
            throw IllegalArgumentException("${request.title}의 포스트는 미리 존재하는 상태입니다.")
        }

        val post = request.run {
            Post(this.title, this.content)
        }

        return postRepository.save(post).id!!
    }
}