
public class PlumbingTool extends Tools {

	private int price = 4;
	private String toolType = "plumbing";
	public PlumbingTool(String toolID) {
		super(toolID);
		// TODO Auto-generated constructor stub
	}
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

}
