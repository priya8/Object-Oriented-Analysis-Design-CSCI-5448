import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CasualCustomer extends Customer implements RandomizedInterface {
	
	HashMap<Tools,Integer> trackRentals = new HashMap<>();
	private Random rand = new Random();
	

	public CasualCustomer(String custId, int minAllowedTools, int maxAllowedTools, int minNights, int maxNights) {
		// TODO Auto-generated constructor stub
		super(custId, minAllowedTools, maxAllowedTools, minNights, maxNights);
	}
	

	public int generateNights() {
		return rand.nextInt(this.maxNights-this.minNights)+this.minNights;
	}
	
	public int generateTools() {
		if(this.maxAllowedTools==this.minAllowedTools)
		{
		return rand.nextInt(this.maxAllowedTools-this.minAllowedTools+1)+(this.minAllowedTools-1);
		}
		return rand.nextInt(this.maxAllowedTools-this.minAllowedTools)+(this.minAllowedTools);
	}
	
	
	public void getRentals(ArrayList<Tools> rentedTools, int day) {
		
		for(int i =0;i< rentedTools.size(); i++) {
			trackRentals.put(rentedTools.get(i), day + this.generateNights());
		}	
		
	}
	
	public HashMap<Tools,Integer> getRentals() {
		return trackRentals;
	}
	
	public void setRentals(HashMap<Tools,Integer> trackRentals) {
		this.trackRentals=trackRentals;

	}

}
