package com.example.carrinhoapi.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record Carrinho(String id, List<Produto> produto, BigDecimal valor, int quantidade ) {
}

