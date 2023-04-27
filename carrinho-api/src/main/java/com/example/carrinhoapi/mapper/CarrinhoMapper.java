package com.example.carrinhoapi.mapper;

import com.example.carrinhoapi.dto.request.CarrinhoRequestUpdate;
import com.example.carrinhoapi.dto.response.CarrinhoResponse;
import com.example.carrinhoapi.model.Carrinho;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper  {
    CarrinhoResponse carrinhoRequestToCarrinhoResponse(CarrinhoRequestUpdate carrinhoRequestUpdate);
    CarrinhoResponse carrinhoToCarrinhoResponse(Carrinho carrinho);
    Carrinho carrinhoRequestToCarrinho(CarrinhoRequestUpdate carrinhoRequestUpdate);
}
