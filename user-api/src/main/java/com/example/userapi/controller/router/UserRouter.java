package com.example.userapi.controller.router;

import com.example.userapi.controller.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
@Configuration
@RequiredArgsConstructor
public class UserRouter {
    private final UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions
                .route(POST("/user"), userHandler::save)
                .andRoute(GET("/user"), userHandler::findAll)
                .andRoute(GET("/user/{id}"), userHandler::findById);
    }

}
