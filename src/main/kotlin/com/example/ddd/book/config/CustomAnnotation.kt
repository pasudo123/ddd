package com.example.ddd.book.config

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Service

class CustomAnnotation

@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DomainService(
    @get:AliasFor(annotation = Service::class, attribute = "value")
    val value: String = ""
)

@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationService(
    @get:AliasFor(annotation = Service::class, attribute = "value")
    val value: String = ""
)
