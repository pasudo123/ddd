package com.example.ddd.book.chapter02

data class Money(
    private val amount: Long,
    private val currency: Currency
) {

    enum class Currency(desc: String) {
        USD("달러"),
        KRW("원")
    }
}