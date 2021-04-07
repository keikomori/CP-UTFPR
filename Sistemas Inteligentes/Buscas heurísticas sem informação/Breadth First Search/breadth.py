from list import List

class Breadth:
    def __init__(self, begin, destiny):
        self.begin = begin
        self.begin.visited = True
        self.destiny = destiny
        self.borderland = List(25)
        self.borderland.queue_list(begin)
        self.find_city = False
        
    def search(self):
        first = self.borderland.getFirst()
        print('First: {}'.format(first.name))
        if first == self.destiny:
            find_city = True
        else:
            temp = self.borderland.dequeue_list()
            print('Dequeue: {}'.format(temp.name))
            
            for a in first.adjacents:
                print('Checking if it has already been visited: {}'.format(a.city.name))
                if a.city.visited == False:
                    a.city.visited = True
                    self.borderland.queue_list(a.city)
                
            if self.borderland.numElements > 0:
                Breadth.search(self)
        

from map import Map
map = Map()

breadth = Breadth(map.rondon, map.uniflor)
breadth.search()