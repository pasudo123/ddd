package com.example.ddd.book.config

import org.springframework.stereotype.Service

class CustomAnnotation

@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DomainService(val value: String = "")

@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationService(val value: String = "")
