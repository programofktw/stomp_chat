package com.example.stompchat.domain.chat.controller

import com.example.stompchat.domain.chat.dto.chatroom.responseChatRoomList
import com.example.stompchat.domain.chat.service.ChatRoomService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/chat")
class ChatRoomController(
    val chatRoomService : ChatRoomService,
) {


    @PostMapping()
    fun createChatRoom(){
        chatRoomService.createNewChatRoom()
    }

    @GetMapping
    fun searchChatRoom() : List<responseChatRoomList>{
        return chatRoomService.findAllChatRoom()
    }
}