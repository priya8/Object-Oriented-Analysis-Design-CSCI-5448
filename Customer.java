import java.util.ArrayList;


public class Customer {
	
	public String custId;
	public int minAllowedTools;
	public int maxAllowedTools;
	public int minNights;
	public int maxNights;
	
	
	public Customer(String custId){
		this.custId = custId;
		
	}

	public Customer(String custId,int minAllowedTools, int maxAllowedTools, int minNights, int maxNights){
		// TODO Auto-generated constructor stub
		
		this.custId = custId;
		this.minAllowedTools = minAllowedTools;
		this.maxAllowedTools = maxAllowedTools;
		this.minNights = minNights;
		this.maxNights = maxNights;
		
	}

	
	
	
}
