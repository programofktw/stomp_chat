package com.example.stompchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StompChatApplication

fun main(args: Array<String>) {
    runApplication<StompChatApplication>(*args)
}
