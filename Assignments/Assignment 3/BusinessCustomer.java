import java.util.ArrayList;
import java.util.HashMap;

public class BusinessCustomer extends Customer {
	
	int allowedRentals = 3;
	int allowedDays = 7;

	public BusinessCustomer(String custId) {
		super(custId);
		// TODO Auto-generated constructor stub
	}
	
	private HashMap<Tools,Integer> trackRentals = new HashMap<>();
	
	
	public void getRentals(ArrayList<Tools> rentedTools, int day) {
		
		for(int i =0;i< rentedTools.size(); i++) {
			trackRentals.put(rentedTools.get(i), day + 7);
		}
		
	}
	
	public HashMap<Tools,Integer> getRentals() {
		return trackRentals;
	}
	
	public void setRentals(HashMap<Tools,Integer> trackRentals) {
		this.trackRentals=trackRentals;

	}

}
