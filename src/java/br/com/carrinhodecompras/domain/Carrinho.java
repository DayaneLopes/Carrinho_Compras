package br.com.carrinhodecompras.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;
    private String tipoP;
  

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public Carrinho(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
