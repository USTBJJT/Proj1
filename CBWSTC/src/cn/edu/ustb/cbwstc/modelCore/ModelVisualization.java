package cn.edu.ustb.cbwstc.modelCore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.sourceforge.plantuml.SourceStringReader;
import cn.edu.ustb.cbwstc.model.Edge;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;

public class ModelVisualization {
	
	private String plantumlP = "";
	public void visualizationGen(String name,String source) {
		File file=new File("CBWSTC_WorkSpace/Projects/" + name + "/Graph/graphP.png");//可以是任何图片格式.jpg,.png等
		FileOutputStream png = null;
		try {
			png = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SourceStringReader reader = new SourceStringReader(source);
		// Write the first image to "png"
		try {
			reader.generateImage(png);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Return a null string if no generation
	}
	
	public void graphToPic(Graph g,int snode){
		ArrayList<Node> nodes = g.getNodes(); //节点集合
		ArrayList<Edge> edges = g.getEdges(); //边集合
		int cnode = snode;
		for(int i = 0;i <nodes.get(cnode).getAfterNodes().size();i++) {
			Node childNode = (Node) nodes.get(cnode).getAfterNodes().get(i);
			snode = childNode.getId();
			if(cnode == 0) {
				plantumlP = plantumlP + "[*]-->" + childNode.getName() + "\n";
			}else if(childNode.getType().equals("end")) {
				plantumlP = plantumlP + nodes.get(cnode).getName() + "-->" + "[*]\n";
			}else if(nodes.get(cnode).getType().equals("input")){
				plantumlP = plantumlP + nodes.get(cnode).getName() + "-->" + childNode.getName() + "\n";
				plantumlP = plantumlP + nodes.get(cnode).getCondition();
			}else {
				plantumlP = plantumlP + nodes.get(cnode).getName() + "-->" + childNode.getName() + "\n";
			}
			graphToPic(g,snode);
		}
	}
	
	public String getPlantumlP() {
		return plantumlP;
	}
	
//	public static void main(String[] args) {
//		ModelVisualization m = new ModelVisualization();
//		m.visualizationGen("ExpenseReimbursementSystem");
//	}

}
