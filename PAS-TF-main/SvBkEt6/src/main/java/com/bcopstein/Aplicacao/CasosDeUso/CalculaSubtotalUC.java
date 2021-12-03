package com.bcopstein.Aplicacao.CasosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import com.bcopstein.Aplicacao.Validacao.FactoryValidacao;
import com.bcopstein.Interface.EstoqueProxy;
import com.bcopstein.Interface.DTO.ItemVendaDTO;
import com.bcopstein.Negocio.Repositorio.IProdutos;
import com.bcopstein.Negocio.Servicos.SalesService;
import com.bcopstein.Negocio.Exception.SistVendasException;


@Component
public class CalculaSubtotalUC {
    private IProdutos produtos;
    private FactoryValidacao factoryValidacao;
    private SalesService SalesService;

    @Autowired
    EstoqueProxy estoque;

    @Autowired
    public CalculaSubtotalUC(IProdutos produtos, FactoryValidacao factoryValidacao,
            SalesService SalesService) {
        this.produtos = produtos;
        this.factoryValidacao = factoryValidacao;
        this.SalesService = SalesService;
    }

    public Integer[] execute(final List<ItemVendaDTO> itensVenda) throws SistVendasException {
        // Verifica se todos os itens são válidos
        factoryValidacao.getRegraValidacao().valida(produtos, itensVenda, estoque);
        // Calcula os valores e retorna
        return SalesService.todosValores(itensVenda);
      }
    

    




    
}
