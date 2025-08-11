public class Cadeira{
    // Variáveis de estado
    private String posicao;
    private boolean ocupado;

    // Construtores
    public Cadeira(){ // Vai criar uma cadeira com valores pré-definidos
        ocupado = false;
        posicao = "Em pe";
    }

    public Cadeira(String posicaoEntrada, boolean ocupadoEntrada){ // Vai criar uma cadeira de acordo com os parâmetros passados
        posicao = posicaoEntrada;
        ocupado = ocupadoEntrada;
    }

    // Funções
    public void sentar(){
        if((!ocupado) && (posicao.equals("Em pe"))) ocupado = true;
    }

    public void levantar(){
        ocupado = false;
    }

    public void virar(){
        if(posicao.equals("Em pe")){
            posicao = "Virado";
            ocupado = false;
        }
        else{
            posicao = "Em pe";
        }
    }

    public String getPosicao(){
        return posicao;
    }
}