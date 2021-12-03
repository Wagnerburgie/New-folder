package com.bcopstein.Aplicacao.CasosDeUso;

import java.util.Collection;

import com.bcopstein.Negocio.Entidades.ItemEstoque.ItemEstoque;
import com.bcopstein.Negocio.Servicos.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaTodosItemsUC {
    StockService StockService;

    @Autowired
    public ListaTodosItemsUC(StockService StockService) {
        this.StockService = StockService;
    }

    public Collection<ItemEstoque> execute() {
        return StockService.listaTodos();
    }
}
