import java.util.Scanner;

public class main{
    public static void main(String[] args){
        Loja loja = new Loja();

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("");

        while(scanner.hasNextLine()){ 
            input = scanner.nextLine(); 
            if (input == null) break;

            String[] strings = input.split(",");

            switch(strings[0]){
                case "I":
                    boolean inserido = false;

                    if(strings[1].equals("Livro")){
                        Livro livro = new Livro(strings[2], strings[3], Integer.parseInt(strings[6]), 0, strings[4], strings[5],  Integer.parseInt(strings[7]), Integer.parseInt(strings[8]), strings[9]);

                        inserido = loja.inserir(livro);
                        System.out.println("Operação inserir livro: " + Long.parseLong(strings[2]));
                    }
                    else if(strings[1].equals("CD")){
                        CD cd =  new CD(strings[2], strings[3], Integer.parseInt(strings[7]), 0, strings[4], Integer.parseInt(strings[5]), strings[6]);

                        inserido = loja.inserir(cd);

                        System.out.println("Operação inserir CD: " + Long.parseLong(strings[2]));
                    }
                    else if(strings[1].equals("DVD")){
                        DVD dvd = new DVD (strings[2], strings[3], Integer.parseInt(strings[7]), 0, strings[4], strings[5], strings[6], strings[8]);  

                        inserido = loja.inserir(dvd); 

                        System.out.println("Operação inserir DVD: " + Long.parseLong(strings[2]));                     
                    }

                    if(inserido) System.out.println("Operação realizada com sucesso\n");
                    else System.out.println("***Erro: Código já cadastrado: " + Long.parseLong(strings[2]));

                    break;
                case "A":
                    System.out.println("Operação de compra: " + Long.parseLong(strings[1]));

                    if(loja.alterarQuantidade(strings[1], Integer.parseInt(strings[2]), true) >= 0) System.out.println("Operação realizada com sucesso: " + Long.parseLong(strings[1]) + "\n");
                    else  System.out.println("***Erro: Código inexistente: " + Long.parseLong(strings[1]) + "\n");

                    break;
                case "V":
                    int quantRes = loja.alterarQuantidade(strings[1], Integer.parseInt(strings[2]), false);
                    
                    if(quantRes >= 0){
                        if(loja.getProduto(loja.procurarProduto(strings[1])).getcodBarra().equals(strings[1])) System.out.println("Operação de venda: " + Long.parseLong(strings[1]));
                        else System.out.println("Operação de venda: " + strings[1]);

                        System.out.println("Operação realizada com sucesso: " + Long.parseLong(strings[1]) + "\n");
                    }
                    else{
                        System.out.println("Operação de venda: " + strings[1]);
                        if(quantRes == -1) System.out.println("***Erro: Código inexistente: " + strings[1] + "\n");
                        else if (quantRes == -2) System.out.println("***Erro: Estoque insuficiente: " + strings[1] + " Quantidade: " + strings[2] + "\n");
                    }

                    break;
                case "P":
                    System.out.println("Procurando: " + strings[1]);  

                    int indexProduto = loja.procurarProduto(strings[1]);
                    if (indexProduto == -1) System.out.println("Produto não encontrado: " + strings[1] + "\n");
                    else System.out.println("Encontrado:\n" + loja.getProduto(indexProduto).toString(false));

                    break;
                case "S":
                    System.out.println("Operação de sumarização: ");
                    int quantTotal = 0;

                    for(int i = 0; i < loja.getTamanho(); i++){
                        Produto produtoAtual = loja.getProduto(i);
                        if(produtoAtual.getTipo() == 1){
                            quantTotal += produtoAtual.getQuantidade();
                            System.out.println(produtoAtual.toString(true));
                        }
                    }
                    System.out.println("Quantidade de Livros: " + quantTotal + "\n");

                    quantTotal = 0;

                    for(int i = 0; i < loja.getTamanho(); i++){
                        Produto produtoAtual = loja.getProduto(i);
                        if(produtoAtual.getTipo() == 2){
                            quantTotal += produtoAtual.getQuantidade();
                            System.out.println(produtoAtual.toString(true));
                        }
                    }
                    System.out.println("Quantidade de CDs: " + quantTotal + "\n");

                    quantTotal = 0;

                    for(int i = 0; i < loja.getTamanho(); i++){
                        Produto produtoAtual = loja.getProduto(i);
                        if(produtoAtual.getTipo() == 3){
                            quantTotal += produtoAtual.getQuantidade();
                            System.out.println(produtoAtual.toString(true));
                        }
                    }
                    System.out.println("Quantidade de DVDs: " + quantTotal + "\n\n");


                    break;                     
            } 
        }
        
    }
}