package com.example.carrinhoapi.controller.handler;

import com.example.carrinhoapi.dto.request.CarrinhoRequestUpdate;
import com.example.carrinhoapi.dto.response.CarrinhoResponse;
import com.example.carrinhoapi.model.Carrinho;
import com.example.carrinhoapi.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoHandler {
    private final CarrinhoService carrinhoService;
    //save -> ok
    public Mono<ServerResponse> save(ServerRequest request) {

        return request.bodyToMono(Carrinho.class)
                .flatMap(carrinhoService::salvar)
                .flatMap(response -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(response)));
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<CarrinhoResponse> catalogResponses = carrinhoService
                .listar()
                .map(list -> CarrinhoResponse.builder()
                        .id(list.id())
                        .produto(list.produto())
                        .valor(list.valor())
                        .quantidade(list.quantidade())
                        .build());
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(catalogResponses, CarrinhoResponse.class));
    }
    public Mono<ServerResponse> atualizar(ServerRequest request) {
        Mono<List<CarrinhoRequestUpdate>> productUpdateRequestList = request.bodyToFlux(CarrinhoRequestUpdate.class).collectList();
        return productUpdateRequestList
                .flatMap(productUpdates -> {
                    for (CarrinhoRequestUpdate update : productUpdates) {
                        String produtoId = update.id();
                        carrinhoService.atualizar(produtoId, update).subscribe();
                    }
                    return ServerResponse.ok().build();
                })
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }
}
