package com.example.ddd.book.chapter02

/**
 * https://youtrack.jetbrains.com/issue/KT-11914
 * kotlin 을 이용하여 DDD Value Object 를 만들때 직면하는 문제로 보인다.
 */
data class User private constructor(
    val paramFirstName: String,
    val paramLastName: String
) {

    var firstName: String? = paramFirstName
        private set

    var lastName: String? = paramLastName
        private set

    fun updateFirstName(firstName: String) {
        this.firstName = firstName
        this.validateNameOrThrow()
    }

    private fun validateNameOrThrow() {
        require(firstName!!.length > 3) { "firstName 이 세자리 미만입니다." }
        require(lastName!!.length > 3) { "lastName 이 세자리 미만입니다." }
    }

    companion object {
        fun from(firstName: String, lastName: String): User {
            return User(firstName, lastName).also { user ->
                user.validateNameOrThrow()
            }
        }
    }
}