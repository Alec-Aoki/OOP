package Tabuleiro;

import java.io.IOException;
import java.util.Scanner;

public class Tabuleiro {
    private int[][] tabuleiro;
    private int tamanho;

    /*Construtor*/
    public Tabuleiro(Scanner scanner){
        String seqNum = scanner.nextLine(); // Lendo a sequência de números digitada como uma string
        String[] partesSeq = seqNum.split(" "); // Quebrando a sequência nos números individuais

        this.tamanho = (int) Math.sqrt(partesSeq.length); // Pegando o tamanho do tabuleiro a partir da quantidade de números digitados

        tabuleiro = new int[tamanho][tamanho]; // Criando o tabuleiro (matriz de inteiros)

        // Loop para preencher o tabuleiro com os números
        int k = 0;
        for(int i=0; i < tamanho; i++){
            for(int j=0; j < tamanho; j++){
                tabuleiro[i][j] = Integer.parseInt(partesSeq[k]); // Transformando o número de string pra int e colocando no tabuleiro
                k++;
            }
        }
    }

    /*Função auxiliar*/
    private int[] encontrarZero(){
        // Encontrando o zero:
        int[] v = new int[2]; // Array para armazenar os índices i e j do zero

        for(int i=0; i < tamanho; i++){
            for(int j=0; j < tamanho; j++){
                if(tabuleiro[i][j] == 0){ // Zero encontrado
                    v[0] = i;
                    v[1] = j;

                    break;
                }
            }
        }

        return v;
    }

    /*Funções de movimento*/
    public void direita(){
        // Encontrando o zero:
        int[] v = encontrarZero();

        if(v[1] != 0){
            // Possível mover a peça para a direita, trocar os valores
            tabuleiro[v[0]][v[1]] = tabuleiro[v[0]][v[1] - 1];
            tabuleiro[v[0]][v[1] - 1] = 0;
        }
    }
    public void esquerda(){
        // Encontrando o zero:
        int[] v = encontrarZero();

        if(v[1] != tamanho - 1){
            // Possível mover a peça para a esquerda, trocar os valores
            tabuleiro[v[0]][v[1]] = tabuleiro[v[0]][v[1] + 1];
            tabuleiro[v[0]][v[1] + 1] = 0;
        }
    }
    public void cima(){
        // Encontrando o zero:
        int[] v = encontrarZero();

        if(v[0] != tamanho - 1){
            // Possível mover a peça para cima, trocar os valores
            tabuleiro[v[0]][v[1]] = tabuleiro[v[0] + 1][v[1]];
            tabuleiro[v[0] + 1][v[1]] = 0;
        }
    }
    public void baixo(){
        // Encontrando o zero:
        int[] v = encontrarZero();

        if(v[0] != 0){
            // Possível mover a peça para baixo, trocar os valores
            tabuleiro[v[0]][v[1]] = tabuleiro[v[0] - 1][v[1]];
            tabuleiro[v[0] - 1][v[1]] = 0;
        }
    }

    /*Verificar se o tabuleiro está correto*/
    public boolean tabuleiroCorreto(){
        int k = 0;
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                if(tabuleiro[i][j] != k) return false;

                k++;
            }
        }

        return true;
    }

    /*Printar o tabuleiro (magia do mal)*/
    public void printarTabuleiro(){
        // Ajustando o tamanho dos delimitadores de acordo com o tamanho do tabuleiro
        StringBuilder linhaHoriz = new StringBuilder("+");
        for (int i = 0; i < tamanho; i++) {
            linhaHoriz.append("------+");
        }
        System.out.println(linhaHoriz);

        // Printando o tabuleiro em si
        for(int i = 0; i < tamanho; i++){
            System.out.print("|");
            for(int j = 0; j < tamanho; j++){
                System.out.printf("  %2d  |", tabuleiro[i][j]);
            }
            System.out.println("\n" + linhaHoriz);
        }
    }
}