from vectororderadjacent import VectorOrderAdjcent
import time
begin_time = time.time()

class AStar:
    def __init__(self, destiny):
        self.destiny = destiny
        self.find_city = False
        
    def search(self, actual):
        
        print('\nAtual: {}'.format(actual.name))
        actual.visited = True
        
        if actual == self.destiny:
            self.find_city = True
        else:
            self.borderland = VectorOrderAdjcent(len(actual.adjacents))
            for a in actual.adjacents:
                if a.city.visited == False:
                    a.city.visited = True
                    self.borderland.insert(a)
            self.borderland.show()
            if self.borderland.getFirst() != None:
                AStar.search(self, self.borderland.getFirst())
                

from map import Map
map = Map()

astar = AStar(map.rondon)

astar.search(map.centenarioDoSul)