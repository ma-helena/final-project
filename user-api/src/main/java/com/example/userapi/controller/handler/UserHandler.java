package com.example.userapi.controller.handler;

import com.example.userapi.dto.request.UserRequest;
import com.example.userapi.dto.response.UserResponse;
import com.example.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserHandler {
    private final UserService userService;
//salvar -> ok
    public Mono<ServerResponse> save(ServerRequest request) {

        return request.bodyToMono(UserRequest.class)
                .flatMap(userService::salvar)
                .flatMap(response -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(response)));
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<UserResponse> catalogResponses = userService
                .buscar()
                .map(list -> UserResponse.builder()
                        .id(list.getId())
                        .email(list.getEmail())
                        .name(list.getName())
                        .password(list.getPassword())
                        .build());
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(catalogResponses, UserResponse.class));
    }
    public Mono<ServerResponse> findById(ServerRequest request) {

        String id = request.pathVariable("id");
        Mono<UserResponse> responseMono = userService.buscarPorId(id)
                .map(buscar -> new UserResponse(
                        buscar.getId(),
                        buscar.getEmail(),
                        buscar.getName(),
                        buscar.getEmail()));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                        .fromPublisher(responseMono, UserResponse.class));

    }}
