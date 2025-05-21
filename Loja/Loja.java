import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> catalogo;

    public Loja(){
        this.catalogo = new ArrayList<>();
    }

    public int getTamanho(){
        return this.catalogo.size();
    }

    // Retorna o produto
    public Produto getProduto(int indexCatalogo){
        if (indexCatalogo == -1) return null;

        return this.catalogo.get(indexCatalogo);
    }

    public boolean inserir(Produto produtoIn){
        int indexProduto =  procurarProduto(produtoIn.getcodBarra());
        if (indexProduto != -1) return false; // Já existe

        this.catalogo.add(produtoIn);
        return true;
    }

    // Retorna o index
    public int procurarProduto(String codBarraouNome){
        for(int i = 0; i < this.catalogo.size(); i++){
            Produto produtoAtual = this.catalogo.get(i);

            if (produtoAtual.getcodBarra().equals(codBarraouNome) || produtoAtual.getNome().equals(codBarraouNome)) return i;
        }

        return -1; // Não encontrado
    }

    // Se bem sucedido, retorna a quantidade total do produto
    // Senão, retorna um código de erro
    public int alterarQuantidade(String codBarraIn, int quantidadeIn, boolean add){
        int indexProduto = procurarProduto(codBarraIn);
        if (indexProduto == -1) return -1; // Produto não encontrado

        Produto produtoAtual = this.catalogo.get(indexProduto);
        if (add) produtoAtual.addQuantidade(quantidadeIn); // Adicionar
        else{ // Vender/Subtrair
            if(produtoAtual.subQuantidade(quantidadeIn) == false) return -2; // Quantidade insuficiente
        }

        this.catalogo.set(indexProduto, produtoAtual);
        return this.catalogo.get(indexProduto).getQuantidade(); // Operação bem sucedida
    }
}