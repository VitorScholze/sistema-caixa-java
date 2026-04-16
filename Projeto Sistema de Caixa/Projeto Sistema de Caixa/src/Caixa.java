import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {

Scanner sc = new Scanner(System.in);
ArrayList<Produto> produtos = new ArrayList<>();

Carrinho carrinho = new Carrinho();
int id = 1;

void executar(){
    while(true){
        menu();
    int resp = sc.nextInt();
    sc.nextLine();
    
    switch(resp){

        case 1:
            cadastrarProdutos();
            break;

        case 2: 
            listarProdutos();
            break;

        case 3:
            adicionarAoCarrinho();
            break;

        case 4:
            verCarrinho();
            break;

        case 5:
            System.out.println("Digite o Id do produto a ser removido:");
            int idRemover = sc.nextInt();
            carrinho.removerItem(idRemover);
            break;

        case 6:
            finalizarCompra();
            break;
        
        case 7:
            System.out.println("Saindo....");
            return;


        

    }
        
    }
}

void menu() {
    System.out.println("==============");
    System.out.println("     MENU     ");
    System.out.println("==============");

    System.out.println("1 - Cadastrar Produto");
    System.out.println("2 - Listar Produtos");
    System.out.println("3 - Adicionar ao Carrinho");
    System.out.println("4 - Ver Carrinho");
    System.out.println("5 - Remover Item do Carrinho");
    System.out.println("6 - Finalizar Compra");
    System.out.println("7 - Sair");
}



void cadastrarProdutos() {
    System.out.println("Quantos produtos voce quer cadastrar?:");
    int qtd = sc.nextInt();
    sc.nextLine(); 

    int c = 0;

    while (c < qtd) {

        System.out.println("Digite o nome do produto:");
        String nome = sc.nextLine();

        System.out.println("Valor do Produto:");
        double valor = sc.nextDouble();
        sc.nextLine(); 
        if(valor <=0){
            System.out.println("O valor precisa ser maior que 0.");
            continue;
        }

        Produto produto = new Produto(nome, valor);
        produtos.add(produto);

        id++;
        c++;
    }
}

void listarProdutos(){
    produtos.stream()
            .forEach(System.out::println);
}

void buscarProdutoId(){
    System.out.println("Qual o id do produto que voce deseja buscar?");
    int id = sc.nextInt();

    for(Produto p : produtos){
        if(p.getId() == id){
            System.out.println(p);
        }else{
            System.out.println("Produto nao encontrado.");
        }
    }
}

void adicionarAoCarrinho(){
    System.out.println("Digite o ID do produto a ser adicionado: ");
    int id = sc.nextInt();

    System.out.println("Digite a quantidade: ");
    int quantidade = sc.nextInt();
    if(quantidade <= 0){
        System.out.println("A quantidade precisa ser maior que 0.");
    }

    Produto ProdutoEncontrado = null;

    for(Produto p : produtos){
        if(p.getId() == id){
            ProdutoEncontrado = p;
            break;
        }
    }

    if(ProdutoEncontrado != null){
        carrinho.adicionarItem(ProdutoEncontrado, quantidade);
    }else{
        System.out.println("Id inexistente");
    }
}


void verCarrinho(){
    carrinho.listarItens();
}


void finalizarCompra(){

    if (carrinho.estaVazio()) {
        System.out.println("Seu carrinho está vazio");
        return;
    }

    double total = carrinho.calcularTotal();

    System.out.println("Total da compra: R$ " + total);

    System.out.println("Digite o valor pago:");
    double pago = sc.nextDouble();

    if (pago >= total) {
        System.out.println("Troco: R$ " + (pago - total));
        carrinho.limparCarrinho();
        System.out.println("Compra finalizada!");
    } else {
        System.out.println("Valor insuficiente!");
    }
}
}


