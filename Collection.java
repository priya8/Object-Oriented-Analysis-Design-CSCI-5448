package ooad_hw1_q4;

import java.util.Arrays;

public class Collection {
		
	Shape[] shape;

	//Constructor
	Collection(Shape[] objs)
	{
		this.shape =objs;
	}
	
    //Method to sort the shapes
	public Shape[] sortShapes()
	{
			
		Arrays.sort(shape);
		return shape;
		
	}
	
	//Method to display the shapes
	public void display()
	{
		for(int i=0; i<shape.length; i++) {
			shape[i].display();
		}
	}
	
}
