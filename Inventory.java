import java.util.ArrayList;

public class Inventory {

	public Inventory() {
		// TODO Auto-generated constructor stub
		
	}
	
	private ArrayList<Tools> tools;

	
	public void create()
	{
		ToolBox tb = new ToolBox();
		this.tools=tb.createTools();
	}
	
//	ArrayList<Tools> tools = tb.createTools();
	
	
	public void setTools(ArrayList<Tools> tools) {
		this.tools = tools;
	}
	//This class keeps track of tools in the inventory
	public ArrayList<Tools> getTools() {
		return this.tools;
	}
	

	
	
}
