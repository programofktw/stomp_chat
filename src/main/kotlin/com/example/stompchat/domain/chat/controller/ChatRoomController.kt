package com.example.stompchat.domain.chat.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/chat")
class ChatRoomController {


    @PostMapping()
    fun createChatRoom(){

    }
}