package com.bcopstein.Aplicacao.CasosDeUso;

import com.bcopstein.Negocio.Servicos.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaProdutoParaVendaUC {
    StockService StockService;

    @Autowired
    public ValidaProdutoParaVendaUC(StockService StockService) {
        this.StockService = StockService;
    }

    public boolean execute(long codigoProduto, int quantidade) {
        return StockService.disponivelEmEstoque(codigoProduto, quantidade);
    }
}