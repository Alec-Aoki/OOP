import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> catalogo;

    public Loja(){
        this.catalogo = new ArrayList<>();
    }

    public Produto getProduto(int indexCatalogo){
        if (indexCatalogo == -1) return null;

        return this.catalogo.get(indexCatalogo);
    }

    public void inserir(Produto produtoIn){
        this.catalogo.add(produtoIn);
    }

    public int procurarProdutoCod(int codBarraIn){
        for(int i = 0; i < this.catalogo.size(); i++){
            Produto produtoAtual = this.catalogo.get(i);

            if (produtoAtual.getcodBarra() == codBarraIn) return i;
        }

        return -1;
    }

    public int procurarProdutoNome(String nomeIn){
        for(int i = 0; i < this.catalogo.size(); i++){
            Produto produtoAtual = this.catalogo.get(i);

            if (produtoAtual.getNome().equals(nomeIn)) return i;
        }

        return -1;
    }

    public void alterarQuantidade(int codBarraIn, int quantidadeIn, boolean add){
        int indexProduto = procurarProdutoCod(codBarraIn);
        if (indexProduto == -1) return;

        Produto produtoAtual = this.catalogo.get(indexProduto);
        if (add) produtoAtual.addQuantidade(quantidadeIn); // Adicionar
        else produtoAtual.subQuantidade(quantidadeIn); // Vender

        this.catalogo.set(indexProduto, produtoAtual);
    }


}