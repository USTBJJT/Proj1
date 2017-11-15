package cn.edu.ustb.cbwstc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import cn.edu.ustb.cbwstc.tsg.TeatSequence;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultReport extends JPanel {
	
	private static HashMap<String,String> eTimeC = new HashMap<String,String>();
	private static HashMap<String,String> paramRangeC = new HashMap<String,String>();
	private static HashMap<String,String> sequenceC = new HashMap<String,String>();
	private static HashMap<String,String> callC = new HashMap<String,String>();
	private static HashMap<String,String> paramRelationC = new HashMap<String,String>();
	private static HashMap<String,String> invokeC = new HashMap<String,String>();
	private static HashMap<String,String> ipRangeC = new HashMap<String,String>();
	private ArrayList<TeatSequence> tss  = new ArrayList<TeatSequence>();
	private String uri = "";
	private String name = "";
	private ActionListener listener;
	
	private JTabbedPane tabbedPane;
	private DefaultTableModel modelSR;   //表格模型对象
	private DefaultTableModel modelDI;   //表格模型对象
	
	String projectName ="";
	private JTable tableSR;
	private JTable tableDI;
	private JComboBox comboBox;
	private JTextArea textAreaD;
	/**
	 * Create the panel.
	 */
	public ResultReport(JTabbedPane tabbedPane,HashMap<String,String> eTimeC,
			HashMap<String,String> paramRangeC,HashMap<String,String> sequenceC,
			HashMap<String,String> callC,HashMap<String,String> paramRelationC,
			HashMap<String,String> invokeC,HashMap<String,String> ipRangeC, ArrayList<TeatSequence> tss,String uri) {
		this.eTimeC = eTimeC;
		this.paramRangeC = paramRangeC;
		this.sequenceC = sequenceC;
		this.callC = callC;
		this.paramRelationC = paramRelationC;
		this.invokeC = invokeC;
		this.ipRangeC = ipRangeC;
		this.tabbedPane = tabbedPane;
		this.tss = tss;
		this.uri = uri;
		this.name = uri.substring(uri.lastIndexOf("/")+1, uri.length()-5);
		initComponents();
		setPaneSR();
		setpaneDI();
	}
	
	private void initComponents() {
		setLayout(null);
		
		JPanel panelSR = new JPanel();
		panelSR.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Statistic Report", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelSR.setBounds(10, 10, 352, 154);
		add(panelSR);
		panelSR.setLayout(null);
		
		
		
				
		JPanel panelDI = new JPanel();
		panelDI.setLayout(null);
		panelDI.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detailed Information", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelDI.setBounds(10, 174, 352, 261);
		add(panelDI);
		
		JPanel panelD = new JPanel();
		panelD.setLayout(null);
		panelD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detail", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelD.setBounds(372, 10, 533, 425);
		add(panelD);
		
		JLabel lblNewLabel = new JLabel("Select the test case to query:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel.setBounds(25, 30, 180, 15);
		panelD.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(207, 27, 316, 21);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					String fileName = comboBox.getSelectedItem().toString();
					String file = "CBWSTC_WorkSpace/Projects/" + name + "/Result/" + fileName;
					textAreaD.setText(showTestCase(file));
					textAreaD.paintImmediately(textAreaD.getBounds());
				}
			}
		});
		panelD.add(comboBox);
		
		
		
		textAreaD = new JTextArea();
		textAreaD.setBackground(SystemColor.control);
		textAreaD.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		JScrollPane scrollPaneD = new JScrollPane(textAreaD);
		scrollPaneD.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneD.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneD.setBounds(25, 64, 498, 351);
		
		panelD.add(scrollPaneD);
		//scrollPaneD.setColumnHeaderView(textAreaD);
		
		//表格名称内容初始化
		String[] headers = {"Item", "NUM.", "PCT."};
		Object[][] cellData = new Object[0][3];
		modelSR = new DefaultTableModel(cellData, headers) {
			public boolean isCellEditable(int row,int colum) {
				return false;
			}
		};
		
		
		tableSR = new JTable(modelSR);
		JScrollPane scrollPane = new JScrollPane(tableSR);
		scrollPane.setBounds(10, 23, 332, 121);
		panelSR.add(scrollPane);
//		tableSR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableSR.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSR.setBounds(10, 23, 332, 121);
		
		String[] headersD = {"Constraint", "NUM.", "PCT."};
		Object[][] cellDataD = new Object[0][3];
		modelDI = new DefaultTableModel(cellDataD, headersD) {
			public boolean isCellEditable(int row,int colum) {
				return false;
			}
		};
		
		tableDI = new JTable(modelDI);
		tableDI.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int rowI  = tableDI.rowAtPoint(e.getPoint());// 得到table的行号
				String conType = tableDI.getValueAt(rowI,0).toString();  //得到所在行的第一个列的值，作为下面事件传递的参数
				comboBox.removeAllItems();
			    paneDChanged(conType);
			}
		});
		JScrollPane scrollPaneDI = new JScrollPane(tableDI);
//		scrollPaneDI.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if(e.getClickCount()==2){//点击几次，这里是双击事件
//			        paneDChanged();        
//			    }
//			}
//		});
		scrollPaneDI.setBounds(10, 26, 332, 225);
		panelDI.add(scrollPaneDI);
//		tableDI.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDI.setBounds(10, 26, 332, 225);

	}
	
	private void setPaneSR() {
		String name = uri.substring(uri.lastIndexOf("/")+1, uri.length()-5);
		String[] filePathN = null;
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/TC");
		filePathN = f.list();
		int total = filePathN.length;
		int ptc = 0;
		int ntc = 0;
		for(int i=0; i<filePathN.length; i++) {
			int id = Integer.parseInt(filePathN[i].split("#")[1]);
			if(tss.get(id).getType().contains("positive")) {
				ptc++;
			}
			if(tss.get(id).getType().contains("negative")) {
				ntc++;
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数    
        String ptcp = df.format(((float)ptc/total)*100);//返回的是String类型 
        String ntcp = df.format(((float)ntc/total)*100);//返回的是String类型  
		//TODO set table model
		String[] rowValuesT = {"Total",String.valueOf(total),"100%"};
		modelSR.addRow(rowValuesT);  //添加一行
		String[] rowValuesP = {"Positive",String.valueOf(ptc), ptcp + "%"};
		modelSR.addRow(rowValuesP);  //添加一行
		String[] rowValuesN = {"Negative",String.valueOf(ntc), ntcp + "%"};
		modelSR.addRow(rowValuesN);  //添加一行
	}
	
	private void setpaneDI() {
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数   
		int total = eTimeC.size() + paramRangeC.size() +  sequenceC.size() + callC.size() + paramRelationC.size() + invokeC.size() + ipRangeC.size();
        
		int eTimeCN = eTimeC.size();
		String eTimeCp = df.format(((float)eTimeCN/total)*100);//返回的是String类型 
		String[] rowValueseTimeC = {"eTime",String.valueOf(eTimeCN), eTimeCp + "%"};
		modelDI.addRow(rowValueseTimeC);  //添加一行
		
		int paramRangeCN = paramRangeC.size();
		String paramRangeCp = df.format(((float)paramRangeCN/total)*100);//返回的是String类型 
		String[] rowValuesparamRangeC = {"paraRestriction",String.valueOf(paramRangeCN), paramRangeCp + "%"};
		modelDI.addRow(rowValuesparamRangeC);  //添加一行
		
		int sequenceCN = sequenceC.size();
		String sequenceCp = df.format(((float)sequenceCN/total)*100);//返回的是String类型 
		String[] rowValuessequenceC = {"preOp",String.valueOf(sequenceCN), sequenceCp + "%"};
		modelDI.addRow(rowValuessequenceC);  //添加一行
		
		int callCN = callC.size();
		String callCp = df.format(((float)callCN/total)*100);//返回的是String类型 
		String[] rowValuescallC = {"Iteration",String.valueOf(callCN), callCp + "%"};
		modelDI.addRow(rowValuescallC);  //添加一行
		
		int paramRelationCN = paramRelationC.size();
		String paramRelationCp = df.format(((float)paramRelationCN/total)*100);//返回的是String类型 
		String[] rowValuesparamRelationC = {"paraRelation",String.valueOf(paramRelationCN), paramRelationCp + "%"};
		modelDI.addRow(rowValuesparamRelationC);  //添加一行
		
		int invokeCN = invokeC.size();
		String invokeCp = df.format(((float)invokeCN/total)*100);//返回的是String类型 
		String[] rowValuesinvokeC = {"invokeOp",String.valueOf(invokeCN), invokeCp + "%"};
		modelDI.addRow(rowValuesinvokeC);  //添加一行
		
		int ipRangeCN = ipRangeC.size();
		String ipRangeCp = df.format(((float)ipRangeCN/total)*100);//返回的是String类型 
		String[] rowValuesipRangeC = {"ipRegion",String.valueOf(ipRangeCN), ipRangeCp + "%"};
		modelDI.addRow(rowValuesipRangeC);  //添加一行
		
	}
	
	private void paneDChanged(String conType) {
		
		ArrayList<String> file = new ArrayList<String>();
		if(conType.equals("eTime")) {
			for (String key : eTimeC.keySet()) {
				file.add(key);
			}
		}else if(conType.equals("paraRestriction")) {
			for (String key : paramRangeC.keySet()) {
				file.add(key);
			}
		}else if(conType.equals("preOp")) {
			for (String key : sequenceC.keySet()) {
				file.add(key);
			}
		}else if(conType.equals("Iteration")) {
			for (String key : callC.keySet()) {
				file.add(key);
			}
		}else if(conType.equals("paraRelation")) {
			for (String key : paramRelationC.keySet()) {
				file.add(key);
			}
		}else if(conType.equals("invokeOp")) {
			for (String key : invokeC.keySet()) {
				file.add(key);
			}
		}else if(conType.equals("ipRegion")){
			for (String key : ipRangeC.keySet()) {
				file.add(key);
			}
		}else {
			
		}
//		System.out.println(conType);
//		comboBox.removeAllItems();
		for(int i=0;i<file.size();i++) {
			comboBox.addItem(file.get(i));
		}
	}
	
	/**
	 * TestCase文件读取
	 * @param file
	 * @return
	 */
	@SuppressWarnings("resource")
	private String showTestCase(String file) {
		File f = new File(file);
		String strT = "";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String str = null;
			try {
				while((str = br.readLine()) != null) {
					strT = strT + str + "\r\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strT;
	}
}
