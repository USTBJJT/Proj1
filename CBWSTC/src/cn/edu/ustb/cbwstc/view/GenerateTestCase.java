package cn.edu.ustb.cbwstc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import cn.edu.ustb.cbwstc.Experiment.ScriptToFrame;
import cn.edu.ustb.cbwstc.model.Graph;
import cn.edu.ustb.cbwstc.tsg.TeatSequence;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GenerateTestCase extends JPanel {
	
	private JComboBox<String> comboBoxSelect;
	private JTextArea textAreaShow;
	private JTable tableTC;
	private JScrollPane scrollPaneTC;
	private DefaultTableModel model;   //表格模型对象
	private JTabbedPane tabbedPane;
	
	private String url;
	private String name;
	private ArrayList<TeatSequence> tss  = new ArrayList<TeatSequence>();
	private Graph g = new Graph();
	
	/**
	 * Create the panel.
	 */
	public GenerateTestCase(String WsdlUrl,Graph g,ArrayList<TeatSequence> tss,JTabbedPane tabbedPane) {
		this.url = WsdlUrl;
		this.g = g;
		this.name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
		this.tss = tss;
		this.tabbedPane = tabbedPane;
		initComponents();
		compInitialization();
	}
	
	private void initComponents() {
		
		setLayout(null);
		//统计布局
		JPanel panelTotal = new JPanel();
		panelTotal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Statistics", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelTotal.setBounds(10, 10, 235, 298);
		add(panelTotal);
		
		String[] headers = { "Id", "Number" };
		Object[][] cellData = new Object[tss.size()][2];
		for(int i=0;i<tss.size();i++) {
			int id = tss.get(i).getTcId();
			cellData[i][0] = id;
			cellData[i][1] = countTC(id);
		}
		model = new DefaultTableModel(cellData, headers) {
					public boolean isCellEditable(int row,int colum) {
						return false;
					}
				};
		tableTC = new JTable(model);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();     
		r.setHorizontalAlignment(SwingConstants.CENTER);     
		tableTC.setDefaultRenderer(Object.class, r);
		panelTotal.setLayout(null);
		
		tableTC.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPaneTC = new JScrollPane(tableTC);
		scrollPaneTC.setBounds(10, 24, 215, 264);
		scrollPaneTC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPaneTC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelTotal.add(scrollPaneTC);
		
		//展示布局
		JPanel panelShow = new JPanel();
		panelShow.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TC Show", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelShow.setBounds(255, 10, 650, 425);
		add(panelShow);
		panelShow.setLayout(null);
		
		JPanel panelTc = new JPanel();
		panelTc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TestCase", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelTc.setBounds(10, 77, 630, 338);
		panelShow.add(panelTc);
		panelTc.setLayout(null);
		
		textAreaShow = new JTextArea();
		textAreaShow.setBackground(SystemColor.control);
		JScrollPane scrollPaneShow = new JScrollPane(textAreaShow);
		scrollPaneShow.setBounds(10, 26, 610, 302);
		scrollPaneShow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPaneShow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelTc.add(scrollPaneShow);
		
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String fileName = comboBoxSelect.getSelectedItem().toString();
				String file = "CBWSTC_WorkSpace/Projects/" + name + "/TC/" + fileName;
				textAreaShow.setText(showTestCase(file));
				textAreaShow.paintImmediately(textAreaShow.getBounds());
			}
		});
		comboBoxSelect.setBounds(235, 34, 360, 21);
		panelShow.add(comboBoxSelect);
		
		JLabel lblSelect = new JLabel("Select the test case to query");
		lblSelect.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSelect.setBounds(50, 37, 175, 15);
		panelShow.add(lblSelect);
		
		//执行布局
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Test Execution", TitledBorder.LEADING, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panel.setBounds(10, 318, 235, 117);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Execution");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ScriptToFrame stc = new ScriptToFrame(url,g,tss);
				stc.testProcess(tss.size());
				stc.getArray();
				ResultReport rrPanel = new ResultReport(tabbedPane);
				tabbedPane.addTab("Result Report", null, rrPanel, null);
				rrPanel.setPreferredSize(new Dimension(915, 445));
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setBounds(132, 84, 93, 23);
		panel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Click \"Execution\" button\r\nExecuting the above Test Cases");
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 31, 215, 43);
		panel.add(textArea);
	}
	
	/**
	 * 组件初始化
	 */
	private void compInitialization() {
		String[] filePathN = null;
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/TC");
		filePathN = f.list();
		for(int i=0;i<filePathN.length;i++) {
			comboBoxSelect.addItem(filePathN[i]);
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
	
	private int countTC(int id) {
		int count = 0;
		String[] filePathN = null;
		File f = new File("CBWSTC_WorkSpace/Projects/" + name + "/TC");
		filePathN = f.list();
		for(int i=0;i<filePathN.length;i++) {
			if(filePathN[i].split("#")[1].equals(String.valueOf(id))) {
				count++;
			}
		}
		return count;
	}
}
