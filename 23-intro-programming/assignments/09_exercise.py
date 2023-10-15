# Create 2 circles, 3 triangles and a square of different
#  sizes
# Add the shapes to a list
# 1. Find the total area of all the shapes
# 2. If we wanted to give each shape an x,y coordinate to
    #  position them in space how could we change the classes to achieve that

# Consider representing triangles with 3 side lengths
#  and using Heron's formula to calculate the area.
# - https://en.wikipedia.org/wiki/Heron%27s_formula


from math import pi

class Shape:
    def __init__(self,name):
        self.name = name

    def __str__(self):
        return f"I am a {self.name}"



class Circle(Shape):
    def __init__(self,radius):
        super().__init__("circle")
        self.radius = radius

    def area(self):
        return pi * self.radius * self.radius


class Triangle(Shape):
    def __init__(self,s1,s2,s3):
        super().__init__("triangle")
        self.s1 = s1
        self.s2 = s2
        self.s3 = s3

    def area(self):
        s = 0.5 * (self.s1 + self.s2 + self.s3)
        area = (s * (s-self.s1) * (s -self.s2) * (s-self.s3) )** 0.5
        return area


class Square(Shape):
    def __init__(self,length):    
        super().__init__("square")
        self.length = length

    def area(self):
        return self.length ** 2


if __name__ == "__main__":
    circle1 = Circle(3)
    circle2 = Circle(4)
    triangle1 = Triangle(2,3,4)
    triangle2 = Triangle(3,4,5)
    triangle3 = Triangle(4,5,6)
    square1 = Square(10)

    all_shapes = [circle1, circle2,triangle1, triangle2 , triangle3, square1]
    print (circle1)
    print(triangle2)
    print(square1)
# Why not printing out objects?
    print(all_shapes)

    total_area = 0
    for shape in all_shapes:
        total_area += shape.area()

    print(total_area)
