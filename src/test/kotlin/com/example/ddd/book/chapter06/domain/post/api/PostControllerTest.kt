package com.example.ddd.book.chapter06.domain.post.api

import com.example.ddd.IntegrationSupport
import com.example.ddd.book.chapter06.domain.post.repository.PostRepository
import com.example.ddd.book.chapter06.domain.post.resources.PostResources
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@IntegrationSupport
@DisplayName("PostController 는")
internal class PostControllerTest(
    private val sut: PostController,
    private val postRepository: PostRepository
) {

    @BeforeEach
    fun init() {
        postRepository.deleteAll()
    }

    @Test
    @DisplayName("post 를 생성한다.")
    fun createTest() {

        // given
        val request = PostResources.CreateRequest(
            title = "컨테이너 인프라 환경",
            content = "블라블라블라"
        )

        // when
        val postId = sut.create(request)

        // then
        val foundPost = postRepository.findById(postId).get()
        foundPost.id shouldBe postId
        foundPost.title shouldBe "컨테이너 인프라 환경"
        foundPost.content shouldBe "블라블라블라"
    }

    @Test
    @DisplayName("post 를 생성시 에러 발생 : 동일한 타이틀의 post 가 존재하는 경우 에러가 발생한다.")
    fun createThrowTestIfTitleExist() {

        // given
        val request = PostResources.CreateRequest(
            title = "홍길동전",
            content = "옛날 옛적에..."
        )
        sut.create(request)

        // when
        val newRequest = PostResources.CreateRequest(
            title = "홍길동전",
            content = "이것은 새로운 이야기..."
        )
        val error = assertThrows<IllegalArgumentException> {
            sut.create(newRequest)
        }

        // then
        error.message shouldBe "홍길동전의 포스트는 미리 존재하는 상태입니다."
    }
}