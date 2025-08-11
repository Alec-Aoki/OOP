from random import Random

class Dados:
    """
    Simula um dado de número de lados variados.
    Ao criar o objeto é possível estabelecer o
    número de lados. A rolagem do dado é feita
    por meio de um gerador de números aleatórios
    (biblioteca random).
    """

    """
    Construtor
    Cria um dado com um número n de lados e uma seed.
    Caso n e/ou seed não sejam informados, seus valores
    padrão são 6 e None, respectivamente.

    Parâmetros:
    n (int): quantidade de lados do dado. Default = 6
    seed (int): seed para geração do número aleatório. Default = None
    """
    def __init__(self, n = 6, seed = None):
        self.lados = n # Define o número de lados do dado
        self.rd = Random(seed)
        self.valor = self.rolar()

    """
    Simula a rolagem do dado por meio de um gerador
    de números aleatórios.

    Retorno:
    self.valor (int): novo valor dado
    """
    def rolar(self):
        self.valor = self.rd.randint(1, self.lados) # Gera um valor aleatório para definir como valor do dado

        return self.valor # Retorna o valor do dado
    
    """
    Retorna o valor atual do dado.

    Retorno:
    self.valor (int): valor atual do dado
    """
    def getLado(self):
        return self.valor
    
    """
    Printa o valor do dado como um desenho (string).

    Retorno:
    stringFinal (string): representação do valor do dado em string
    """
    def __str__(self):
        return self.toString()
    
    def toString(self):
        # Tratamento de erro
        if(self.lados != 6):
            print("Não há representação para esse dados")
            return
            
        # Strings para formatação do dado
        s010 = "|  *  |\n"
        s100 = "|*    |\n"
        s001 = "|    *|\n"
        s000 = "|     |\n"
        s101 = "|*   *|\n"
        s111 = "|* * *|\n"

        stringFinal = "+-----+\n"

        match self.getLado():
            case 1:
                stringFinal += (s000 + s010 + s000)
            case 2:
                stringFinal += (s100 + s000 + s001)
            case 3:
                stringFinal += (s100 + s010 + s001)
            case 4:
                stringFinal += (s101 + s000 + s101)
            case 5:
                stringFinal += (s101 + s010 + s101)
            case 6:
                stringFinal += (s111 + s000 + s111)

        stringFinal += ("+-----+\n")

        return stringFinal