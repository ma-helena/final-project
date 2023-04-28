package com.example.userapi.client;

import com.example.carrinhoapi.model.Carrinho;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@FeignClient(name = "carrinho-api", url = "http://localhost:8081")
public interface CarrinhoFeign {

    @PostMapping("/carrinho")
    ResponseEntity<Mono<Void>> save(@RequestBody Carrinho carrinho);

    @GetMapping("/carrinho")
    ResponseEntity<Flux<Carrinho>> findAll();

    @PostMapping("/carrinho/{atualizar}")
    ResponseEntity<Mono<Void>> atualizar(@PathVariable("atualizar") String id, Carrinho carrinho);
}
