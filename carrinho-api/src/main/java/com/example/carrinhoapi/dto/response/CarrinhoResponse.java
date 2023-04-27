package com.example.carrinhoapi.dto.response;

import com.example.carrinhoapi.model.Produto;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CarrinhoResponse(String id, List<Produto> produto, BigDecimal valor, int quantidade) {
}
