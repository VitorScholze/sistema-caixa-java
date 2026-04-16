import java.util.ArrayList;

public class Carrinho {
    

    ArrayList<ItemCarrinho> itens = new ArrayList<>();
    Carrinho(){

    }

    void adicionarItem(Produto produto , int quantidade){
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        itens.add(item);
    }

    void removerItem(int id){
        itens.removeIf(item -> item.getProduto().getId() == id);
    }

    void listarItens(){
        if(itens.isEmpty()){
            System.out.println("Carrinho está vazio!");
            return;
        }

        itens.stream()
             .forEach(System.out::println);
        
    }

    double calcularTotal(){
        double total = 0;
        for(ItemCarrinho item : itens){
            total += item.getSubTotal();
        }
        return total;
    }


    void limparCarrinho(){
        itens.removeAll(itens);
    }

    boolean estaVazio(){
        return itens.isEmpty();
    }



}
