import random
import dados as d

class rolaDados:
    """
    Classe auxilar que permite gerenciar
    um conjunto de vários dados simul-
    tâneamente.
    """

    """
    Construtor
    Cria e armazena vários objetos do tipo
    Dado, usando o construtor padrão dessa
    classe. Dados de 6 lados.

    Parâmetros:
    quant (int): quantidade de dados a serem criados. Default = 5
    seed (int): seed para o gerador de números aleatórios. Default = None
    """
    def __init__(self, quant = 5, seed = None):
        self.quant = quant # Quantidade de dados no conjunto
        random.seed(seed) # Definindo a seed do conjunto de dados
        self.seed = seed
        self.dados = [d.Dados(6, seed) for _ in range(quant)] # Inicializando dados

    """
    Rola alguns dos dados

    Parâmetros:
    dados (string): possui o número dos dados a serem rolados, separados por espaço. Default = todos

    Retorno:
    Retorna o valor de cada um dos dados
    """
    def rolar(self, dados = None):
        if dados is None:
            # Rolanod todos os dados
            for dado in self.dados:
                dado.rolar()
        
        else:
            dadosTemp = list(map(int, dados.split())) # Lê a sequência de inteiros digitada pelo usuário como uma string, separa nos espaços, transforma em inteiros e transforma em uma lista
            
            # Rolando os dados fornecidos
            for i in dadosTemp:
                self.dados[i-1].rolar()

        # Retorna os valores de todos os dados, mesmo os que não foram rolados
        return [dado.getLado() for dado in self.dados]
    
    """
    Usa a função toString() de dados.py
    para representar como string todos
    os dados do conjunto.

    Retorno:
    stringFinal (string): string do conjunto de dados
    """
    def __str__(self):
        return self.toString()

    def toString(self):
        string_dados = [dado.toString() for dado in self.dados] # Pegando a string de cada dado

        # Dividindo a string em linhas (mágica)
        linhas_por_dado = [
            [linha for linha in s.split('\n') if linha.strip()]
            for s in string_dados
        ]

        # Determinando número máximo de linhas
        max_linhas = max(len(linhas) for linhas in linhas_por_dado) if linhas_por_dado else 0

        # Combinando linhas correspondentes
        stringFinal = []
        for i in range(max_linhas):
            linha_combinada = []

            for linhas in linhas_por_dado:
                if i < len(linhas):
                    linha_combinada.append(linhas[i])
                else:
                    linha_combinada.append("")
            stringFinal.append("   ".join(linha_combinada))

        return ('\n').join(stringFinal)