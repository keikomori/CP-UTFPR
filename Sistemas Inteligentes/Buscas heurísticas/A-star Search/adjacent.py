class Adjacent:
    def __init__(self, city, distance):
        self.city = city
        self.distance = distance
        self.distanceA_star = self.city.distanceDestiny + self.distance
