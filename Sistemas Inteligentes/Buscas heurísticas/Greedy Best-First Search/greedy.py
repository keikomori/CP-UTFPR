from vectorOrder import VectorOrder

class Greedy:
    def __init__(self, destiny):
        self. destiny = destiny
        self.find_city = False
        
    def search(self, actual):
        print('\nLocal atual: {}'. format(actual.name))
        actual.visited = True
        
        if actual ==self.destiny:
            self.find_city = True
        else:
            self.borderland = VectorOrder(len(actual.adjacents))
            for a in actual.adjacents:
                if a.city.visited == False:
                    a.city.visited = True
                    self.borderland.insert(a.city)
            
            self.borderland.show()
            if self.borderland.getFirst() != None:
                Greedy.search(self, self.borderland.getFirst())
                

from map import Map
map = Map()

gulosa = Greedy(map.rondon)

gulosa.search(map.centenarioDoSul)