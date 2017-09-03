package cn.edu.ustb.cbwstc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JLabel;







import cn.edu.ustb.cbwstc.config.ConfigWorkSpace;

public class Mainform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private ParsePanel parsePanel;
	private GenerateModel modelPanel;
	private GenerateTestCase gTCPanel;
	private RunTest rtPanel;
	private ResultReport resultPanel;
	private JPanel panelConsole;
	
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnRun;
	private JMenu mnHelp;
	private JMenuItem jMenuItemExit;
	private JMenuItem jMenuItemImport;
	private JMenuItem jMenuItemRun;
	private JMenuItem jMenuItemStop;
	
	
	private JTextArea textAreaConsole;
	private JScrollPane scrollPaneConsole;
	private JLabel lblSelectWSDLFile;
	private JTextField Wsdlpath;
	private JButton btnBrowse;
	private JButton btnChose;
	private JButton btnCancel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainform frame = new Mainform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainform() {
		setTitle("CBWSTC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 750);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/**
		 * 加入工具菜单全部选项
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		mnRun = new JMenu("Tomcat");
		menuBar.add(mnRun);
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		/**
		 * mnFile 菜单中添加选项
		 */
		jMenuItemExit = new JMenuItem();
		jMenuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		jMenuItemExit.setText("Exit");
		mnFile.add(jMenuItemExit);
		
		jMenuItemImport = new JMenuItem();
		jMenuItemImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jMenuItemImport.setText("Import WSDLs");
		mnFile.add(jMenuItemImport);
		
		/**
		 * mnRun 菜单中添加选项
		 */
		jMenuItemRun = new JMenuItem();
		jMenuItemRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jMenuItemRun.setText("Run Tomcat");
		mnRun.add(jMenuItemRun);
		
		jMenuItemStop = new JMenuItem();
		jMenuItemStop.setText("Stop Tomcat");
		mnRun.add(jMenuItemStop);
		
		
		/**
		 * 选择WSDL区域
		 */
		contentPane.setLayout(null);
		lblSelectWSDLFile = new JLabel();
		lblSelectWSDLFile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSelectWSDLFile.setText("Select WSDL URL/File：");
		lblSelectWSDLFile.setBounds(10, 10, 140, 25);
		contentPane.add(lblSelectWSDLFile);
		Wsdlpath = new JTextField();
		Wsdlpath.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Wsdlpath.setBounds(160, 10, 350, 25);
		contentPane.add(Wsdlpath);
		btnBrowse = new JButton();
		btnBrowse.addActionListener(new OpenActionListener());
		btnBrowse.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnBrowse.setText("Browse Related Excel");
		btnBrowse.setBounds(765, 10, 160, 25);
		contentPane.add(btnBrowse);
		btnChose = new JButton();
		btnChose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choseWSDL();
			}
		});
		btnChose.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnChose.setText("Chose");
		btnChose.setBounds(520, 10, 80, 25);
		contentPane.add(btnChose);
		btnCancel = new JButton();
		btnCancel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnCancel.setText("Cancel");
		btnCancel.setBounds(610, 10, 80, 25);
		contentPane.add(btnCancel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBackground(SystemColor.scrollbar);
		tabbedPane.setBounds(10, 50, 915, 488);
		contentPane.add(tabbedPane);
		
		/**
		 * panelConsole设置
		 */
		panelConsole = new JPanel();
		panelConsole.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Console", TitledBorder.LEFT, TitledBorder.TOP, new Font("微软雅黑", Font.PLAIN, 12), new Color(0, 0, 0)));
		panelConsole.setBounds(10, 541, 915, 150);
		getContentPane().add(panelConsole);
		panelConsole.setLayout(null);
		
		textAreaConsole = new JTextArea();
		textAreaConsole.setBackground(SystemColor.control);
		textAreaConsole.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPaneConsole = new JScrollPane(textAreaConsole);
		scrollPaneConsole.setBounds(10, 23, 895, 117);
		scrollPaneConsole.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneConsole.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelConsole.add(scrollPaneConsole);
		
		
	}
	
	/**
	 * 与业务逻辑关联操作
	 */
	private void choseWSDL() {
		if(Wsdlpath.getText() != null && "".equals(Wsdlpath.getText().trim())) {
			
		} else {
			/**
			 * 初始化目录过程：
			 */
			ConfigWorkSpace.configFile();
			ConfigWorkSpace.choseFileDirectory(Wsdlpath.getText().trim());
			/**
			 * 添加页面布局
			 */
			parsePanel = new ParsePanel(Wsdlpath.getText().trim(),tabbedPane);
			tabbedPane.addTab("Parse WSDL", null, parsePanel, null);
			parsePanel.setPreferredSize(new Dimension(915, 445));
//			modelPanel = new GenerateModel();
//			tabbedPane.addTab("Generate Models", null, modelPanel, null);
//			gTCPanel = new  GenerateTestCase();
//			tabbedPane.addTab("Generate Test Cases", null, gTCPanel, null);
//			rtPanel = new RunTest();
//			tabbedPane.addTab("Run Tests", null, rtPanel, null);
//			resultPanel = new ResultReport();
//			tabbedPane.addTab("Result Report", null, resultPanel, null);
			
//			/**
//			 * Console重定向
//			 */
//			OutputStream textAreaStream = new OutputStream() {
//				public void write(int b) throws IOException {
//					textAreaConsole.append(String.valueOf((char)b));
//				}
//				public void write(byte b[]) throws IOException {
//					textAreaConsole.append(new String(b));
//				}
//				public void write(byte b[], int off, int len) throws IOException {
//					textAreaConsole.append(new String(b, off, len));
//				}
//			};
//			PrintStream myOut = new PrintStream(textAreaStream);
//			System.setOut(myOut);
//			System.setErr(myOut);
//			textAreaConsole.setCaretPosition(textAreaConsole.getDocument().getLength());
		}
	}
	
	private void runTomcat() {
		
	}
	
	private class OpenActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			
			String startPath = System.getProperty("user.dir");
			fileChooser.setCurrentDirectory(new File(startPath));
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setFileFilter(new FileFilter(){
				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					if(f.isDirectory()) {
						return true;
					}
					return false;
				}

				public String getDescription() {
					// TODO Auto-generated method stub
					return null;
				}});
			fileChooser.showDialog(null, "OK");
			if(fileChooser.getSelectedFile() != null) {
				String path = fileChooser.getSelectedFile().getAbsolutePath();
				String separator = File.separator;
				String namet = Wsdlpath.getText().trim();
				String name = namet.substring(namet.lastIndexOf("/")+1, namet.length()-5);
				String file = System.getProperty("user.dir") + separator 
						+ "CBWSTC_WorkSpace" + separator 
						+ "Projects" + separator 
						+ name + separator 
						+"Excel" + separator;
				String cmd = "xcopy " + path + " " + file + " /y";
				try {
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}	
		
	}
	
}
