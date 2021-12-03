package com.bcopstein.Aplicacao.CasosDeUso;

import com.bcopstein.Negocio.Entidades.Venda.Venda;
import com.bcopstein.Negocio.Servicos.SalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistraVendaUC {
    SalesService SalesService;

    @Autowired
    public RegistraVendaUC(SalesService SalesService) {
        this.SalesService = SalesService;
    }

    public boolean execute(Venda venda) {
        try {
            SalesService.cadastra(venda);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
