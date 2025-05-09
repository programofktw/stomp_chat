package com.example.stompchat.domain.chat.dto

import java.util.*

data class MessageRequestDto(
    val content : String, // 메세지
    val roomId : UUID
)
