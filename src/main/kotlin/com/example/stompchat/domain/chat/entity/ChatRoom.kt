package com.example.stompchat.domain.chat.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
data class ChatRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "romeId")
    var roomId : UUID,

    @OneToMany(mappedBy = "chatRoom", cascade = [CascadeType.ALL], orphanRemoval = true)
    var chatText : MutableList<ChatText>,

    @Column
    var lastText : String
)