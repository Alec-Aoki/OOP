
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa as árvores com raiz 100
        ArvBin bin = new ArvBin(100);
        ArvBal bal = new ArvBal(100);
        ArvAVL avl = new ArvAVL(100);
        
        Scanner scanner = new Scanner(System.in);
        
        // Lê todas as linhas até o final da entrada (Ctrl+D / EOF)
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            
            // Ignora linhas vazias
            if (linha.isEmpty()) {
                continue;
            }
            
            // Divide a linha em comando e elemento
            String[] partes = linha.split("\\s+", 2);
            
            // Verifica se tem pelo menos 2 partes (comando + elemento)
            if (partes.length < 2) {
                continue; // Ignora linhas malformadas
            }
            
            String comando = partes[0];
            String elemento = partes[1];
            
            // Processa o comando
            switch (comando) {
                case "i": // Inserção
                    bin.insert(elemento);
                    bal.insert(elemento);
                    avl.insert(elemento);
                    break;
                case "d": // Remoção
                    bin.remove(elemento);
                    bal.remove(elemento);
                    avl.remove(elemento);
                    break;
                // Comandos inválidos são ignorados
            }
        }
        
        scanner.close();
        
        // Saída formatada para o run.codes
        System.out.println(bin);
        
        System.out.println("");
        System.out.println(bal);
        
        System.out.println("");
        System.out.println(avl);
        System.out.println("");
    }
}


/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria a árvore binária com valor inicial 100
        ArvBin bin = new ArvBin(100);
        ArvBal bal = new ArvBal(100);
        ArvAVL avl = new ArvAVL(100);
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite as instruções (i elemento para inserir, d elemento para remover):");
        System.out.println("Exemplo: i Iara");
        System.out.println("Pressione Enter em uma linha vazia para encerrar.");
        
        // Loop para ler todas as instruções até linha vazia
        while (true) {
            String linha = scanner.nextLine().trim();
         
            // Se linha vazia, encerra
            if (linha.isEmpty()) {
                break;
            }
            
            // Divide a linha em partes
            String[] partes = linha.split("\\s+", 2);
           
            if (partes.length < 2) {
                continue;
            }
            
            String comando = partes[0];
            String elemento = partes[1];
            
            if (comando.equals("i")) {
                // Comando de inserção
                bin.insert(elemento);
                bal.insert(elemento);
                avl.insert(elemento);
                
            } else if (comando.equals("d")) {
                // Comando de remoção
                bin.remove(elemento);
                bal.remove(elemento);
                avl.remove(elemento);
            }
        }
        
        scanner.close();

        //System.out.println(bin);
        
        //System.out.println("");
        //System.out.println(bal);
        
        //System.out.println("");
        System.out.println(avl);

        //System.out.println("");
    }
}
*/