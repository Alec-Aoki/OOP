
public class ArvAVL extends ArvBin {
    private int[] heights; // Array para guardar a altura de cada nó

    // Construtor
    public ArvAVL(int capacity){
        super(capacity); // Construtor de ArvBin

        this.heights = new int[capacity]; // Criando vetor de alturas
        // Inicializando vetor
        for(int i = 0; i < heights.length; i++){
            this.heights[i] = -1;
        }
    }

    /* ------------------------ Funções Privadas ------------------------ */

    // Retorna o fator de balanceamento de um nó
    private int balanceFactor(int i){
        // Pegando altura dos nós
        int leftHeight = (left(i) >= this.size)? -1 : heights[left(i)];
        int rightHeight = (right(i) >= this.size)? -1 : heights[right(i)];

        return leftHeight - rightHeight;
    }

    /*Funções auxiliares de movimentação*/
    private void copySubtree(String[] v, int i, int j){  
        if(i >= this.size || getNode(i) == null){
            return;
        }

        v[j] = getNode(i);
        copySubtree(v, left(i), left(j));
        copySubtree(v, right(i), right(j));
    }

    private void writeSubtree(String[] v, int i, int j){
        if(i >= v.length || v[i] == null || j >= this.size){
            return;
        }

        this.binaryTree[j] = v[i];
        writeSubtree(v, left(i), left(j));
        writeSubtree(v, right(i), right(j));
    }

    private void moveSubTree(int i, int j){
        String []v = new String[this.size];

        copySubtree(v, i, 0);
        removeSubtree(i);
        writeSubtree(v, 0, j);        
    }

    private void removeSubtree(int i){
        if(i >= this.size || getNode(i) == null){
            return;
        }

        removeSubtree(left(i));
        removeSubtree(right(i));
        setNode(i, null);
    }

    private void rotateLeft(int i){
        String indexValue = getNode(i);
        if(indexValue == null){
            return;
        }

        this.moveSubTree(left(i), left(left(i)));
        setNode(left(i), indexValue);
        this.moveSubTree(left(right(i)), right(left(i)));
        this.moveSubTree(right(i), i);
        this.updateHeights(i);
    }

    private void rotateRight(int i){
        String indexValue = getNode(i);
        if(indexValue == null){
            return;
        }
        
        this.moveSubTree(right(i), right(right(i)));
        setNode(right(i), indexValue);
        this.moveSubTree(right(left(i)), left(right(i)));
        this.moveSubTree(left(i), i);
        this.updateHeights(i);
    }

    private void balance(int i, String value) {
        if (getNode(left(i)) != null){
            balance(left(i), value);
        }
        if (getNode(right(i)) != null){
            balance(right(i), value);
        }

        int balance = balanceFactor(i); 

        if(balance > 1){
            if(balanceFactor(left(i)) < 0){
                rotateLeft(left(i));
                rotateRight(i);
            }else{
                rotateRight(i);
            }
        }else if(balance < -1){
            if(balanceFactor(right(i)) > 0 ){
                rotateRight(right(i));
                rotateLeft(i);
            }else{
                rotateLeft(i);
            }
        }
    
    }
    
    private int updateHeights(int i){
        if(i >= this.size){
            return -1;
        }
        if(getNode(i) == null){
            this.heights[i] = -1;
            return -1;
        }
        int maxHeight = Math.max(updateHeights(left(i)), updateHeights(right(i))) + 1;
        this.heights[i] = maxHeight;

        return maxHeight;
    }

    /* ------------------------ Funções Públicas ------------------------ */

    @Override
    public boolean insert(String value){
        if(find(value)){
            return false;
        }

        super.insert(value);
        updateHeights(0);
        balance(0, value);

        return true;
    }

    @Override
    public boolean remove(String value) {
        if(!find(value)){
            return false;
        }

        super.remove(value);
        updateHeights(0);
        balance(0, value);

        return true;
    }
}