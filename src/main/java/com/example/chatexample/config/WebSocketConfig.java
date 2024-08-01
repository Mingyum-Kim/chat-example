package com.example.chatexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // 웹 소켓 서버로 사용
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	// 웹 소켓 연결을 설정하는 클래스

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 클라이언트와 서버가 상호 연결 가능한 엔드포인트 등록
		registry.addEndpoint("/chat").withSockJS();
		// 웹 소켓을 사용하지 않는 브라우저를 위해 SockJS 를 활성화
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 클라이언트 간의 메시지 전송을 위한 메시지 브로커를 설정
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}
}
