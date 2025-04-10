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
        self.tabuleiro = [[0 for _ in range(tamSqr)] for _ in range(tamSqr)] # Criando a matriz tamSqr x tamSqr

        # Preenchendo o tabuleiro
        k = 0
        for i in range(tamSqr):
            for j in range(tamSqr):
                self.tabuleiro[i][j] = seqNum[k]
                k += 1


def main():
    # Lê a sequência de inteiros digitada pelo usuário como uma string, separa nos espaços, transforma em inteiros e transforma em uma lista
    seqEntrada = list(map(int, input().split()))
    tamEntrada = len(seqEntrada) # Pega o tamanho da lista

    tab = Tabuleiro(seqEntrada, tamEntrada) # Criando objeto tabuleiro

    print(tab.tabuleiro)

if __name__ == "__main__":
    main()