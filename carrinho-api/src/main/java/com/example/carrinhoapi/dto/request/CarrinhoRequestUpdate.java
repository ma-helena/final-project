package com.example.carrinhoapi.dto.request;

import com.example.carrinhoapi.model.Produto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
@Slf4j
@AllArgsConstructor
public record CarrinhoRequestUpdate(String id, List<Produto> produto, int quantidade, BigDecimal valor) {
}
