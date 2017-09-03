package cn.edu.ustb.cbwstc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import cn.edu.ustb.cbwstc.modelCore.Converter;
import cn.edu.ustb.cbwstc.modelCore.ModelVisualization;
import cn.edu.ustb.cbwstc.tcg.XmlInputFormat;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerateModel extends JPanel {
	
	private String url;
	private Map<String, XmlInputFormat> map = new HashMap<String, XmlInputFormat>();
	private Map<String, String> mapSq = new HashMap<String, String>();
	
	private JTabbedPane tabbedPane;
//	private JPanel panelBM;
	private JPanel panelTS;
	private JPanel panelGraph;
//	private JScrollPane scrollPanePic;
	private JScrollPane scrollPaneTS;
	private JScrollPane scrollPaneTSq;
//	private JPanel panelPic;
	
//	private JTextArea textAreaTS;
	private JTable tableTS;
	private JTextArea textAreaTSq;
	private JTextArea textAreaModel;
	
	/**
	 * Create the panel.
	 */
	public GenerateModel(String WsdlUrl, Map<String, XmlInputFormat> map, Map<String, String> mapSq,JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		url = WsdlUrl;
		this.map = map;
		this.mapSq = mapSq;
		initComponents();
		showTestSequence();
	}
	
	private void initComponents() {
		setLayout(null);
		
//		/**
//		 * panelBM≤ºæ÷…Ë÷√
//		 */
//		panelBM = new JPanel();
//		panelBM.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Behavior Model", TitledBorder.LEFT, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
//		panelBM.setBounds(10, 10, 570, 425);
//		add(panelBM);
//		panelBM.setLayout(null);
		
		String name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
		Converter c = new Converter(map,mapSq);//…˙≥…ƒ£–Õ
		c.convert(name, true);
		
//		String picName = "CBWSTC_WorkSpace/Projects/" + name + "/Graph/graphP.png";
//		ImageIcon icon = new ImageIcon(picName);
//		Image image1 = icon.getImage();
//		panelPic = new JPanel(){  
//		    @Override  
//		    public void paint(Graphics g) {  
//		        super.paint(g); 
//		        
//				if(image1 != null){  
//		            g.clearRect(0, 0, this.getWidth(), this.getHeight());  
//		            g.drawImage(image1, 0, 0, null);  
//		            g.dispose();  
//		        }  
//		    }  
//		};
//		panelPic.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));  
//		panelPic.updateUI();
//		scrollPanePic = new JScrollPane();
//		scrollPanePic.setBounds(10, 20, 550, 390);
//		scrollPanePic.setViewportView(panelPic);
//		panelBM.add(scrollPanePic);
		
		/**
		 * panelTS test sequence “≥√Ê≤ºæ÷
		 */
		panelTS = new JPanel();
		panelTS.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Test Sequence", TitledBorder.LEADING, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelTS.setBounds(10, 10, 725, 425);
		panelTS.setLayout(null);
		add(panelTS);
		
		//±Ì∏Ò√˚≥∆ƒ⁄»›≥ı ºªØ
		String[] headers = { "", "Operation", "Sequence" };
		Object[][] cellData = new Object[mapSq.size()][3];
		int count= 0;
		for (Map.Entry<String, String> entry : mapSq.entrySet()) {
			cellData[count][0] = count;
			cellData[count][1] = entry.getValue();
			cellData[count][2] = entry.getKey();
			count++;
		}
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			public boolean isCellEditable(int row,int colum) {
				return false;
			}
		};
		tableTS = new JTable(model);
		
		//æ”÷–…Ë÷√
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();     
		r.setHorizontalAlignment(SwingConstants.CENTER);     
		tableTS.setDefaultRenderer(Object.class, r);
		
		//¡–øÌ…Ë÷√
		tableTS.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableTS.getColumnModel().getColumn(0).setMaxWidth(20);
		tableTS.getColumnModel().getColumn(0).setMinWidth(20);
		
//		tableTS.getColumnModel().getColumn(2).setPreferredWidth(2000);
//		tableTS.getColumnModel().getColumn(2).setMinWidth(1000);
//		tableTS.getColumnModel().getColumn(2).setMaxWidth(2000);
//		tableTS.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tableTS.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		tableTS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTS = new JScrollPane(tableTS);
		tableTS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					int rowl = tableTS.rowAtPoint(e.getPoint());
					if(rowl > -1) {
						String oprChoose = (String) tableTS.getModel().getValueAt(rowl, 1);
						String pathChoose = (String) tableTS.getModel().getValueAt(rowl, 2);
						textAreaTSq.setText("The Test Sequence for the " + oprChoose + " Operation is\r\n" + pathChoose);
					}
				}
			}
		});
		scrollPaneTS.setBounds(10, 23, 705, 218);
		scrollPaneTS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneTS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelTS.add(scrollPaneTS);
		
		textAreaTSq = new JTextArea();
		textAreaTSq.setBackground(SystemColor.control);
		textAreaTSq.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		scrollPaneTSq = new JScrollPane(textAreaTSq);
		scrollPaneTSq.setBounds(10, 251, 705, 152);
		scrollPaneTSq.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneTSq.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelTS.add(scrollPaneTSq);
//		textAreaTS = new JTextArea();
////		textAreaTS.setBounds(10, 23, 295, 392);
//		textAreaTS.setBackground(SystemColor.control);
//		textAreaTS.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		/**
		 * panelGraph test sequence “≥√Ê≤ºæ÷
		 */
		panelGraph = new JPanel();
		panelGraph.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Model", TitledBorder.LEADING, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelGraph.setBounds(745, 10, 160, 143);
		add(panelGraph);
		panelGraph.setLayout(null);
		
		JButton btnNewButtonCkack = new JButton("ShowPic");
		btnNewButtonCkack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModelVisualization mv = new ModelVisualization();
				mv.imageView(name);
			}
		});
		btnNewButtonCkack.setBounds(57, 110, 93, 23);
		btnNewButtonCkack.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		panelGraph.add(btnNewButtonCkack);
		
		textAreaModel = new JTextArea();
		textAreaModel.setBounds(10, 41, 140, 55);
		textAreaModel.setBackground(SystemColor.control);
		textAreaModel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		panelGraph.add(textAreaModel);
		textAreaModel.setText("Click \"ShowPic\" button\r\n"
				+ "Browsing the service\r\n"
				+ "Behavior Model");
	}
	
	public void showTestSequence() {
		int count= 1;
		for (String key : mapSq.keySet()) {
			
//			textAreaTS.append(key);
//			textAreaTS.append("\n");
			count++;
		}
	}
}
