class List:
    def __init__(self, size):
        self.size = size
        self.cities = [None] * self.size
        self.begin = 0
        self.destiny = -1
        self.numElements = 0
        
    def queue_list(self, city):
        if not List.queue_full(self):
            if self.destiny == self.size -1:
                #se entrar aqui já estourou a posição
                self.destiny = -1
            self.destiny += 1
            self.cities[self.destiny] = city
            self.numElements += 1
        else:
            print("Full queue!!")
    
    def dequeue_list(self):
        if not List.queue_empty(self):
            temp = self.cities[self.begin]
            self.begin += 1
            if self.begin == self.size:
                #se chega no final da fila é atribuido o valor zero
                self.begin = 0
            self.numElements -= 1
            return temp
        else:
            print("Empty queue!!")
            return None
    
    def getFirst(self):
        return self.cities[self.begin]
    
    def queue_empty(self):
        return self.numElements == 0
    
    def queue_full(self):
        return self.numElements == self.size
    
'''
from map import Map
map = Map()
queue = List(5)

queue.queue(map.rondon)
queue.queue(map.novaLondrina)

queue.getFirst().name
queue.dequeue()'''

