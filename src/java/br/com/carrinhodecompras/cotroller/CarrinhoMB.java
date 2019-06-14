package br.com.carrinhodecompras.cotroller;

import br.com.carrinhodecompras.domain.Produto;
import br.com.carrinhodecompras.util.UtilMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "carrinhoMB")
@SessionScoped
public class CarrinhoMB implements Serializable{
    FacesContext context = FacesContext.getCurrentInstance();
    
    private List<Produto> carrinho = new ArrayList<>();
    private int qnt = 0;
    private float soma = 0;
    
    public CarrinhoMB() {
        this.carrinho = new ArrayList<Produto>();
        this.listar();
    }
    
    public ArrayList<Produto> listar(){
        return (ArrayList<Produto>) carrinho;
    }
    
    public void adicionarCarrinho(Produto produto){
        
       if(carrinho.add(produto)){
           UtilMessages.messageInfo("Adicionado ao carrinho com sucesso!");
           
        }else{
            UtilMessages.messageError("Ocorreu um erro ao adicionar ao carrinho!");
       }
    }
    
    public void excluir(Produto produto){
        carrinho.remove(produto);     
    }
     
    public String somar(Produto produto){
       
        for(Produto p: carrinho){
            soma = soma + p.getPreco();
        }
        return "pagamento.xhtml?faces-redirect=true";
    }
    
    public String finalizar (){
        
        if(soma == 0){
           UtilMessages.messageInfo("Não há produtos no carrinho");
        }else
            UtilMessages.messageInfo("Obrigado por comprar conosco, volte sempre!");
            soma = 0;
            carrinho.clear();
        
        return "list.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public float getSoma() {
        return soma;
    }

    public void setSoma(float soma) {
        this.soma = soma;
    }
}
