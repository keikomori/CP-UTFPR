class VectorOrderAdjcent:
    def __init__(self, size):
        self.numElements = 0
        self.adjacents = [None] * size
        
    def insert(self, adjacent):
        
        if self.numElements == 0:
            self.adjacents[0] = adjacent
            self.numElements = 1
            return
        
        position = 0
        i = 0
        
        while i < self.numElements:
            if adjacent.distanceA_star > self.adjacents[position].distanceA_star:
                position += 1
                
            i += 1
        
        for k in range(self.numElements, position, -1):
            self.adjacents[k] = self.adjacents[k - 1]
        
        self.adjacents[position] = adjacent
        self.numElements += 1
    
    def getFirst(self):
        return self.adjacents[0].city
    
    def show(self):
        for i in range(0, self.numElements):
            print('{} - {}'.format(self.adjacents[i].city.name, self.adjacents[i].distanceA_star))