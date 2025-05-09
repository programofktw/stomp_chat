package com.example.stompchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class StompChatApplication

fun main(args: Array<String>) {
    runApplication<StompChatApplication>(*args)
}
