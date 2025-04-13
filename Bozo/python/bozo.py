import dados as d
import rolaDados as rD
import placar as plc

class Bozo:
    """
    Classe responsável pela execução do jogo
    """

    """
    Cuida da execução do jogo, possuindo um
    loop que representa cada rodada. Em cada
    rodada, o jogador joga dados até 3 vezes
    e depois escolhe a posição do placar que
    deseja preencher
    """
    @staticmethod
    def main():
        NRORODADAS = 10

        print("Digite a semente (zero para aleatório): ", end='')
        pl = plc.Placar()
        print(pl)
        seed = int(input())

        rd = rD.rolaDados(5, seed)

        for rodada in range(NRORODADAS):
            print(f"****** Rodada {rodada + 1}")
            input("Pressione ENTER para lançar os dados")

            # Primeira tentativa
            rd.rolar()
            print("1          2          3          4          5")
            print(rd)

            # Segunda tentativa
            print("Digite os números dos dados que quiser TROCAR. Separados por espaços.")
            muda = input()
            rd.rolar(muda)
            print("1          2          3          4          5")
            print(rd)

            # Terceira tentativa
            print("Digite os números dos dados que quiser TROCAR. Separados por espaços.")
            muda = input()
            values = rd.rolar(muda)
            print("1          2          3          4          5")
            print(rd)

            print("\n\n")
            print(pl)

            pos = 0
            while (pos <= 0):
                try:
                    pos = int(input("Escolha a posição que quer ocupar com essa jogada ===> "))
                    if (pos > NRORODADAS or pos <= 0):
                        pos = 0
                    pl.add(pos, values)
                except Exception:
                    pos = 0

                if (pos == 0):
                    print("Valor inválido. Posição ocupada ou inexistente.")

            print("\n\n")
            print(pl)

        print("***********************************")
        print("***")
        print(f"*** Seu escore final foi: {pl.getScore()}")
        print("***")
        print("***********************************")