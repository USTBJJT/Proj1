package cn.edu.ustb.cbwstc.view;

import javax.swing.JPanel;

import cn.edu.ustb.cbwstc.Experiment.ScriptToFrame;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.modelCore.ModelVisualization;
import cn.edu.ustb.cbwstc.tsg.GetInitialTestSequence;
import cn.edu.ustb.cbwstc.tsg.TeatSequence;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

public class GenerateTestSequence extends JPanel {
	
	private JTable tableTS;
	private JScrollPane scrollPaneTS;
	private DefaultTableModel model;   //表格模型对象
	private JTabbedPane tabbedPane;
	
	private String url;
	private String name;
	private ArrayList<TeatSequence> tss  = new ArrayList<TeatSequence>();
	private Graph g = new Graph();
	/**
	 * Create the panel.
	 */
	public GenerateTestSequence(String WsdlUrl,Graph g,JTabbedPane tabbedPane) {
		this.url = WsdlUrl;
		this.g = g;
		this.name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
		this.tabbedPane = tabbedPane;
		initComponents();
	}
	
	private void initComponents() {
		setLayout(null);
		
		//查看模型布局
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Model View", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panel.setBounds(10, 10, 275, 140);
		add(panel);
		
		JButton button = new JButton("ShowPic");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModelVisualization mv = new ModelVisualization();
				mv.imageView(name);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		button.setBounds(172, 107, 93, 23);
		panel.add(button);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Click \"ShowPic\" button\r\nBrowsing the Service Behavior Model");
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(25, 41, 226, 38);
		panel.add(textArea);
		
		//覆盖准则布局
		JPanel panelCoverage = new JPanel();
		panelCoverage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Coverage Criteria", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelCoverage.setBounds(288, 10, 617, 140);
		add(panelCoverage);
		panelCoverage.setLayout(null);
		
		JRadioButton RadioButtonOcoverage = new JRadioButton("Request-Node Covering",true);
		RadioButtonOcoverage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		RadioButtonOcoverage.setBounds(25, 63, 172, 23);
		panelCoverage.add(RadioButtonOcoverage);
		
		JRadioButton RadioButtonRMcoverage = new JRadioButton("Response-Node Covering");
		RadioButtonRMcoverage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		RadioButtonRMcoverage.setBounds(217, 63, 199, 23);
		panelCoverage.add(RadioButtonRMcoverage);
		
		JRadioButton RadioButtonEcoverage = new JRadioButton("Edge covering");
		RadioButtonEcoverage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		RadioButtonEcoverage.setBounds(418, 63, 121, 23);
		panelCoverage.add(RadioButtonEcoverage);
		
		ButtonGroup group = new ButtonGroup();
		group.add(RadioButtonOcoverage);
		group.add(RadioButtonRMcoverage);
		group.add(RadioButtonEcoverage);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Consider covering decision table States");
		chckbxNewCheckBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(25, 100, 255, 23);
		panelCoverage.add(chckbxNewCheckBox);
		
		JTextArea textAreaSelect = new JTextArea();
		textAreaSelect.setText("Select coverage criteria to generate Test Sequences from Model");
		textAreaSelect.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textAreaSelect.setBackground(SystemColor.menu);
		textAreaSelect.setBounds(25, 34, 388, 23);
		panelCoverage.add(textAreaSelect);
		
		JButton btnNewButtonGener = new JButton("Generation");
		btnNewButtonGener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButtonGener.setEnabled(false);
				int Cover = 0;
				if(RadioButtonOcoverage.isSelected()) {
					Cover = 0;
				}else if(RadioButtonRMcoverage.isSelected()) {
					Cover = 1;
				}else {
					Cover = 2;
				}
				GetInitialTestSequence gts = new GetInitialTestSequence(g,name);
				tss = gts.chooseCovCri(Cover);
				model.setRowCount(0);
				for(int i=0;i<tss.size();i++) {
					String ce = "";
					for(int j=0;j<tss.get(i).getCoverElement().size();j++) {
						ce = ce + "[" + tss.get(i).getCoverElement().get(j) + "] ";
					}
					String []rowValues = {String.valueOf(tss.get(i).getTcId()),tss.get(i).getType(),tss.get(i).getTs(),ce};  
	                model.addRow(rowValues);  //添加一行
				}
				FitTableColumns(tableTS);
				btnNewButtonGener.setEnabled(true);
			}
		});
		btnNewButtonGener.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButtonGener.setBounds(507, 105, 100, 25);
		panelCoverage.add(btnNewButtonGener);
		
		JPanel panelTS = new JPanel();
		panelTS.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Test Sequences", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelTS.setBounds(10, 160, 895, 217);
		add(panelTS);
		panelTS.setLayout(null);
		//表格名称内容初始化
		String[] headers = { "Id", "Type", "Sequence", "Covered Element" };
		Object[][] cellData = new Object[0][4];
				model = new DefaultTableModel(cellData, headers) {
					public boolean isCellEditable(int row,int colum) {
						return false;
					}
				};
		tableTS = new JTable(model);
		tableTS.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//居中设置
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();     
		r.setHorizontalAlignment(SwingConstants.CENTER);     
		tableTS.setDefaultRenderer(Object.class, r);
		//Id列宽设置
		TableColumn c0 = tableTS.getColumnModel().getColumn(0);
		c0.setPreferredWidth(20);
		c0.setMaxWidth(20);
		c0.setMinWidth(20);
		
				
		tableTS.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPaneTS = new JScrollPane(tableTS);
		scrollPaneTS.setBounds(10, 23, 875, 184);
//		scrollPaneTS.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPaneTS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPaneTS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelTS.add(scrollPaneTS);
		
		JButton btnTestcaseGenerate = new JButton("TestCase Generate");
		btnTestcaseGenerate.setBounds(743, 387, 151, 23);
		add(btnTestcaseGenerate);
		btnTestcaseGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				boolean flag = false;
				if(chckbxNewCheckBox.isSelected()) {
					flag = true;
				}else {
					flag = false;
				}
				GetInitialTestSequence gts = new GetInitialTestSequence(g,name);
				gts.getTestCase(tss,flag);
				
				//跳转测试用例展示执行界面
				GenerateTestCase gtcPanel = new GenerateTestCase(url,g,tss,tabbedPane);
				tabbedPane.addTab("Generate TestCases", null, gtcPanel, null);
				gtcPanel.setPreferredSize(new Dimension(915, 445));
//				ScriptToFrame stc = new ScriptToFrame(url);
//				stc.testProcess(tss.size());
				
			}
		});
		btnTestcaseGenerate.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	}
	
	public void FitTableColumns(JTable myTable){ //宽度自适应
		JTableHeader header = myTable.getTableHeader();
		int rowCount = myTable.getRowCount();
		Enumeration columns = myTable.getColumnModel().getColumns();
		while(columns.hasMoreElements()){
			TableColumn column = (TableColumn)columns.nextElement();
		    int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		    int width = (int)myTable.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(myTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
		    for(int row = 0; row<rowCount; row++){
		    	int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
		        myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
		        width = Math.max(width, preferedWidth);
		    }
		    header.setResizingColumn(column); // 此行很重要
		    column.setWidth(width+myTable.getIntercellSpacing().width);
		}
	}
}
