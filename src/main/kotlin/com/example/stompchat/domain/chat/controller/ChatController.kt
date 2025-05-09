package com.example.stompchat.domain.chat.controller

import com.example.stompchat.domain.chat.dto.MessageRequestDto
import com.example.stompchat.domain.chat.dto.MessageResponseDto
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class ChatController(
    private val messagingTemplate: SimpMessagingTemplate
) {

    @MessageMapping("/chat") // /app/chat으로 오면 받는 것
    @SendTo("/topic/chat/{roomId}") // 구독한 사람들에게 뿌리는 것 즉 채팅방 속 사람들은 해당 url을 구독
    fun sendMessage(messageRequestDto: MessageRequestDto){
        val messageResponseDto = MessageResponseDto(content = messageRequestDto.content)

        // 동적으로 roomId 기반으로 메시지를 전송
        messagingTemplate.convertAndSend(
            "/topic/chat/${messageRequestDto.roomId}",
            messageResponseDto
        )
    }
}