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
		// TODO Auto-generated constructor stub

	}
	
   // Inventory invt = new Inventory();
	
	private ArrayList<Tools> rentedTools;
//	
//	public ArrayList<Tools> getRemainingTools() {
//		// TODO Auto-generated method stub
//		return invt.getTools();
//	}

	
	public ArrayList<Tools> RentTools(int allowedRentals, int requestedRentals) {
		
		//ArrayList<Tools> toolsList = new ArrayList<>();
		rentedTools = new ArrayList<>();
		
		
		if((toolsList.size() > requestedRentals)  && (toolsList.size() > allowedRentals))
			
		{
			
			//toolsList = getRemainingTools();
			//System.out.println(toolsList.size());
			//System.out.println(toolsList.size());
			Collections.shuffle(toolsList);

			for(int i = 0; i< requestedRentals; i++) 
			{
				rentedTools.add(toolsList.get(toolsList.size()-1));
				toolsList.remove(toolsList.size()-1);
				
				
				}
			
			//invt.setTools(toolsList);
			
			}
		//System.out.println(toolsList.size());
		
		
		return rentedTools;
	}
	
	public void AcceptTools(ArrayList<Tools> toolsList) {
		ArrayList<Tools> tl=this.toolsList;
		
		for(int i=0;i<toolsList.size();i++)
		{
			tl.add(toolsList.get(i));
		}
		invt.setTools(tl);
		
	}
	
	

	
}
