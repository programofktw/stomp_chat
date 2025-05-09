package com.example.stompchat.infra.stomp.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker // 메시지 브로커가 지원하는 WebSocket 메시지 처리 활성화
class WebSocketConfig() : WebSocketMessageBrokerConfigurer {
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("ws") //http://localhost:8080/ws
            .setAllowedOriginPatterns("*")
            .withSockJS() //SockJS를 같이 쓰겠다 -> SockJS에서 알아서 SockJs fallback
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker("/topic") //심플 브로커로 연결하는
        registry.setApplicationDestinationPrefixes("/app") //server로 가는 것.
    }
}