import heapq
from collections import defaultdict
import sys

class Grafo:
    def __init__(self):
        self.vertices = defaultdict(dict)
        self.ordem_entrada = []  # Mantém a ordem de entrada das cidades
    
    def adicionar_aresta(self, origem, destino, peso):
        """Adiciona uma aresta ao grafo"""
        self.vertices[origem][destino] = peso
    
    def adicionar_cidade_origem(self, cidade):
        """Adiciona uma cidade na ordem de entrada"""
        if cidade not in self.ordem_entrada:
            self.ordem_entrada.append(cidade)
    
    def obter_vertices(self):
        """Retorna todos os vértices do grafo"""
        todos_vertices = set(self.vertices.keys())
        for origem in self.vertices:
            todos_vertices.update(self.vertices[origem].keys())
        return list(todos_vertices)
    
    def obter_ordem_entrada(self):
        """Retorna a ordem das cidades conforme aparecem na entrada"""
        return self.ordem_entrada

class Dijkstra:
    def __init__(self, grafo):
        self.grafo = grafo
        self.distancias = {}
        self.predecessores = {}
        self.visitados = set()
    
    def inicializar(self, inicio):
        """Inicializa as estruturas de dados para o algoritmo"""
        todos_vertices = self.grafo.obter_vertices()
        
        # Inicializar todas as distâncias como infinito
        for vertice in todos_vertices:
            self.distancias[vertice] = float('inf')
            self.predecessores[vertice] = None
        
        # Distância do vértice inicial para ele mesmo é 0
        self.distancias[inicio] = 0
        self.visitados.clear()
    
    def executar(self, inicio):
        """
        Executa o algoritmo de Dijkstra para encontrar o menor caminho
        do vértice inicial para todos os outros vértices
        """
        self.inicializar(inicio)
        
        # Fila de prioridade (heap) para processar vértices
        heap = [(0, inicio)]
        
        while heap:
            distancia_atual, vertice_atual = heapq.heappop(heap)
            
            # Se já foi visitado, pula
            if vertice_atual in self.visitados:
                continue
            
            # Marca como visitado
            self.visitados.add(vertice_atual)
            
            # Processa vizinhos
            self._processar_vizinhos(vertice_atual, distancia_atual, heap)
        
        return self.distancias, self.predecessores
    
    def _processar_vizinhos(self, vertice_atual, distancia_atual, heap):
        """Processa os vizinhos do vértice atual"""
        if vertice_atual in self.grafo.vertices:
            for vizinho, peso in self.grafo.vertices[vertice_atual].items():
                nova_distancia = distancia_atual + peso
                
                # Se encontrou um caminho mais curto
                if nova_distancia < self.distancias[vizinho]:
                    self.distancias[vizinho] = nova_distancia
                    self.predecessores[vizinho] = vertice_atual
                    heapq.heappush(heap, (nova_distancia, vizinho))
    
    def construir_caminho(self, inicio, destino):
        """Constrói o caminho do início ao destino usando os predecessores"""
        caminho = []
        atual = destino
        
        # Se não há caminho para o destino
        if self.predecessores[destino] is None and inicio != destino:
            return []
        
        # Constrói o caminho de trás para frente
        while atual is not None:
            caminho.append(atual)
            atual = self.predecessores[atual]
        
        # Inverte para obter o caminho correto
        caminho.reverse()
        
        # Remove o vértice inicial do caminho para corresponder ao formato esperado
        if len(caminho) > 1:
            return caminho[1:]
        return []
    
    def obter_distancia(self, destino):
        """Retorna a distância mínima para o destino"""
        return self.distancias.get(destino, float('inf'))
    
    def imprimir_caminhos_minimos(self, inicio):
        """Imprime todos os caminhos mínimos do vértice inicial"""
        self.executar(inicio)
        
        # Usa a ordem de entrada das cidades, excluindo a cidade origem
        ordem_entrada = self.grafo.obter_ordem_entrada()
        destinos_ordenados = [cidade for cidade in ordem_entrada if cidade != inicio]
        
        # Filtra apenas os destinos que existem no grafo
        todos_vertices = self.grafo.obter_vertices()
        destinos_validos = [d for d in destinos_ordenados if d in todos_vertices]
        
        for destino in destinos_validos:
            if self.distancias[destino] == float('inf'):
                print(f"{inicio} para {destino}")
                print("\tDistancia: Infinito (sem caminho)")
                print("\tCaminho: Não existe")
            else:
                caminho = self.construir_caminho(inicio, destino)
                print(f"{inicio} para {destino}")
                print(f"\tDistancia: {str(self.distancias[destino]).replace('.', ',')}")
                if caminho:
                    caminho_str = " --> ".join(caminho)
                    print(f"\tCaminho:  --> {caminho_str}")
                else:
                    print("\tCaminho:  --> (direto)")
    
    def imprimir_todos_caminhos_minimos(self):
        """Imprime caminhos mínimos para todos os vértices como origem"""
        # Usa a ordem de entrada das cidades
        vertices_ordenados = self.grafo.obter_ordem_entrada()
        
        for i, origem in enumerate(vertices_ordenados):
            self.imprimir_caminhos_minimos(origem)
            # Adiciona separador entre diferentes origens
            print("-" * 45)

def ler_grafo_da_entrada():
    grafo = Grafo()
    cidade_atual = None
    while True:
        try:
            linha = input().rstrip('\n')  # Mantém a indentação original
            if not linha.strip():  # Linha vazia encerra a entrada
                break
            
            # Verifica se a linha está indentada (conexão)
            if linha.startswith('\t') or linha.startswith(' '):
                # Remove toda a indentação (tabs ou espaços)
                linha_limpa = linha.lstrip()
                partes = linha_limpa.split()
                
                if len(partes) >= 2:
                    try:
                        distancia = float(partes[-1])
                        cidade_destino = ' '.join(partes[:-1])
                        if cidade_atual:
                            grafo.adicionar_aresta(cidade_atual, cidade_destino, distancia)
                    except ValueError:
                        pass
            else:  # Nova cidade origem
                cidade_atual = linha.strip()  # Remove espaços extras apenas aqui
                grafo.adicionar_cidade_origem(cidade_atual)
        except EOFError:
            break
    return grafo

def main():    
    grafo = ler_grafo_da_entrada()
    
    if not grafo.obter_vertices():
        return
    
    dijkstra = Dijkstra(grafo)
    
    dijkstra.imprimir_todos_caminhos_minimos()

if __name__ == "__main__":
    main()