# -*- coding: utf-8 -*-

#Libraries for defining Abstract Class and Abstract Methods
from abc import ABC, abstractmethod

#Abstract Class Shape with method definitions
class Shape(ABC):
    
    #Abstract Method for Area determination
    @abstractmethod
    def area(self):
        pass
    
    #Abstract Method for displaying the Shape type
    @abstractmethod
    def display(self):
        pass

#Circle Subclass inheriting Shape Class
class Circle(Shape):
    
    #Constructor for defining the private variable Radius
    def __init__(self,radius):
        self.radius = radius
     
    #Overriding the area() Method
    def area(self):
        return (3.14*self.radius*self.radius)
    
    #Overriding the display() Method
    def display(self):
        return "I am a Circle"
        
#Square Subclass inheriting Shape Class        
class Square(Shape):
    
    #Constructor for defining the private variable length
    def __init__(self,length):
        self.length = length
     
    #Overriding the area() Method
    def area(self):
        return (self.length*self.length)
    
    #Overriding the display() Method
    def display(self):
        return "I am a Square"

#Triangle Subclass inheriting the Shape Class        
class Triangle(Shape):
    
    #Constructor for defining the private variable Base and Height
    def __init__(self,base,height):
        self.base = base
        self.height = height
     
    #Overriding the area() Method
    def area(self):
        return (self.base*self.height)
    
    #Overriding the display() Method
    def display(self):
        return "I am a Triangle"
 
#Object Class for sorting list of Shape Objects
class Objects():
     
    #Constructor
    def __init__(self,shapeObject):
        self.shapeObjects = shapeObjects
    
    #Overiding the sort method provided by list to sort the shapes based on the area
    #Type of Shape is not known to the Objects Class    
    def sortShapes(self):
        self.shapeObjects.sort(key=lambda x: x.area())

    #Display the Shapes
    def displayShapes(self):
        for i in self.shapeObjects:
            print(i.display())
  
#Driver Method      
if __name__ == "__main__":
    
    #ShapeObjects list with different Shapes
    shapeObjects = [Circle(2),Triangle(3,4),Square(5)]
    
    print("\nNumber of shapes in the database: " + repr(len(shapeObjects)) + "\n")
    
    #Objects Class taking the ShapeObjects as parameter to sort them and display them
    obj = Objects(shapeObjects)
    obj.sortShapes()
    print("Displaying the shapes according to the sorted area\n")
    obj.displayShapes()
    