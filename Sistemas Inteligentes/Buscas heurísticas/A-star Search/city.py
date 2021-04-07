class City:
    def __init__(self, name, distanceDestiny):
        self.name = name
        self.visited = False
        self.distanceDestiny = distanceDestiny
        self.adjacents= []

    def addCityAdjacent(self, city):
        self.adjacents.append(city)
