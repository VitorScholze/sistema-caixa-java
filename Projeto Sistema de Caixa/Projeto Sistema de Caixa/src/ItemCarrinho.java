public class ItemCarrinho {
Produto produto;
int quantidade;

ItemCarrinho(Produto produto, int quantidade){
    this.produto = produto;
    this.quantidade = quantidade;
}

Produto getProduto(){
    return produto;
}


int getQuantidade(){
    return quantidade;
}

double getSubTotal(){
    return produto.getPreco() * quantidade;
}


public String toString(){
    return "Produto:" + produto.getNome() + " // Quantidade: " + quantidade + " // R$" + produto.getPreco() ;
}
    

}
