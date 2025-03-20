# Java
## Classes
```public```: modificador de acesso que torna a classe acessível a outras classes; tem que ser salva em um arquivo de mesmo nome

Funções são similares a em C, mas cada um com seu controle de acesso. Como pretendemos criar uma classe Saça que usará a classe Cadeira, os controles serão todos públicos, contudo, as variáveis de estado serão privadas (para serem alteradas somente com as funções da classe Cadeira).

```private``` significa que o membro só pode ser acessado dentro da classe (ocultamento de informação/encapsulamento).

Os construtores (inicializadores) tem o mesmo nome da classe e sem tipo declarado. Pode haver mais de um construtor.

Os tipos de dados e operadores também são similares a C.

```java
// Classe Cadeira
public class Cadeira{
    // Variáveis de estado
    private String posicao;
    private boolean ocupado;

    // Construtores
    public Cadeira(){ // Vai criar uma cadeira com valores pré-definidos
        ocupado
    }

    public Cadeira(String posicao, boolean ocupacao){ // Vai criar uma cadeira de acordo com os parâmetros passados
        
    }

    // Funções
    public void sentar(){

    }

    public void levantar(){

    }

    public void virar(){

    }

    public String getPosicao(){

    }
}
```