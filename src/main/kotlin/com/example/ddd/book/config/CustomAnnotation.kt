package com.example.ddd.book.config

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Service

class CustomAnnotation

/**
 * 도메인과 레파지토리에 밀접한 도메인 서비스 애노테이션이다.
 * 도메인 서비스끼리는 서로 호출하지 않는게 핵심이다.
 */
@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DomainService(
    @get:AliasFor(annotation = Service::class, attribute = "value")
    val value: String = ""
)

/**
 * 사용자 유스케이스에 대한 전용 애플리케이션 서비스 애노테이션이다.
 */
@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationService(
    @get:AliasFor(annotation = Service::class, attribute = "value")
    val value: String = ""
)
