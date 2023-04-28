package com.example.carrinhoapi.dto.request;

import com.example.carrinhoapi.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CarrinhoRequestUpdate{
    String id;
    List<Produto> produto;
    int quantidade;
    BigDecimal valor;
}
