import java.util.ArrayList;

public class ToolBox{

	public ToolBox() {
		
		// TODO Auto-generated constructor stub
	}
	
	private String[] toolId = {"Co1","Co2","Co3","Co4","Pa1","Pa2","Pa3","Pa4","Pl1","Pl2","Pl3","Pl4","W1","W2","W3","W4","Y1","Y2","Y3","Y4"};
	
	private ArrayList<Tools> tools = new ArrayList<Tools>();
	
	public ArrayList<Tools> createTools() {
		for(int i=0; i<4; i++) {
			tools.add(new ConcreteTool(toolId[i])); 
		}
		for(int i=4; i<8; i++) {
			tools.add(new PaintingTool(toolId[i]));
		}
		for(int i=8; i<12; i++) {
			tools.add(new PlumbingTool(toolId[i]));
		}
		for(int i=12; i<16; i++) {
			tools.add(new WoodworkTool(toolId[i]));
		}
		for(int i=16; i<20; i++) {
			tools.add(new YardworkTool(toolId[i]));
		}
		
		return tools;
		
	}

	public ArrayList<Tools> getTools() {
		return tools;
	}

	public void setTools(ArrayList<Tools> tools) {
		this.tools = tools;
	}

	

}
