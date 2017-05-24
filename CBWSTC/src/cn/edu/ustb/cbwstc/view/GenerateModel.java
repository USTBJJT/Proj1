package cn.edu.ustb.cbwstc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import cn.edu.ustb.cbwstc.modelCore.Converter;
import cn.edu.ustb.cbwstc.tcg.XmlInputFormat;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class GenerateModel extends JPanel {
	
	private String url;
	private Map<String, XmlInputFormat> map = new HashMap<String, XmlInputFormat>();
	
	private JTabbedPane tabbedPane;
	private JPanel panelBM;
	private JScrollPane scrollPanePic;
	private JPanel panelPic;
	/**
	 * Create the panel.
	 */
	public GenerateModel(String WsdlUrl, Map<String, XmlInputFormat> map,JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		url = WsdlUrl;
		this.map = map;
		initComponents();
	}
	
	private void initComponents() {
		setLayout(null);
		
		/**
		 * panelBM布局设置
		 */
		panelBM = new JPanel();
		panelBM.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Behavior Model", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelBM.setBounds(10, 10, 568, 439);
		add(panelBM);
		panelBM.setLayout(null);
		
		String name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
		Converter c = new Converter(map);//生成模型
		c.convert(name, true);
		
		String picName = "CBWSTC_WorkSpace/Projects/" + name + "/Graph/graphP.png";
		ImageIcon icon = new ImageIcon(picName);
		Image image1 = icon.getImage();
		panelPic = new JPanel(){  
		    @Override  
		    public void paint(Graphics g) {  
		        super.paint(g); 
		        
				if(image1 != null){  
		            g.clearRect(0, 0, this.getWidth(), this.getHeight());  
		            g.drawImage(image1, 0, 0, null);  
		            g.dispose();  
		        }  
		    }  
		};
		panelPic.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));  
		panelPic.updateUI();
		scrollPanePic = new JScrollPane();
		scrollPanePic.setBounds(10, 20, 550, 410);
		scrollPanePic.setViewportView(panelPic);
		panelBM.add(scrollPanePic);
	}
}
