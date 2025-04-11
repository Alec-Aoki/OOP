import dados
import rolaDados
import placar

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
    def main():
        NRORODADAS = 10

        print("Digite a semente (zero para aleatório): ")
        seed = int(input())

        rd = rolaDados(5, seed)
        pl = placar()
        print(pl)

        for rodada in NRORODADAS:
            print("****** Rodada " + (rodada+1))
            print("Pressione ENTER para lançar os dados")
            input()

            rd.rolar()
            print("1          2          3          4          5")
            print(rd)

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
                    print("Escolha a posição que quer ocupar com essa jogada ===> ")
                    pos = int(input())
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
        print("*** Seu escore final foi: " + pl.getScore())
        print("***")
        print("***********************************")