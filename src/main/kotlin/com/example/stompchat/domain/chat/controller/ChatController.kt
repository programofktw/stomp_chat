package com.example.stompchat.domain.chat.controller

import com.example.stompchat.domain.chat.dto.MessageRequestDto
import com.example.stompchat.domain.chat.dto.MessageResponseDto
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatController {

    @MessageMapping("/chat") // /app/chat으로 오면 받는 것
    @SendTo("/topic/chat/1") // 구독한 사람들에게 뿌리는 것 즉 채팅방 속 사람들은 해당 url을 구독
    fun sendMessage(messageRequestDto: MessageRequestDto) : MessageResponseDto{
        val messageResponseDto = MessageResponseDto(content = messageRequestDto.content)

        return messageResponseDto
    }
}