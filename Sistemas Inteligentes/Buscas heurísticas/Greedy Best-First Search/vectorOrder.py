#implementação do vetor ordenado - busca a posição e depois insere o valor

class VectorOrder:
    def __init__(self, size):
        self.numElements = 0
        self.cities = [None] * size

    def insert(self, city):

        if self.numElements == 0:
            self.cities[0] = city
            self.numElements = 1
            return

        position = 0
        i = 0

        while i < self.numElements:
            if city.distanceDestiny > self.cities[position].distanceDestiny:
                position += 1

            i += 1

        for k in range(self.numElements, position, -1):
            self.cities[k] = self.cities[k - 1]

        self.cities[position] = city
        self.numElements += 1

    def getFirst(self):
        return self.cities[0]

    def show(self):
        for i in range(0, self.numElements):
            print('{} - {}'.format(self.cities[i].name, self.cities[i].distanceDestiny))
        
