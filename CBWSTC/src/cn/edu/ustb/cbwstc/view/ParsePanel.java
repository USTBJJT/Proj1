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
import java.util.HashMap;
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
	private Map<String, XmlInputFormat> map = new HashMap<String, XmlInputFormat>();
	
	private JPanel parsePanel;
	private JPanel panelResult;
	private JPanel panelConsole;
	private JPanel ConSetPanel;
	private JPanel panelSequence;
	
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneResult;
	private JScrollPane scrollPaneConsole;
	
	private JTextArea textAreaURL;
	private JTextArea textAreaResult;
	private JTextArea textAreaConsole;
	private JTextArea textAreapreOp;
	private JButton btnParseButton;
	private JButton btnGModelButton;
	private JButton btnAddButton;
	private JComboBox<String> comboBoxOp;
	private JLabel lblOpLabel;
	private JLabel lblpreOPLabel;
	private JLabel lblSqLabel;
	private JScrollPane scrollPaneOp;
	
	
	

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
		 * parsePanel…Ë÷√
		 */
		parsePanel = new JPanel();
		parsePanel.setBounds(10, 10, 515, 90);
		parsePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Parse WSDL", TitledBorder.LEFT, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		add(parsePanel);
		parsePanel.setLayout(null);
		
		textAreaURL = new JTextArea();
		textAreaURL.setBackground(SystemColor.control);
		textAreaURL.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
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
		btnParseButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		btnParseButton.setBounds(435, 55, 70, 25);
		parsePanel.add(btnParseButton);
		
		/**
		 * panelResult…Ë÷√
		 */
		panelResult = new JPanel();
		panelResult.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result", TitledBorder.LEFT, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelResult.setBounds(535, 10, 365, 427);
		add(panelResult);
		panelResult.setLayout(null);
		
		textAreaResult = new JTextArea();
		textAreaResult.setBackground(SystemColor.control);
		textAreaResult.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		scrollPaneResult = new JScrollPane(textAreaResult);
		scrollPaneResult.setBounds(10, 23, 345, 394);
		scrollPaneResult.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneResult.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelResult.add(scrollPaneResult);
		
		/**
		 * panelConsole…Ë÷√
		 */
		panelConsole = new JPanel();
		panelConsole.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Console", TitledBorder.LEFT, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelConsole.setBounds(10, 440, 890, 150);
		add(panelConsole);
		panelConsole.setLayout(null);
		
		textAreaConsole = new JTextArea();
		textAreaConsole.setBackground(SystemColor.control);
		textAreaConsole.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		scrollPaneConsole = new JScrollPane(textAreaConsole);
		scrollPaneConsole.setBounds(10, 23, 870, 117);
		scrollPaneConsole.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneConsole.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelConsole.add(scrollPaneConsole);
		
		/**
		 * ConSetPanel…Ë÷√
		 */
		ConSetPanel = new JPanel();
		ConSetPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Constraint Set", TitledBorder.LEFT, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		ConSetPanel.setBounds(10, 100, 515, 337);
		add(ConSetPanel);
		ConSetPanel.setLayout(null);
		
		lblOpLabel = new JLabel("Operation: ");
		lblOpLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		lblOpLabel.setBounds(30, 30, 80, 15);
		ConSetPanel.add(lblOpLabel);
		
		comboBoxOp = new JComboBox<String>();
		comboBoxOp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String str = mapC.get(comboBoxOp.getSelectedItem().toString());
				textAreapreOp.setText(str);
			}
		});
		comboBoxOp.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		comboBoxOp.setBounds(110, 25, 395, 25);
		ConSetPanel.add(comboBoxOp);
		
		panelSequence = new JPanel();
		panelSequence.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Call Sequence Constraint", TitledBorder.LEFT, TitledBorder.TOP, new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelSequence.setBounds(30, 55, 475, 243);
		ConSetPanel.add(panelSequence);
		panelSequence.setLayout(null);
		
		btnAddButton = new JButton("Add Call Sequence");
		btnAddButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		btnAddButton.setBounds(315, 208, 150, 25);
		panelSequence.add(btnAddButton);
		
		lblpreOPLabel = new JLabel("preOP:");
		lblpreOPLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		lblpreOPLabel.setBounds(20, 30, 50, 25);
		panelSequence.add(lblpreOPLabel);
		
		lblSqLabel = new JLabel("Sequence:");
		lblSqLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		lblSqLabel.setBounds(20, 60, 70, 25);
		panelSequence.add(lblSqLabel);
		
		textAreapreOp = new JTextArea();
		textAreapreOp.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		textAreapreOp.setEditable(false);
		textAreapreOp.setBackground(SystemColor.control);
		scrollPaneOp = new JScrollPane(textAreapreOp);
		scrollPaneOp.setBounds(70, 30, 395, 25);
		scrollPaneOp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		panelSequence.add(scrollPaneOp);
		
		btnGModelButton = new JButton("Generate Model");
		btnGModelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerateModel modelPanel = new GenerateModel(url, map, tabbedPane);
				tabbedPane.addTab("Generate Models", null, modelPanel, null);
				modelPanel.setPreferredSize(new Dimension(915, 600));
			}
		});
		btnGModelButton.setBounds(375, 302, 130, 25);
		btnGModelButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		ConSetPanel.add(btnGModelButton);
	}
	
	/**
	 * ”Î“µŒÒ¬ﬂº≠πÿ¡™≤Ÿ◊˜
	 */
	private void parseButtonAction() {
		/**
		 * Console÷ÿ∂®œÚ
		 */
		OutputStream textAreaStream = new OutputStream() {
			public void write(int b) throws IOException {
				textAreaConsole.append(String.valueOf((char)b));
			}
			public void write(byte b[]) throws IOException {
				textAreaConsole.append(new String(b));
			}
			public void write(byte b[], int off, int len) throws IOException {
				textAreaConsole.append(new String(b, off, len));
			}
		};
		PrintStream myOut = new PrintStream(textAreaStream);
		System.setOut(myOut);
		System.setErr(myOut);
		
		
		/**
		 * Ω‚Œˆ
		 */
		ReadWsdl readwsdl = new ReadWsdl(url);
		String name = url.substring(url.lastIndexOf("/")+1, url.length()-5);
		readwsdl.DefInterface(name);
		map = readwsdl.getXmlInputFormatMap();
		textAreaConsole.setCaretPosition(textAreaConsole.getDocument().getLength());
		textAreaResult.setText(readwsdl.getpanelResult());
		for(int i = 0; i < readwsdl.getBindingOperation().size(); i++) {
			comboBoxOp.addItem(readwsdl.getBindingOperation().get(i).getOperation().getName());
		}
		ParseSequence parsesequence = new ParseSequence();
		parsesequence.sequenceParse(name);
		mapC = parsesequence.getmapC();
		mapIO =  parsesequence.getmapIO();
		/**
		 * ªÒ»°xsd£¨∫Û∆⁄≤‚ ‘”√¿˝÷¥––π˝≥Ã—È÷§ ± π”√
		 */
		GetXsd.getXsd(url,name);
	}
}
