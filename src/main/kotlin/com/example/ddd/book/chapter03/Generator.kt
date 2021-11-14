package com.example.ddd.book.chapter03

import java.util.concurrent.atomic.AtomicLong

object Generator {
    private val memberId = AtomicLong(1)

    fun getMemberId(): Long {
        return memberId.getAndIncrement()
    }
}