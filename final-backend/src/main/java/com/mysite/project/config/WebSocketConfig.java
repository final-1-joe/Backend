package com.mysite.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS(); // handshake 요청 경로
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/pub"); // publish // 클라이언트가 특정 채팅룸에 메시지를 send 할때
		registry.enableSimpleBroker("/sub", "/queue"); // subscribe // 클라이언트가 특정 채팅룸을 구독(sub) 하고 싶을때
	}
	
	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
		registration.setDecoratorFactories(new AgentWebSocketHandlerDecoratorFactory());
	} 
	
}
	
