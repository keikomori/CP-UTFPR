from stack import Stack

class Deep:
    def __init__(self, begin, destiny):
        self.begin = begin
        self.begin.visited = True
        self.destiny = destiny
        self.borderland = Stack(25)
        self.borderland.stack_up(begin)
        
    def search(self):
        top = self.borderland.getTop()
        print('Top: {}'.format(top.name))
        
        #percorre todos os adjacentes do topo e coloca na variável 'a'
        for a in top.adjacents:
            #lista qual cidade esta percorrendo
            print('Checking if it has already been visited: {}'.format(a.city.name))
            if a.city.visited == False:
                a.city.visited = True
                self.borderland.stack_up(a.city)
                Deep.search(self)
        #desempilha e já mostra a cidade desempilhada
        print('Unstacked: {}'.format(self.borderland.stack_up().name))
        
from map import Map
map = Map()
deep = Deep(map.centenarioDoSul, map.rondon)
deep.search()