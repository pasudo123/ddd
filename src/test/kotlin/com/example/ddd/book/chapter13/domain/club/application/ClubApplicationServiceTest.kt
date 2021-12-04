package com.example.ddd.book.chapter13.domain.club.application

import com.example.ddd.IntegrationSupport
import com.example.ddd.book.chapter13.domain.club.Club
import com.example.ddd.book.chapter13.domain.club.repository.ClubRepository
import com.example.ddd.book.chapter13.domain.member.Member
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.persistence.EntityManager

@IntegrationSupport
@DisplayName("ClubApplicationService 는")
internal class ClubApplicationServiceTest(
    private val clubApplicationService: ClubApplicationService,
    private val clubRepository: ClubRepository,
    private val entityManager: EntityManager
) {

    @Test
    @DisplayName("클럽 내 가입인원이 초과하면 에러가 발생한다.")
    fun joinThrowTest() {

        // given
        val club = Club("우당탕탕 클럽")
        clubRepository.save(club)
        club.id!! shouldNotBe null
        with(entityManager) {
            this.flush()
            this.clear()
        }

        println("[1]====================================")
        repeat(30) {
            clubApplicationService.join(club.id!!, Member("홍길동 $it"))
            with(entityManager) {
                this.flush()
                this.clear()
            }
        }

        val foundClub = clubRepository.findById(club.id!!).get()
        foundClub.members

        println("[2]====================================")
        // when
        val exception = assertThrows<RuntimeException> {
            clubApplicationService.join(club.id!!, Member("강감찬"))
        }

        // thenㅡ
        exception.message shouldBe "클럽의 가입인원은 가득 찼습니다."
    }
}