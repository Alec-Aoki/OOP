import dados as d
import rolaDados as rd

def main():
    conjDados = rd.rolaDados()
    print(conjDados.toString())

    print(conjDados.rolar())
    print(conjDados.toString())

    print(conjDados.rolar("1 5"))
    print(conjDados.toString())
    
    #novoDado = d.Dados(6 , 1)
    #print(novoDado.getLado())
    #print(novoDado.toString())
    #print(novoDado.rolar())
    #print(novoDado.getLado())
    #print(novoDado.toString())

if __name__ == "__main__":
    main()