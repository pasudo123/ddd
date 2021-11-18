package com.example.ddd.book.chapter06.domain.post.api

import com.example.ddd.book.chapter06.domain.post.Post
import com.example.ddd.book.chapter06.domain.post.application.PostCreateInteractor
import com.example.ddd.book.chapter06.domain.post.application.PostDeleteInteractor
import com.example.ddd.book.chapter06.domain.post.resources.PostResources
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("posts")
class PostController(
    private val postCreateInteractor: PostCreateInteractor,
    private val postDeleteInteractor: PostDeleteInteractor
) {

    @PostMapping
    fun create(request: PostResources.CreateRequest): Long {
        return postCreateInteractor.create(request)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        postDeleteInteractor.deleteById(id)
    }
}