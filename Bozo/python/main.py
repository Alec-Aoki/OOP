import dados as d

def main():
    novoDado = d.Dados(6 , 1)
    print(novoDado.getLado())
    print(novoDado.toString())
    print(novoDado.rolar())
    print(novoDado.getLado())
    print(novoDado.toString())

if __name__ == "__main__":
    main()