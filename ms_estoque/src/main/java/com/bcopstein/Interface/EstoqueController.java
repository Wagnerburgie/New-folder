package com.bcopstein.Interface;

import java.util.Collection;
import java.util.List;

import com.bcopstein.Aplicacao.CasosDeUso.BaixaDeProdutoUC;
import com.bcopstein.Aplicacao.CasosDeUso.ChegadaDeProdutosUC;
import com.bcopstein.Aplicacao.CasosDeUso.ListaItemsDisponiveisParaVendaUC;
import com.bcopstein.Aplicacao.CasosDeUso.ListaTodosItemsUC;
import com.bcopstein.Aplicacao.CasosDeUso.ValidaProdutoParaVendaUC;
import com.bcopstein.Negocio.Entidades.ItemEstoque.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
  ListaTodosItemsUC listaTodosItemsUC;


  ChegadaDeProdutosUC chegadaDeProdutosUC;
  ListaItemsDisponiveisParaVendaUC listaItemsDisponiveisParaVendaUC;
  ValidaProdutoParaVendaUC validaProdutoParaVendaUC;
  BaixaDeProdutoUC baixaDeProdutoUC;

  @Autowired
  public EstoqueController(ChegadaDeProdutosUC chegadaDeProdutosUC, 
  ListaTodosItemsUC listaTodosItemsUC, ListaItemsDisponiveisParaVendaUC listaItemsDisponiveisParaVendaUC,
  ValidaProdutoParaVendaUC validaProdutoParaVendaUC, BaixaDeProdutoUC baixaDeProdutoUC) {
    this.chegadaDeProdutosUC = chegadaDeProdutosUC;
    this.listaTodosItemsUC = listaTodosItemsUC;
    this.listaItemsDisponiveisParaVendaUC = listaItemsDisponiveisParaVendaUC;
    this.validaProdutoParaVendaUC = validaProdutoParaVendaUC;
    this.baixaDeProdutoUC = baixaDeProdutoUC;
  }

  @GetMapping("/todos")
  public Collection<ItemEstoque> todos() {
    return listaTodosItemsUC.execute();
  }

  @PostMapping("/chegada")
  public boolean chegadaDeProdutos(@RequestBody List<ItemEstoque> itens) {
    	return chegadaDeProdutosUC.execute(itens);
  }

  @GetMapping("/produtos")
  public Collection<ItemEstoque> disponiveisParaVenda() {
    return listaItemsDisponiveisParaVendaUC.execute();
  }


  @GetMapping("/verificaDisponivel/cod/{codigoProduto}/qnt/{quantidade}")
  public boolean produtoDisponivel(@PathVariable long codigoProduto, @PathVariable int quantidade) {
    return validaProdutoParaVendaUC.execute(codigoProduto, quantidade);
  }

  @PostMapping("/baixa")
  public boolean baixaEstoque(@RequestBody Collection<ItemEstoque> itens) {
    return baixaDeProdutoUC.execute(itens);
  }
}