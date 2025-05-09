package com.example.stompchat.domain.chat.entity

import jakarta.persistence.*

@Entity
data class ChatText(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id") // FK 컬럼 명시
    var chatRoom : ChatRoom
) {
}