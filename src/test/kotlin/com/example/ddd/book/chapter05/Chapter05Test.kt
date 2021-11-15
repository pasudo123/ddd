package com.example.ddd.book.chapter05

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestConstructor
import javax.persistence.EntityNotFoundException

@DisplayName("Chapter05Test 는")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Chapter05Test(
    private val testEntityManager: TestEntityManager,
    private val personRepository: PersonRepository
) {

    @BeforeEach
    fun init() {
        personRepository.deleteAll()
    }

    @Test
    @Order(10)
    fun `(1) Person 을 영속화한다`() {

        // given
        val person = Person.create("홍길동")

        // when
        testEntityManager.persistAndFlush(person)
        testEntityManager.clear()

        // then
        val foundPerson = personRepository.findById(person.id!!).get()
        foundPerson.id shouldBe person.id!!
        foundPerson.name shouldBe "홍길동"
    }

    @Test
    @Order(20)
    fun `(2) 동일한 Person 이 있는지 검사한다 (필요한 정보만 딱 보낸다)`() {

        // given
        val person = Person.create("이순신")
        testEntityManager.persistAndFlush(person)
        testEntityManager.clear()

        // when
        val foundPerson = personRepository.findOneByName(person.name).orElseThrow { throw EntityNotFoundException("${person.name} 을 가진 Person 을 찾을 수 없습니다.") }

        // then
        foundPerson shouldNotBe null
    }
}