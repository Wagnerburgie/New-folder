package com.bcopstein.Aplicacao.CasosDeUso;

import java.util.Collection;

import com.bcopstein.Negocio.Entidades.Venda.Venda;
import com.bcopstein.Negocio.Servicos.SalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListaVendaUC {
    SalesService SalesService;

    @Autowired
    public ListaVendaUC(SalesService SalesService) {
        this.SalesService = SalesService;
    }

    public Collection<Venda> execute() {
        return SalesService.listaVendas();
    }
}
