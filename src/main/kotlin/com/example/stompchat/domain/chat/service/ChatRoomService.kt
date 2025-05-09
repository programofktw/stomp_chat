package com.example.stompchat.domain.chat.service

import com.example.stompchat.domain.chat.dto.chatroom.responseChatRoomList
import com.example.stompchat.domain.chat.entity.ChatRoom
import com.example.stompchat.domain.chat.repository.ChatRoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
class ChatRoomService(
    val chatRoomRepository: ChatRoomRepository
) {

    @Transactional(readOnly = true)
    fun findAllChatRoom() : MutableList<responseChatRoomList> {
        val chatRoomList = chatRoomRepository.findAll()

        val response :MutableList<responseChatRoomList> = mutableListOf()

        for(chatRoom : ChatRoom in chatRoomList){
            response.add(responseChatRoomList(roomId = chatRoom.roomId))
        }

        return response
    }

    @Transactional
    fun createNewChatRoom(){
        val room = ChatRoom(roomId = UUID.randomUUID())

        chatRoomRepository.save(room)
    }

}