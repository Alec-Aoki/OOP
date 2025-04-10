import copy

class Placar:
    """
    Essa classe representa o placar de
    um jogo de Bozó. Permite que com-
    binações de dados sejam alocadas
    às posições e mantém o score de um
    jogador.
    """

    """
    Adiciona uma sequência de dados a
    uma determinada posição do placar.
    Após a chamada, aquela posição se
    torna ocupada e não pode mais ser
    usada.

    Parâmetros:
    posicao (int): posição a ser preenchida
    dados (int): array de tamanho 5 que representa os valores dos dados
    """
    def add(self, posicao, dados):
        self.placar = [] # Vetor para representar as posições do placar e o valor em cada posição
        self.ocupados = [] # Vetor de booleanos que marca se uma posição do placar está ocupada
        self.posicoes = 10 # Quantidade de posições no placar

        if(self.ocupados[posicao - 1]):
            print("Posição ocupada")
            return
        
        k = 0
        match posicao:
            case 1:
                k = conta(1, dados)
            case 2:
                k = conta(2, dados)
            case 3:
                k = conta(3, dados)
            case 4:
                k = conta(4, dados)
            case 5:
                k = conta(5, dados)
            case 6:
                k = conta(6, dados)
            case _:
                print("Valor da posição ilegal")
                return
        
        self.placar[posicao - 1] = k
        self.ocupados[posicao - 1] = True


    """
    Computa a soma dos valores obtidos,
    considerando apenas as posições que
    já estão ocupadas.

    Retorno:
    total (int): valor da soma
    """
    def getScore(self):
        total = 0
        for i in range(self.posicoes):
            if (self.ocupados[i]):
                total += self.placar[i]

        return total
    
    # Função auxiliar
    def conta(n, vet):
        cont = 0

        for i in vet:
            if (i == n):
                cont += 1

        return cont
    
    # Funções de pontuação

    def checkFull(dados):
        v = copy.copy(dados)
        v.sort()
        return ( v[0] == v[1] and v[1] == v[2] and v[3] == v[4]) or ( v[0] == v[1] and v[2] == v[3] and v[3] == v[4])
    
    def checkQuadra(dados):
        v = copy.copy(dados)
        v.sort()
        return ( v[0] == v[1] and v[1] == v[2] and v[2] == v[3]) or ( v[1] == v[2] and v[2] == v[3] and v[3] == v[4])

    def checkQuina(dados):
        v = copy.copy(dados)
        v.sort()
        return ( v[0] == v[1] and v[1] == v[2] and v[2] == v[3] and v[3] == v[4])

    def checkSeqMaior(dados):
        v = copy.copy(dados)
        v.sort()
        return ( v[0] == v[1]-1 and v[1] == v[2]-1 and v[2] == v[3]-1 and v[3] == v[4]-1);

    """
    Representação do placar na forma de string,
    indicando as posições livres (e seus números),
    e posições ocupadas (e seu valor)

    Retorno:
    stringFinal (string): string do placar
    """
    # TLDR: Mágica de string
    def toString(self):
        stringFinal = ""
        for i in range(3):
            # First column (positions 1-3)
            num1 = f"{self.placar[i]:<4}" if self.ocupados[i] else f"({i+1}) "
            # Second column (positions 7-9)
            num2 = f"{self.placar[i+6]:<4}" if self.ocupados[i+6] else f"({i+7}) "
            # Third column (positions 4-6)
            num3 = f"{self.placar[i+3]:<4}" if self.ocupados[i+3] else f"({i+4}) "
            
            stringFinal += f"{num1}   |   {num2}   |   {num3}\n--------------------------\n"
        
        # Bottom row (position 10)
        num10 = f"{self.placar[9]:<4}" if self.ocupados[9] else "(10)"
        stringFinal += f"       |   {num10}   |\n       +----------+\n"
        return stringFinal