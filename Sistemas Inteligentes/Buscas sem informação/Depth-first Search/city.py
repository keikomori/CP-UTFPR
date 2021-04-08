class City:
    def __init__(self, name):
        self.name = name
        self.visited = False
        self.adjacents= []
        
    def addCityAdjacent(self, city):
        self.adjacents.append(city)

c = City("test")
c.name
c.visited
c.adjacents