
public class Produto {

    static int contador = 1;
    String nome;
    double preco;
    int id;

    int cont = 0;
    Produto(String nome, double preco){
        this.id = contador++;
        this.nome = nome;
        this.preco = preco;
    }
    
int getId(){
    return id;
}

String getNome(){
    return nome;
}

double getPreco(){
    return preco;
}

public String toString(){
    return "Produto: " + nome + " // Preço: " + preco;
}





}

