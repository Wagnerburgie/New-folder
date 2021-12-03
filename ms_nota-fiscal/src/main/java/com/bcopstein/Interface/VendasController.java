package com.bcopstein.Interface;

import java.util.Collection;

import com.bcopstein.Aplicacao.CasosDeUso.ListaVendaUC;
import com.bcopstein.Aplicacao.CasosDeUso.RegistraVendaUC;
import com.bcopstein.Negocio.Entidades.Venda.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nota-fiscal")
public class SalesController {
  private RegistraVendaUC registraVendaUC;
  private ListaVendaUC listaVendaUC;

  @Autowired
  public SalesController(RegistraVendaUC registraVendaUC, ListaVendaUC listaVendaUC) {
    this.registraVendaUC = registraVendaUC;
    this.listaVendaUC = listaVendaUC;
  }

  @PostMapping("/venda")
  public boolean registraVenda(@RequestBody Venda venda) {
    return registraVendaUC.execute(venda);
  }

  @GetMapping("/lista")
  public Collection<Venda> listaVendas() {
    return listaVendaUC.execute();
  }
}
