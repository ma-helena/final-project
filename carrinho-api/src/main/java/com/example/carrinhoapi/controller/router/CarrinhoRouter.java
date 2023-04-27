package com.example.carrinhoapi.controller.router;

import com.example.carrinhoapi.controller.handler.CarrinhoHandler;
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
public class CarrinhoRouter {
    private final CarrinhoHandler carrinhoHandler;
    @Bean
    public RouterFunction<ServerResponse> routes (){
        return RouterFunctions
                .route(POST("/carrinho"), carrinhoHandler::save)
                .andRoute(GET("/carrinho"), carrinhoHandler::findAll)
                .andRoute(POST("/carrinho/{atualizar}"), carrinhoHandler::atualizar);
    }
}
