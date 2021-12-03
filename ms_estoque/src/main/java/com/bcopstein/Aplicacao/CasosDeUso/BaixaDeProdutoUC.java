package com.bcopstein.Aplicacao.CasosDeUso;

import java.util.Collection;

import com.bcopstein.Negocio.Entidades.ItemEstoque.ItemEstoque;
import com.bcopstein.Negocio.Servicos.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaixaDeProdutoUC {
    StockService StockService;

    @Autowired
    public BaixaDeProdutoUC(StockService StockService) {
        this.StockService = StockService;
    }    

    public boolean execute(Collection<ItemEstoque> itens) {
        return StockService.baixa(itens);
    }
}
