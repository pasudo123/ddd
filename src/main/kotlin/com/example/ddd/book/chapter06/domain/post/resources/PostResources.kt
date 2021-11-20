package com.example.ddd.book.chapter06.domain.post.resources

class PostResources {

    data class CreateRequest(
        val title: String,
        val content: String
    )

    data class UpdateRequest(
        val name: String? = null,
        val content: String? = null
    )
}