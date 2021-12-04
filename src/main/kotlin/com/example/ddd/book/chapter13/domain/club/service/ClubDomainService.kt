package com.example.ddd.book.chapter13.domain.club.service

import com.example.ddd.book.annotation.DomainService
import com.example.ddd.book.chapter13.domain.club.Club
import com.example.ddd.book.chapter13.domain.club.repository.ClubRepository
import com.example.ddd.book.chapter13.domain.member.Member
import com.example.ddd.book.chapter13.domain.member.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import javax.persistence.EntityNotFoundException

@Transactional
@DomainService
class ClubDomainService(
    private val clubRepository: ClubRepository,
) {

    fun join(club: Club, member: Member): Long {
        club.addMember(member)
        clubRepository.save(club)
        return club.id!!
    }

    fun findOneIdOrThrow(clubId: Long): Club {
        // clubFinder 를 만들고 거기서 작업하는 것이 좋을 수 있다.
        return clubRepository.findByIdOrNull(clubId)
            ?: throw EntityNotFoundException("클럽을 찾을 수 없습니다.")
    }
}