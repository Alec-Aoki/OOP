import math

class Tabuleiro:
    def __init__(self, seqNum, tamanho):
        tamSqr = int(math.sqrt(tamanho))
        self.tabuleiro = [[0 for _ in range(tamSqr)] for _ in range(tamSqr)]

        k = 0
        for i in range(tamSqr):
            for j in range(tamSqr):
                self.tabuleiro[i][j] = seqNum[k]
                k += 1



def main():
    seqEntrada = list(map(int, input().split()))
    tamEntrada = len(seqEntrada)

    tab = Tabuleiro(seqEntrada, tamEntrada)

    print(tab.tabuleiro)

if __name__ == "__main__":
    main()