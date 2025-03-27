package Tabuleiro;

import java.io.IOException;
import java.util.Scanner;

public class mainTab{
    static public void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        Tabuleiro tab = new Tabuleiro(scanner); // Criando novo tabuleiro

        tab.printarTabuleiro();
        System.out.println();

        // Lendo movimentos
        String movimentos = scanner.nextLine();

        // Executando a direção dada
        for(int i = 0; i < movimentos.length(); i++){
            char mov = movimentos.charAt(i); // Pegando o caractere na posição i da string movimentos
            if(mov == 'd') tab.baixo();
            else if(mov == 'u') tab.cima();
            else if(mov == 'l') tab.esquerda();
            else if(mov == 'r') tab.direita();

            tab.printarTabuleiro();
            System.out.print("\n");
        }

        if(tab.tabuleiroCorreto()){
            System.out.println("Posicao final: true");
        }
        else System.out.println("Posicao final: false");
    }
}