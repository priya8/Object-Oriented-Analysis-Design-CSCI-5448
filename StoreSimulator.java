import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class StoreSimulator {
	
	// This function returns price of a tool 
	public static int getPrice(String toolID) {
		int price = 0;
		
		char c = toolID.charAt(0);
		
		switch(c) {
		
		case 'C':
			ConcreteTool bc = new ConcreteTool(toolID);
			price = bc.getPrice();
			break;
		
		case 'P':
			PlumbingTool pt = new PlumbingTool(toolID);
			price = pt.getPrice();
			break;
		
		case 'W':
			WoodworkTool wt = new WoodworkTool(toolID);
			price = wt.getPrice();
			break;
		
		case 'Y':
			YardworkTool yt = new YardworkTool(toolID);
			price = yt.getPrice();
			break;
		
		}
		
		return price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Assuming that there could be 0 customers on some days, all the random values generated may not give valid customers
		
		CustomerList cl=new CustomerList();
		HashMap<String, Customer> hm= cl.getCustomersList();
		
		List<Object> activeList=new ArrayList<>();
		List<Object> completedList=new ArrayList<>();
		
		
		Inventory invt = new Inventory();
		invt.create();
	
		
		// Rentals on DAY1
		
		int day = 1;
		int totalPrice=0;
		
		Random rand = new Random();
		int noOfCustomers=rand.nextInt(9)+1;
		int noOfNights = 0;
		int dayOfReturn=0;
		
		
		//Generates customers randomly and validates those customers based on number of tools  present in the inventory and the max number of days he can rent the tool.
		GenerateCustomers cust=new GenerateCustomers(invt);
		
		
		Rental rent=new Rental(invt);
		
		
		for(int i=0;i<noOfCustomers;i++)
		{
	
			String cID=cust.generateCustID();
			ArrayList<Tools> toolList=invt.getTools();
			
			boolean valid=cust.validCustomer(cID, hm,day);
			
			
			if(valid)
			{
				
				switch(cID.charAt(0)) {
				
				
				case 'B': 
					BusinessCustomer custB= (BusinessCustomer) hm.get(cID);
					noOfNights=7;
					dayOfReturn=day+noOfNights;
					
					toolList=rent.RentTools(3, 3);
					invt.setTools(toolList);
					for(int j=0;j<toolList.size();j++)
					{
						custB.getRentals().put(toolList.get(j), dayOfReturn);
						ArrayList<Object> al=new ArrayList<>();
						al.add(toolList.get(j).getToolID());
						al.add(cID);
						al.add(noOfNights);
						al.add(getPrice(toolList.get(j).getToolID()));
						totalPrice+=getPrice(toolList.get(j).getToolID());
						
						activeList.add(al);
					}
					
					break;
					
					
				case 'R': 
					RegularCustomer custR= (RegularCustomer) hm.get(cID);
					noOfNights=custR.generateNights();
					dayOfReturn=day+noOfNights;
					
					int requestedTools=custR.generateTools();
					toolList=rent.RentTools(3,requestedTools);
					custR.maxAllowedTools -=requestedTools;
					
					for(int j=0;j<toolList.size();j++)
					{
						custR.getRentals().put(toolList.get(j), dayOfReturn);
						ArrayList<Object> al=new ArrayList<>();
						al.add(toolList.get(j).getToolID());
						al.add(cID);
						al.add(noOfNights);
						al.add(getPrice(toolList.get(j).getToolID()));
						totalPrice+=getPrice(toolList.get(j).getToolID());
						
						activeList.add(al);
					}
					break;
					
					
				case 'C':
					CasualCustomer custC= (CasualCustomer) hm.get(cID);
					noOfNights=custC.generateNights();
					dayOfReturn=day+noOfNights;
					int requestedTools1=custC.generateTools();
					toolList=rent.RentTools(3, requestedTools1);
					for(int j=0;j<toolList.size();j++)
					{
						custC.getRentals().put(toolList.get(j), dayOfReturn);
						ArrayList<Object> al=new ArrayList<>();
						al.add(toolList.get(j).getToolID());
						al.add(cID);
						al.add(noOfNights);
						al.add(getPrice(toolList.get(j).getToolID()));
						totalPrice+=getPrice(toolList.get(j).getToolID());
						
						activeList.add(al);
					}
					break;
					
				default:
					break;
			}
		}
				
		
		}
		
		day++;
		
		//Accepting Return of Rentals and also giving rentals from DAY 2
		
		while(day<=3)
		{
			
			Set<String> keyList=hm.keySet();
			
			//Returning Rentals 
			for(String cID: keyList)
			{
				//System.out.println(cID);
				
				switch(cID.charAt(0)) 
				{
				
				case 'B': 
					
					BusinessCustomer custB=(BusinessCustomer) hm.get(cID);
					
					HashMap<Tools, Integer> bCust=custB.getRentals();
					for(Tools key: bCust.keySet())
					{
						dayOfReturn=bCust.get(key);
						break;
					}
	
					
					ArrayList<Tools> toolsList1=new ArrayList<>();
					for(Tools key: bCust.keySet())
					{
						toolsList1.add(key);
					}
					
					if(dayOfReturn==day)
					{
						rent.AcceptTools(toolsList1);
						custB.maxAllowedTools += bCust.size();
						
						for(int j=0; j<toolsList1.size(); j++){
							
							Tools tool = toolsList1.get(j);
							for(int i=0; i<activeList.size(); i++) {
								
								String toolID = activeList.get(i).toString().substring(1, 3);
								if(toolID.equals(tool.getToolID())) {
									completedList.add(activeList.get(i));
									activeList.remove(i);
								}
						
							}
						
						}
						
						bCust.clear();
						custB.setRentals(bCust);
				
						}
						
		    
						
						
					break;
					
					
				case 'R': 
					RegularCustomer custR= (RegularCustomer) hm.get(cID);
					HashMap<Tools, Integer> rCust=custR.getRentals();
					for(Tools key: rCust.keySet())
					{
						dayOfReturn=rCust.get(key);
						break;
					}
					
					ArrayList<Tools> toolsList2=new ArrayList<>();
					for(Tools key: rCust.keySet())
					{
						toolsList2.add(key);
					}
					
					if(dayOfReturn==day)
					{
						rent.AcceptTools(toolsList2);
						custR.maxAllowedTools += rCust.size();
						
						for(int j=0; j<toolsList2.size(); j++){
							
							Tools tool = toolsList2.get(j);
							
							for(int i=0; i<activeList.size(); i++) {
								
								String toolID = activeList.get(i).toString().substring(1, 3);
								if(toolID.equals(tool.getToolID())){
									completedList.add(activeList.get(i));
									activeList.remove(i);
								}
						
							}
						
						}
						
						rCust.clear();
						custR.setRentals(rCust);
				
						}
						
					break;
					
					
				case 'C':
					CasualCustomer custC= (CasualCustomer) hm.get(cID);
					HashMap<Tools, Integer> cCust=custC.getRentals();
					for(Tools key: cCust.keySet())
					{
						dayOfReturn=cCust.get(key);
						break;
					}
					
					ArrayList<Tools> toolsList3=new ArrayList<>();
					for(Tools key: cCust.keySet())
					{
						toolsList3.add(key);
					}
					
					if(dayOfReturn==day)
					{
						rent.AcceptTools(toolsList3);
						custC.maxAllowedTools += cCust.size();
						
						for(int j=0; j<toolsList3.size(); j++){
							
							Tools tool = toolsList3.get(j);
							for(int i=0; i<activeList.size(); i++) {
								
								String toolID = activeList.get(i).toString().substring(1, 3);
								if(toolID.equals(tool.getToolID())) {
									completedList.add(activeList.get(i));
									activeList.remove(i);
								}
						
							}
						
						}
						
						cCust.clear();
						custC.setRentals(cCust);
				
						}
					
					break;
				default:
					break;
			}
			}

			//Renting Tools
			noOfCustomers=rand.nextInt(9)+1;
			for(int i=0;i<noOfCustomers;i++)
			{
				//Rental rent=new Rental(invt);
				String cID=cust.generateCustID();
				ArrayList<Tools> toolList=null;
				
				boolean valid=cust.validCustomer(cID, hm,day);
				if(valid)
				{
					switch(cID.charAt(0)) {
					
					case 'B': 
						BusinessCustomer custB= (BusinessCustomer) hm.get(cID);
						noOfNights=7;
						dayOfReturn=day+noOfNights;
						toolList=rent.RentTools(3, 3);
						for(int j=0;j<toolList.size();j++)
						{
							custB.getRentals().put(toolList.get(j), dayOfReturn);
							ArrayList<Object> al=new ArrayList<>();
							al.add(toolList.get(j).getToolID());
							al.add(cID);
							al.add(noOfNights);
							al.add(getPrice(toolList.get(j).getToolID()));
							totalPrice+=getPrice(toolList.get(j).getToolID());
							activeList.add(al);
							
						}
						
						break;
						
						
					case 'R': 
						RegularCustomer custR= (RegularCustomer) hm.get(cID);
						noOfNights=custR.generateNights();
						dayOfReturn=day+noOfNights;
						
						int requestedTools=custR.generateTools();
						toolList=rent.RentTools(3,requestedTools);
						custR.maxAllowedTools-=requestedTools;
						
						for(int j=0;j<toolList.size();j++)
						{
							custR.getRentals().put(toolList.get(j), dayOfReturn);
							ArrayList<Object> al=new ArrayList<>();
							al.add(toolList.get(j).getToolID());
							al.add(cID);
							al.add(noOfNights);
							al.add(getPrice(toolList.get(j).getToolID()));
							totalPrice+=getPrice(toolList.get(j).getToolID());
							activeList.add(al);
						}
						break;
						
						
					case 'C':
						CasualCustomer custC= (CasualCustomer) hm.get(cID);
						noOfNights=custC.generateNights();
						dayOfReturn=day+noOfNights;
						
						int requestedTools1=custC.generateTools();
						
						toolList=rent.RentTools(3, requestedTools1);
						for(int j=0;j<toolList.size();j++)
						{
							custC.getRentals().put(toolList.get(j), dayOfReturn);
							ArrayList<Object> al=new ArrayList<>();
							al.add(toolList.get(j).getToolID());
							al.add(cID);
							al.add(noOfNights);
							al.add(getPrice(toolList.get(j).getToolID()));
							totalPrice+=getPrice(toolList.get(j).getToolID());
							activeList.add(al);
						}
						break;
						
					default:
						break;
				}
			}
					
			
			}
			
			day++;
		}
		ArrayList<Tools> tools=invt.getTools();
		int noOfTools=tools.size();
		System.out.println("Number of Tools at the end of 35 days: "+ noOfTools+"\n");
		System.out.println("Active Rentals List: Types of elements per list ares given below"+"\n");
		System.out.println("ToolID - "+"CustomerID - "+"Number of nights rented - "+"Price of the rental"+"\n");
		System.out.println(activeList+"\n");
		System.out.println("Completed Rentals List: Active Rentals List: Types of elements per list are given below"+"\n");
		System.out.println("ToolID - "+"CustomerID - "+"Number of nights rented - "+"Price of the rental"+"\n");
		System.out.println(completedList+"\n");
		System.out.println("Total amount by the store at the end of 35 days: "+totalPrice+"\n");
	}
}


