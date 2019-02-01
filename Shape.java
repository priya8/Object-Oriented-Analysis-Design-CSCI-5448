package ooad_hw1_q4;

public abstract class Shape implements Comparable<Shape> {

	//Abstract methods which is to be implemented in sub classes
	abstract double area();
	abstract void display();
	
	//Override the compareTo method to compare shapes based on area()
	public int compareTo(Shape s) {
		 return (int)(this.area() - s.area());
	}
	
	
}

//Subclass Circle extends from the abstract Shape class
class Circle extends Shape
{
	private double radius;
	
	//Constructor
	Circle(float radius)
	{
		this.radius=radius;
	}

	//Overriding the base class (Shape) Display method
	@Override
	void display() {
		System.out.println("I am Circle");
	}

	//Overriding the base class (Shape) Area method and calculate the area of Circle
	@Override
	double area() {
		return 3.14*radius*radius;
	}
}

//Subclass Triangle extends from the abstract Shape class
class Triangle extends Shape
{
	double base,height;

	//Constructor
	Triangle(double base,double height)
	{
		
		this.base=base;
		this.height=height;
		
	}

	//Overriding the base class (Shape) Display method
	@Override
	void display() {
		System.out.println("I am Triangle");
		
	}
	
	//Overriding the base class (Shape) Area method and calculate the area of Triangle
	@Override
	double area() {
		return 0.5*base*height;
	}
	
}

//Subclass Square extends from the abstract Shape class
class Square extends Shape
{
	
	double side;
	
	//Constructor
	Square(double side)
	{
		this.side=side;
	}
	
	//Overriding the base class (Shape) Display method
	@Override
	void display() {
		System.out.println("I am Square");
	}
	
	//Overriding the base class (Shape) Area method and calculate the area of Square
	@Override
	double area() {
		return side*side;
	}
	
}