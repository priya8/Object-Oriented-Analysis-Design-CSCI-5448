package ooad_hw1_q4;

public class ShapeMain {

	
	public static void main(String[] args) {
		
		// Creating list of shape objects
		//Creating instances of Circle, Triangle and Square
		Shape[] shape = {new Circle(2), new Triangle(3,4), new Square(5)}; 
		
		System.out.println("Number of shapes in the database: "+ shape.length);
		
		//Creating instance of Collection class and calling corresponding methods
		Collection obj = new Collection(shape);
		
		obj.sortShapes();
		
		obj.display();
		
	}

}
