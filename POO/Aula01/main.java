public class main{
    static public void main(String args[]){
        Cadeira c1 = new Cadeira();
        Cadeira c2 = new Cadeira("Virado", false);
        c1.sentar();
        c2.virar();
        System.out.println(c1.getPosicao());
        System.out.println(c2.getPosicao());
    }
}