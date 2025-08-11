import math

class Tabuleiro:
    """
    Classe para representar o tabuleiro

    Atributos:
    seqNum (int): Matriz de inteiros que representa o tabuleiro propriamente dito
    tamanho (int): Quantidade total de posições no tabuleiro
    """

    def __init__(self, seqNum, tamanho):
        tamSqr = int(math.sqrt(tamanho)) # Quantidade de colunas e fileiras que o tabuleiro terá
        self.tamSqr = tamSqr

        self.tabuleiro = [[0 for _ in range(tamSqr)] for _ in range(tamSqr)] # Criando a matriz tamSqr x tamSqr

        # Preenchendo o tabuleiro
        k = 0
        for i in range(tamSqr):
            for j in range(tamSqr):
                self.tabuleiro[i][j] = seqNum[k]
                k += 1

    # Retorna as coordenadas i e j da posição do 0 dentro do tabuleiro
    def encontrarZero(self):
        for i in range(self.tamSqr):
            for j in range(self.tamSqr):
                if(self.tabuleiro[i][j] == 0):
                    return i, j
                
    # Funções de movimento:
    def direita(self):
        i, j = self.encontrarZero()
        if(j != 0):
            # Possível mover a peça pra direita, trocar os valores
            self.tabuleiro[i][j] = self.tabuleiro[i][j - 1]
            self.tabuleiro[i][j - 1] = 0

    def esquerda(self):
        i, j = self.encontrarZero()
        if(j != self.tamSqr - 1):
            # Possível mover a peça pra direita, trocar os valores
            self.tabuleiro[i][j] = self.tabuleiro[i][j + 1]
            self.tabuleiro[i][j + 1] = 0

    def cima(self):
        i, j = self.encontrarZero()
        if(i != self.tamSqr - 1):
            # Possível mover a peça pra direita, trocar os valores
            self.tabuleiro[i][j] = self.tabuleiro[i + 1][j]
            self.tabuleiro[i + 1][j] = 0

    def baixo(self):
        i, j = self.encontrarZero()
        if(i != 0):
            # Possível mover a peça pra direita, trocar os valores
            self.tabuleiro[i][j] = self.tabuleiro[i - 1][j]
            self.tabuleiro[i - 1][j] = 0

    def tabuleiroCorreto(self):
        k = 0
        for i in range(self.tamSqr):
            for j in range(self.tamSqr):
                if(self.tabuleiro[i][j] != k):
                    return False
                k += 1

        return True
    
    def printarTabuleiro(self):
        linhaHoriz = "+" + "------+" * self.tamSqr
        print(linhaHoriz)
        for i in range(self.tamSqr):
            linha = "|"
            for j in range(self.tamSqr):
                if(self.tabuleiro[i][j] == 0):
                    linha += f"      |"
                else:
                    linha += f"  {self.tabuleiro[i][j]:2d}  |"
            print(linha)
            print(linhaHoriz)

def main():
    # Lê a sequência de inteiros digitada pelo usuário como uma string, separa nos espaços, transforma em inteiros e transforma em uma lista
    seqEntrada = list(map(int, input().split()))
    tamEntrada = len(seqEntrada) # Pega o tamanho da lista

    tab = Tabuleiro(seqEntrada, tamEntrada) # Criando objeto tabuleiro

    tab.printarTabuleiro() # Printando tabuleiro inicial
    print("")

    movimentos = list(input()) # Pegando string de movimentos e transformando em uma lista de chars

    # Executando os movimentos digitados
    for i in range(len(movimentos)):
        mov = movimentos[i]
        if(mov == 'd'):
            tab.baixo()
        elif(mov == 'u'):
            tab.cima()
        elif(mov == 'l'):
            tab.esquerda()
        elif(mov == 'r'):
            tab.direita()

        tab.printarTabuleiro() # Printa o tabuleiro após cada movimento
        print("")


    print(f"Posicao final: {tab.tabuleiroCorreto()}")

if __name__ == "__main__":
    main()