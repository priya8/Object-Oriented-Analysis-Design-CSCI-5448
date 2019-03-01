import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GenerateCustomers{
	private ArrayList<Tools> tools;
	private Inventory invt;
	
	public GenerateCustomers(Inventory invt)
	{
		this.tools=invt.getTools();
		this.invt=invt;
	}

	private String[] custID= {"B1","B2","B3","B4","R1","R2","R3","C1","C2","C3"};
	

	//private ArrayList<Tools> tools = RentalHelper.getRemainingTools();
	//Inventory invt=new Inventory();
	
	
	
		
	private Random rand = new Random();
	
	// 1-B, 2-R, 3-C
	private String generateCustType() {
		//List<Integer> id = Arrays.asList(1,2,3);
		Integer randEl = rand.nextInt(3)+1;
		
		
		String type = "";
		
		if(randEl == 1) {
			type = "B";
		}
		
		else if(randEl == 2) {
			type = "R";
		}
		
		else if(randEl==3) {
			type = "C";
		}
		
		return type;
	}
	
	public String generateCustID() {
		
		String cID=null;
		//System.out.println(tools.size());
		if(tools.size()>=3) {
			
			String type = generateCustType();
			
			switch(type) {
				
				case "B": 
					//List<Integer> id1 = Arrays.asList(1,2,3,4);
					Integer randEl1 = rand.nextInt(4)+1;
					cID = type + randEl1.toString();
					break;
					
				case "R": 
					//List<Integer> id2 = Arrays.asList(1,2,3);
					Integer randEl2 = rand.nextInt(3)+1;
					cID = type + randEl2.toString();
					break;
					
				case "C":
					//List<Integer> id3 = Arrays.asList(1,2,3);
					Integer randEl3 = rand.nextInt(3)+1;
					cID = type + randEl3.toString();
					break;
					
				default:
					break;
			}
		}
			else if(tools.size()>=2 && tools.size()<3) {
			
			String type = generateCustType();
			
			switch(type) {
			
				case "R": 
					//List<Integer> id2 = Arrays.asList(1,2,3);
					Integer randEl2 = rand.nextInt(3)+1;
					cID = type + randEl2.toString();
					break;
					
				case "C":
//					List<Integer> id3 = Arrays.asList(1,2,3);
					Integer randEl3 = rand.nextInt(3)+1;
					cID = type + randEl3.toString();
					break;
					
				default:
					break;
			}
			
		}
			
		else if(tools.size()==1) {
			
			String type = generateCustType();
			
			switch(type) {
			
					
				case "C":
//					List<Integer> id3 = Arrays.asList(1,2,3);
					Integer randEl3 = rand.nextInt(3)+1;
					cID = type + randEl3.toString();
					break;
					
				default:
					break;
			}
			
		}
		else
			return generateCustID();
		
		
		if(cID==null)
		{
			return generateCustID();
		}
		return cID;
	}
	
	public boolean validCustomer(String cID,HashMap<String, Customer> hm, int day) {
		int noOfTools=0;
		int dayOfReturn=0;
		//System.out.println(cID);
		switch(cID.charAt(0)) {
		
		case 'B': 
			BusinessCustomer custB=(BusinessCustomer) hm.get(cID);
			
			HashMap<Tools, Integer> bCust=custB.getRentals();
			
			noOfTools= bCust.size();
			if(noOfTools!=0)
			{
			if(noOfTools==3)
				return false;
			else
				return true;
			}
			break;
			
		case 'R': 
			//System.out.println("Hello");
			RegularCustomer custR=  (RegularCustomer) hm.get(cID);
			HashMap<Tools, Integer> rCust=custR.getRentals();
			noOfTools= rCust.size();
			
			if(noOfTools!=0)
			{
			dayOfReturn=rCust.get(rCust.keySet().toArray()[0]);
			if(dayOfReturn-day>=3 && dayOfReturn-day<=5 && noOfTools<3)
				return true;

			else
				return false;
			}
			break;
			
		case 'C':
			//System.out.println("Hi");
			CasualCustomer custC= (CasualCustomer) hm.get(cID);
			HashMap<Tools, Integer> cCust=custC.getRentals();
			noOfTools=cCust.size();
			
			if(noOfTools!=0)
			{
			dayOfReturn=cCust.get(cCust.keySet().toArray()[0]);
			if(dayOfReturn-day>=1 && dayOfReturn-day<=2 && noOfTools<2)
				return true;

			else
				return false;
			}
			break;
		default:
			break;
	}
		return true;
	}
	
	
	
	
}
