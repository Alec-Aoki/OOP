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
        print("")
        
        for rodada in range(NRORODADAS):
            print(f"****** Rodada {rodada + 1}")
            input("Pressione ENTER para lançar os dados\n")

            # Primeira tentativa
            rd.rolar()
            print("1          2          3          4          5")
            print(rd)
            print("")

            # Segunda tentativa
            print("Digite os números dos dados que quiser TROCAR. Separados por espaços.")
            muda = input()
            rd.rolar(muda)
            print("1          2          3          4          5")
            print(rd)
            print("")

            # Terceira tentativa
            print("Digite os números dos dados que quiser TROCAR. Separados por espaços.")
            muda = input()
            values = rd.rolar(muda)
            print("1          2          3          4          5")
            print(rd)
            print("")

            print("\n\n")
            print(pl)
            print("")

            pos_add = False
            while not pos_add:
                try:
                    print("Escolha a posição que quer ocupar com essa jogada ===> ", end='')
                    pos = input()
                    if not pos.strip():
                        continue
                    
                    try:
                        pos = int(pos)
                    except ValueError:
                        print("Valor inválido. Posição ocupada ou inexistente.")
                        continue
                    
                    if pos <= 0 or pos > NRORODADAS:
                        print("Valor inválido. Posição ocupada ou inexistente.")
                        continue
                    
                    pl.add(pos, values)
                    pos_add = True
                    
                except ValueError as e:
                    print("Valor inválido. Posição ocupada ou inexistente.")
                except Exception as e:
                    print("Valor inválido. Posição ocupada ou inexistente.")

            print("\n\n")
            print(pl)
            print("")

        print("***********************************")
        print("***")
        print(f"*** Seu escore final foi: {pl.getScore()}")
        print("***")
        print("***********************************")