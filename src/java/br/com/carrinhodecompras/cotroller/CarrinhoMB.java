package br.com.carrinhodecompras.cotroller;

import br.com.carrinhodecompras.domain.Carrinho;
import br.com.carrinhodecompras.domain.Produto;
import br.com.carrinhodecompras.util.UtilMessages;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "carrinhoMB")
@SessionScoped
public class CarrinhoMB {
    FacesContext context = FacesContext.getCurrentInstance();
    
    private List<Produto> produtos = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    
    public CarrinhoMB() {
        
    }
    
    
    public void adicionarCarrinho(Produto produto){
        
       if(produtos.add(produto)){
        carrinho.setProdutos(produtos);
            UtilMessages.messageInfo("Adicionado ao carrinho com sucesso!");
        }else{
            UtilMessages.messageError("Ocorreu um erro ao adicionar ao carrinho!");
       }
    }
     public void excluir(Produto produto){
        produtos.remove(produto);     
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

}
