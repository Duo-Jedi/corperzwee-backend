package com.ajibigad.corperwee.config;

/**
 * Created by Julius on 13/04/2016.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.
        AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.
        EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.
        StompEndpointRegistry;
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig
        extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/notification").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
