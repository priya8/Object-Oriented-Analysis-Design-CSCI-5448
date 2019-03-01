
public class YardworkTool extends Tools {

	private int price = 2;
	private String toolType = "yardwork";
	public YardworkTool(String toolID) {
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
