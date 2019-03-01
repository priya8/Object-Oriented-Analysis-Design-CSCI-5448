
public class WoodworkTool extends Tools {
	
	private int price = 6;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	private String toolType = "woodwork";
	public WoodworkTool(String toolID) {
		super(toolID);
		// TODO Auto-generated constructor stub
	}

}
