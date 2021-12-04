package com.example.ddd.book.chapter13.domain.club.repository

import com.example.ddd.book.chapter13.domain.club.Club
import org.springframework.data.jpa.repository.JpaRepository

interface ClubRepository : JpaRepository<Club, Long>