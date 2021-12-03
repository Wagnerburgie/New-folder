package com.bcopstein.Aplicacao.CasosDeUso;

import java.util.List;

import com.bcopstein.Negocio.Entidades.ItemEstoque.ItemEstoque;
import com.bcopstein.Negocio.Servicos.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChegadaDeProdutosUC {
    StockService StockService;

    @Autowired
    public ChegadaDeProdutosUC(StockService StockService) {
        this.StockService = StockService;
    }

    public boolean execute(List<ItemEstoque> itens) {
        try {
            StockService.chegadaDeProdutos(itens);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
