public class ArvBal extends ArvBin {
    // Construtor
    public ArvBal(int capacity) {
        super(capacity); // Chama o construtor da superclasse (ArvBin)
    }

    /* ------------------------ Funções Privadas ------------------------ */
    // Função recursiva pra reconstruir a árvore
    private void rebuild(int i, String[] elements, int start, int end){
        if(start > end || i >= binaryTree.length){
            return;
        }

        int mid = (start + end)/2;
        binaryTree[i] = elements[mid];

        rebuild(left(i), elements, start, mid - 1);
        rebuild(right(i), elements, mid + 1, end);
    }

    // Função auxiliar pro quickSort
    private int partition(String[] v, int low, int high){
        String pivot = v[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(v[j].compareTo(pivot) <= 0){
                i++;
                String temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }

        String temp = v[i + 1];
        v[i + 1] = v[high];
        v[high] = temp;
        return i + 1;
    }

    // Quicksort pras strings
    private void quickSort(String[] v, int low, int high){
        if(low < high){
            int pivot = partition(v, low, high);
            quickSort(v, low, pivot - 1);
            quickSort(v, pivot + 1, high);
        }
    }

    // Rebalanceamento da árvore
    private void rebalance(){
        // Pegando todos os elementos não nulos
        String[] elements = new String[size];
        int i = 0;

        for(int j = 0; j < binaryTree.length && i < size; j++) { 
            // Itera até o fim do array ou até preencher elements
            if (binaryTree[j] != null) {
                elements[i] = binaryTree[j];
                i++;
            }
        }

        // Ordernar elementos
        quickSort(elements, 0, size - 1);

        int originalSize = size;

        // Esvaziando árvore atual
        for(int j = 0; j < binaryTree.length; j++){
            binaryTree[j] = null;
        }
        size = 0;

        // Reconstruinodo árvore
        if(elements.length > 0){
            rebuild(0, elements, 0, elements.length - 1);
        }
        size = originalSize;
    }

    /* ------------------------ Funções Públicas ------------------------ */

    // Insere e rebalanceia
    @Override
    public boolean insert(String v){      
        boolean inserted = super.insert(v);
        if(inserted) rebalance();
        
        return inserted;
    }

    // Remove e rebalanceia
    @Override
    public boolean remove(String v){
        boolean removed = super.remove(v);
        if(removed) rebalance();
        return removed;
    }
}