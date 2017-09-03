package cn.edu.ustb.cbwstc.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.JButton;

import cn.edu.ustb.cbwstc.decisionTables.ParseDT;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.model.Node;
import cn.edu.ustb.cbwstc.modelCore.Converter;
import cn.edu.ustb.cbwstc.tcg.XmlInputFormat;
import cn.edu.ustb.cbwstc.wsdl.parser.GetXsd;
import cn.edu.ustb.cbwstc.wsdl.parser.ParseSequence;
import cn.edu.ustb.cbwstc.wsdl.parser.ReadWsdl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTextField;

public class ParsePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private Map<String,String> mapC = new HashMap<String,String>();
	private Map<String,String> mapIO = new HashMap<String,String>();
	private Map<String,String> mapSq = new HashMap<String,String>();
	private Map<String, XmlInputFormat> map = new HashMap<String, XmlInputFormat>();//服务操作的输入参数解析结果
	private Graph g = new Graph();
	private JPanel parsePanel;
	private JPanel panelResult;
	private JPanel ConSetPanel;
	private JPanel panelSequence;
	
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneResult;
	
	private JTextArea textAreaURL;
	private JTextArea textAreaResult;
	private JTextArea textAreapreOp;
	private JTextArea textAreaSquence;
	private JButton btnParseButton;
	private JButton btnGModelButton;
	private JButton btnAddButton;
	private JComboBox<String> comboBoxOp;
	private JComboBox comboBoxFrom;
	private JComboBox comboBoxTo;
	private JLabel lblOpLabel;
	private JLabel lblpreOPLabel;
	private JLabel lblSqLabel;
	private JScrollPane scrollPaneOp;
	private JLabel label_1;
	private JLabel label_2;
	
	
	

	/**
	 * Create the panel.
	 */
	public ParsePanel(String WsdlUrl,JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		url = WsdlUrl;
		initComponents();
	}
	
	private void initComponents() {
		
		setLayout(null);
		
		/**
		 * parsePanel设置
		 */
		parsePanel = new JPanel();
		parsePanel.setBounds(10, 10, 515, 90);
		parsePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Parse WSDL", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		add(parsePanel);
		parsePanel.setLayout(null);
		
		textAreaURL = new JTextArea();
		textAreaURL.setBackground(SystemColor.control);
		textAreaURL.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textAreaURL.setBounds(25, 20, 480, 35);
		parsePanel.add(textAreaURL);
		textAreaURL.setLineWrap(true);
		textAreaURL.setWrapStyleWord(true);
		textAreaURL.append("Parse the WSDL you have choose, obtain the operations and associated constraints provided by the Web Service.");
		
		btnParseButton = new JButton("Parse");
		btnParseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parseButtonAction();
			}
		});
		btnParseButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnParseButton.setBounds(435, 55, 70, 25);
		parsePanel.add(btnParseButton);
		
		/**
		 * panelResult设置
		 */
		panelResult = new JPanel();
		panelResult.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelResult.setBounds(535, 10, 365, 427);
		add(panelResult);
		panelResult.setLayout(null);
		
		textAreaResult = new JTextArea();
		textAreaResult.setBackground(SystemColor.control);
		textAreaResult.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPaneResult = new JScrollPane(textAreaResult);
		scrollPaneResult.setBounds(10, 23, 345, 394);
		scrollPaneResult.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneResult.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelResult.add(scrollPaneResult);
		
		/**
		 * ConSetPanel设置
		 */
		ConSetPanel = new JPanel();
//		8/20注释掉的      ConSetPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Constraint Set", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		ConSetPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Model Set", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		ConSetPanel.setBounds(10, 100, 515, 337);
		add(ConSetPanel);
		ConSetPanel.setLayout(null);
		
		lblOpLabel = new JLabel("Operation: ");
		lblOpLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblOpLabel.setBounds(30, 30, 80, 15);
		ConSetPanel.add(lblOpLabel);
		
		comboBoxOp = new JComboBox<String>();
		comboBoxOp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Node node = g.getNode(comboBoxOp.getSelectedItem().toString());
				textAreapreOp.setText(node.getPreOpC());
				textAreapreOp.paintImmediately(textAreapreOp.getBounds());
//				String str = mapC.get(comboBoxOp.getSelectedItem().toString());
//				textAreapreOp.setText(str);
//				if(str != null && str.length() != 0) {
//					if(str.trim().equals("null")){
//						textAreaSquence = new JTextArea();
//						textAreaSquence.setBackground(SystemColor.control);
//						textAreaSquence.setFont(new Font("微软雅黑", Font.PLAIN, 12));
//						textAreaSquence.setBounds(70, 95, 395, 100);
//						textAreaSquence.setLineWrap(true);
//						textAreaSquence.setWrapStyleWord(true);
//						panelSequence.add(textAreaSquence);
//						textAreaSquence.append("This operation has no sequence constraint and adds the relevant sequence by clicking the \" Add Sequence \" button directly");
//					}
//				}
			}
		});
		comboBoxOp.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		comboBoxOp.setBounds(110, 25, 395, 25);
		ConSetPanel.add(comboBoxOp);
		
		panelSequence = new JPanel();
		panelSequence.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sequence Constraint", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelSequence.setBounds(30, 55, 475, 243);
		ConSetPanel.add(panelSequence);
		panelSequence.setLayout(null);
		
		btnAddButton = new JButton("Add Sequence");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Converter c = new Converter(map);
				c.setupConnection(g, comboBoxFrom.getSelectedItem().toString(), comboBoxTo.getSelectedItem().toString());
				System.out.println("Add Success !");
//				String str = textAreapreOp.getText();
//				if(str != null && str.length() != 0) {
//					if(str.trim().equals("null")){
//						String sequenceStr =  mapIO.get(comboBoxOp.getSelectedItem().toString());
//						addSingelSequence(sequenceStr);
//					}
//				}
			}
		});
		btnAddButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnAddButton.setBounds(345, 208, 120, 25);
		panelSequence.add(btnAddButton);
		
		lblpreOPLabel = new JLabel("preOP:");
		lblpreOPLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblpreOPLabel.setBounds(21, 55, 50, 25);
		panelSequence.add(lblpreOPLabel);
		
		
		JLabel label = new JLabel("Set Connect Between Nodes:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setBounds(21, 100, 180, 25);
		panelSequence.add(label);
		
//		lblSqLabel = new JLabel("Sequence:");
//		lblSqLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
//		lblSqLabel.setBounds(20, 60, 70, 25);
//		panelSequence.add(lblSqLabel);
		
		textAreapreOp = new JTextArea();
		textAreapreOp.setBounds(72, 46, 393, 23);
		textAreapreOp.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textAreapreOp.setEditable(false);
		textAreapreOp.setBackground(SystemColor.control);
		scrollPaneOp = new JScrollPane(textAreapreOp);
		scrollPaneOp.setBounds(70, 44, 395, 51);
		scrollPaneOp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		panelSequence.add(scrollPaneOp);
		
		label_1 = new JLabel("From");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setBounds(21, 135, 35, 25);
		panelSequence.add(label_1);
		
		label_2 = new JLabel("To");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_2.setBounds(252, 135, 20, 25);
		panelSequence.add(label_2);
		
		comboBoxFrom = new JComboBox();
		comboBoxFrom.setBounds(58, 137, 188, 25);
		panelSequence.add(comboBoxFrom);
		
		comboBoxTo = new JComboBox();
		comboBoxTo.setBounds(275, 137, 188, 25);
		panelSequence.add(comboBoxTo);
		
		btnGModelButton = new JButton("Generate Model");
		btnGModelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
				Converter c = new Converter(map);
				c.convert(g, name);
				/**
				 * 这里来几个map试试模型生成算法的正确性，之后注释掉
				 */
				//
//				mapSq.put("A1#A2#B1#B2#C1#C2", "C");
//				mapSq.put("A1#A2", "A");
//				mapSq.put("D1#D2#C1#C2", "C");
//				mapSq.put("D1#D2", "D");
//				mapSq.put("B1#B2", "B");
				//
//				GenerateModel modelPanel = new GenerateModel(url, map, mapSq, tabbedPane);
//				tabbedPane.addTab("Generate Models", null, modelPanel, null);
//				modelPanel.setPreferredSize(new Dimension(915, 445));
				GenerateTestSequence gtsPanel = new GenerateTestSequence(url,g,tabbedPane);
				tabbedPane.addTab("Generate TestSequences", null, gtsPanel, null);
				gtsPanel.setPreferredSize(new Dimension(915, 445));
				
			}
		});
		btnGModelButton.setBounds(375, 302, 130, 25);
		btnGModelButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		ConSetPanel.add(btnGModelButton);
	}
	
	/**
	 * 与业务逻辑关联操作
	 */
	private void parseButtonAction() {
		/**
		 * 解析
		 */
		ReadWsdl readwsdl = new ReadWsdl(url);
		String name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
		readwsdl.DefInterface(name);
		map = readwsdl.getXmlInputFormatMap();
		textAreaResult.setText(readwsdl.getpanelResult());
//		for(int i = 0; i < readwsdl.getBindingOperation().size(); i++) {
//			comboBoxOp.addItem(readwsdl.getBindingOperation().get(i).getOperation().getName());
//		}
		textAreapreOp.setText("preOp");
//		ParseSequence parsesequence = new ParseSequence();
//		parsesequence.sequenceParse(name);
//		mapC = parsesequence.getmapC();
//		mapIO =  parsesequence.getmapIO();
		/**
		 * 获取xsd，后期测试用例执行过程验证时使用
		 */
		GetXsd.getXsd(url,name);
		
		//生成初始模型
		Converter c = new Converter(map);
		g = new Graph();
		g = c.initialNode(name);
		LinkedHashSet<Node> nodes = g.getNodes();
		ArrayList<String> OPI = readwsdl.getOpNameInputName();
		for(int i = 0; i < OPI.size(); i++) {
//			System.out.println(OPI.get(i).split("#")[0]);
//			System.out.println(OPI.get(i).split("#")[1]);
			comboBoxOp.addItem(OPI.get(i).split("#")[1]);
		}
		for(Node node: nodes) {
			comboBoxFrom.addItem(node.getName());
			comboBoxTo.addItem(node.getName());
		}
		//解析excel获取决策表约束
		ParseDT pdt = new ParseDT(name);
		pdt.findExcel("CBWSTC_WorkSpace/Projects/" + name + "/Excel/");
	}
}
