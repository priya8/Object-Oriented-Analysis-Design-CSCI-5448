import java.util.ArrayList;
import java.util.Collections;

public class Rental{
	
	// Assuming customer knows how many maximum number of tools he can rent 
	
	// Assuming customer asks for n tools then store will return n tools of any type

	
	private ArrayList<Tools> toolsList;
	private Inventory invt;
	
	public Rental(Inventory invt) {
		this.toolsList=invt.getTools();
		this.invt=invt;
		

	}
	
   
	private ArrayList<Tools> rentedTools;


	//This function returns the tools requested by the customer
	public ArrayList<Tools> RentTools(int allowedRentals, int requestedRentals) {
		
		
		rentedTools = new ArrayList<>();
		
		
		if((toolsList.size() > requestedRentals)  && (toolsList.size() > allowedRentals))
			
		{
			
			
			Collections.shuffle(toolsList);

			for(int i = 0; i< requestedRentals; i++) 
			{
				rentedTools.add(toolsList.get(toolsList.size()-1));
				toolsList.remove(toolsList.size()-1);
				
				
				}
			
			
			}
		
		return rentedTools;
	}
	
	//This function updates the tools in the inventory whenever customer returns tools to the store.
	public void AcceptTools(ArrayList<Tools> toolsList) {
		ArrayList<Tools> tl=this.toolsList;
		
		for(int i=0;i<toolsList.size();i++)
		{
			tl.add(toolsList.get(i));
		}
		invt.setTools(tl);
		
	}
	
	

	
}
