class Stack:
    def __init__(self, size):
        self.size = size
        self.cities = [None] * self.size
        self.top = -1
        
    def stack_up(self, city):
        if not Stack.stack_full(self):
            self.top += 1
            self.cities[self.top] = city
        else:
            print("Full stack!!")
        
    def stack_down(self):
        if not Stack.stack_empty(self):
            temp = self.cities[self.top]
            self.top -= 1
            return temp
        else:
            print("Empty stack!!")
            return None
        
    def getTop(self):
        return self.cities[self.top]
    
    def stack_empty(self):
        return (self.top == -1)
    
    def stack_full(self):
        return (self.top == self.size -1)
    
    
'''from map import Map

map = Map()
stack = Stack(5)

stack.stack_up(map.cruzeiroDoSul)
stack.stack_up(map.iguaracu)

stack.getTop().name

stack.stack_down()'''