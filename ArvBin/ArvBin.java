public class ArvBin {
    protected String[] binaryTree;
    protected int size;

    public ArvBin(int capacity) {
        this.binaryTree = new String[capacity];
        this.size = 0;
    }

    /* ------------------------ Funções Protegidas ------------------------ */
    
    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected String getNode(int i) {
        if (i >= binaryTree.length || binaryTree[i] == null)
            return null;
        return binaryTree[i];
    }

    protected boolean setNode(int i, String v) {
        if (i >= binaryTree.length)
            return false;
        binaryTree[i] = v;
        return true;
    }

    protected int countNodes(int i) {
        if (i >= binaryTree.length || binaryTree[i] == null)
            return 0;
        return 1 + countNodes(left(i)) + countNodes(right(i));
    }

    protected void swap(int i, int j) {
        if (i >= binaryTree.length || j >= binaryTree.length)
            return;
        String temp = binaryTree[i];
        binaryTree[i] = binaryTree[j];
        binaryTree[j] = temp;
    }
    
    protected int findMinInSubtree(int i) {
        if (i >= binaryTree.length || binaryTree[i] == null)
            return -1;
        
        while (left(i) < binaryTree.length && binaryTree[left(i)] != null) {
            i = left(i);
        }
        return i;
    }

    // Adicionar este novo método para encontrar o maior elemento em uma subárvore
    protected int findMaxInSubtree(int i) {
        if (i >= binaryTree.length || binaryTree[i] == null)
            return -1;
        
        while (right(i) < binaryTree.length && binaryTree[right(i)] != null) {
            i = right(i);
        }
        return i;
    }

    // Retorna o índice do nó com a string v
    protected int findRetIndex(String v) {
        return findRecursive(0, v);
    }

    /* ------------------------ Funções Privadas ------------------------ */

    private int findRecursive(int i, String v) {
        if (i >= binaryTree.length || binaryTree[i] == null)
            return -1;
        
        int cmp = v.compareTo(binaryTree[i]);
        if (cmp == 0)
            return i;
        else if (cmp < 0)
            return findRecursive(left(i), v);
        else
            return findRecursive(right(i), v);
    }

    private boolean insertRecursive(int i, String v) {
        if (i >= binaryTree.length)
            return false;

        if (binaryTree[i] == null) {
            binaryTree[i] = v;
            size++;
            return true;
        }

        int cmp = v.compareTo(binaryTree[i]);
        if (cmp == 0) // Valor já existe
            return false;
        else if (cmp < 0)
            return insertRecursive(left(i), v);
        else
            return insertRecursive(right(i), v);
    }

    private void removeRecursive(int i, String v) {
        if (i >= binaryTree.length || binaryTree[i] == null)
            return;

        int cmp = v.compareTo(binaryTree[i]);
        if (cmp < 0) {
            removeRecursive(left(i), v);
        } else if (cmp > 0) {
            removeRecursive(right(i), v);
        } else {
            // Caso 1: Nó folha
            if ((left(i) >= binaryTree.length || binaryTree[left(i)] == null) && 
                (right(i) >= binaryTree.length || binaryTree[right(i)] == null)) {
                binaryTree[i] = null;
            }
            // Caso 2: Apenas filho esquerdo
            else if (right(i) >= binaryTree.length || binaryTree[right(i)] == null) {
                binaryTree[i] = binaryTree[findMaxInSubtree(left(i))];
                removeRecursive(left(i), binaryTree[i]);
            }
            // Caso 3: Apenas filho direito
            else if (left(i) >= binaryTree.length || binaryTree[left(i)] == null) {
                binaryTree[i] = binaryTree[findMinInSubtree(right(i))];
                removeRecursive(right(i), binaryTree[i]);
            }
            // Caso 4: Dois filhos - Implementação do filho mais próximo
            else {
                // Encontra o maior da esquerda e o menor da direita
                int maxLeft = findMaxInSubtree(left(i));
                int minRight = findMinInSubtree(right(i));
                
                // Escolhe o mais próximo (ou o maior da esquerda em caso de empate)
                if (maxLeft - i < minRight - i) {
                    binaryTree[i] = binaryTree[maxLeft];
                    removeRecursive(maxLeft, binaryTree[maxLeft]);
                } else {
                    binaryTree[i] = binaryTree[minRight];
                    removeRecursive(minRight, binaryTree[minRight]);
                }
            }
        }
    }

    /* ------------------------ Funções Públicas ------------------------ */

    public boolean find(String v) {
        if(findRecursive(0, v) != -1){
            return true;
        }
        return false;
    }

    public boolean insert(String v) {
        if (size >= binaryTree.length)
            return false;
        return insertRecursive(0, v);
    }

    public int len() {
        return size;
    }

    public boolean remove(String v) {
        if (!find(v))
            return false;
        
        removeRecursive(0, v);
        size--;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph {\n");

        boolean hasEdges = false;

        for (int i = 0; i < binaryTree.length; i++) {
            if (binaryTree[i] != null) {
                String current = i + " " + binaryTree[i];
                boolean hasChild = false;

                if (left(i) < binaryTree.length && binaryTree[left(i)] != null) {
                    String leftChild = left(i) + " " + binaryTree[left(i)];
                    sb.append("\"").append(current).append("\" ->\"").append(leftChild).append("\"\n");
                    hasChild = true;
                }
                if (right(i) < binaryTree.length && binaryTree[right(i)] != null) {
                    String rightChild = right(i) + " " + binaryTree[right(i)];
                    sb.append("\"").append(current).append("\" ->\"").append(rightChild).append("\"\n");
                    hasChild = true;
                }

                if (!hasChild && !hasEdges) {
                    // Só um elemento e sem filhos — colocar o nó e o '}' na mesma linha
                    sb.append("\"").append(current).append("\" }");
                    return sb.toString();
                }

                hasEdges = true;
            }
        }

        sb.append("}");
        return sb.toString();
    }
}