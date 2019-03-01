import java.util.HashMap;

public class CustomerList {

	public CustomerList() {
		// TODO Auto-generated constructor stub
	}
	
	Customer C1 = new BusinessCustomer("B1");
	Customer C2 = new BusinessCustomer("B2");
	Customer C3 = new BusinessCustomer("B3");
	Customer C4 = new BusinessCustomer("B4");
	Customer C5 = new CasualCustomer("C1",1,2,1,2);
	Customer C6 = new CasualCustomer("C2",1,2,1,2);
	Customer C7 = new CasualCustomer("C3",1,2,1,2);
	Customer C8 = new RegularCustomer("R1",1,3,3,5);
	Customer C9 = new RegularCustomer("R2",1,3,3,5);
	Customer C10 = new RegularCustomer("R3",1,3,3,5);
	
	
	
	public HashMap<String, Customer> getCustomersList()
	{
		HashMap<String, Customer> hm=new HashMap<>();
		hm.put("B1",C1);
		hm.put("B2",C2);
		hm.put("B3",C3);
		hm.put("B4",C4);
		hm.put("C1",C5);
		hm.put("C2",C6);
		hm.put("C3",C7);
		hm.put("R1",C8);
		hm.put("R2",C9);
		hm.put("R3",C10);
	
		return hm;
		
	}
	
	

}
