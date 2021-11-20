package com.example.ddd.book.chapter07.domain.member.application

import com.example.ddd.book.chapter03.Member
import com.example.ddd.book.chapter07.domain.member.repository.InMemoryMemberRepository
import com.example.ddd.book.chapter07.domain.member.repository.MysqlMemberRepository
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("MemberInteractor 는")
internal class MemberInteractorTest {

    @Test
    @DisplayName("[InMemoryMemberRepository] 의존성의 추상화 수준을 높여서 의존성을 주입한다. 런타임과 컴파일 의존관계를 변경시킨다.")
    fun saveToInMemoryRepositoryTest() {

        // given
        val inMemoryRepository = InMemoryMemberRepository()

        // when
        val memberInteractor = MemberInteractor(inMemoryRepository)

        // then
        val member = Member("이순신", 50)
        memberInteractor.save(member) shouldNotBe null

    }

    @Test
    @DisplayName("[MySQLMemberRepository] 의존성의 추상화 수준을 높여서 의존성을 주입한다. 런타임과 컴파일 의존관계를 변경시킨다.")
    fun saveToMySQLRepositoryTest() {

        // given
        val mysqlRepository = MysqlMemberRepository()

        // when
        val memberInteractor = MemberInteractor(mysqlRepository)

        // then
        val member = Member("홍길동", 30)
        memberInteractor.save(member) shouldNotBe null
    }
}