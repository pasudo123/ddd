package com.example.ddd.book.chapter13.domain.club.application

import com.example.ddd.book.annotation.ApplicationService
import com.example.ddd.book.chapter13.domain.club.service.ClubDomainService
import com.example.ddd.book.chapter13.domain.club.service.ClubJoinSpecification
import com.example.ddd.book.chapter13.domain.member.Member
import com.example.ddd.book.chapter13.domain.member.repository.MemberRepository
import com.example.ddd.book.chapter13.domain.member.service.MemberDomainService
import org.springframework.transaction.annotation.Transactional

@Transactional
@ApplicationService
class ClubApplicationService(
    private val clubDomainService: ClubDomainService,
    private val memberDomainService: MemberDomainService,
    private val memberRepository: MemberRepository
) {

    /**
     * - 각각의 도메인 서비스는 서로 다른 도메인를 침범하지 않도록 한다.
     * - 도메인에 대한 규칙은 도메인안에 국한시키지 않도록 한다. 객체끼리의 협력을 통해 해결.
     */
    fun join(clubId: Long, member: Member) {
        val club = clubDomainService.findOneIdOrThrow(clubId)

        val clubJoinSpecification = ClubJoinSpecification(memberRepository)
        if(clubJoinSpecification.isFull(club)) {
            throw RuntimeException("클럽의 가입인원은 가득 찼습니다.")
        }

        memberDomainService.save(member)
        clubDomainService.join(club, member)
    }
}