package cn.edu.ustb.cbwstc.view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnRun;
	private JMenu mnHelp;
	private JMenuItem jMenuItemExit;
	private JMenuItem jMenuItemImport;
	private JMenuItem jMenuItemRun;
	private JMenuItem jMenuItemStop;
	
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
		contentPane.setLayout(new BorderLayout(0, 0));
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
		lblSelectWSDLFile = new JLabel();
		lblSelectWSDLFile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSelectWSDLFile.setText("Select WSDL URL/File：");
		lblSelectWSDLFile.setBounds(10, 10, 140, 25);
		contentPane.add(lblSelectWSDLFile, BorderLayout.NORTH);
		Wsdlpath = new JTextField();
		Wsdlpath.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Wsdlpath.setBounds(160, 10, 350, 25);
		contentPane.add(Wsdlpath);
		btnBrowse = new JButton();
		btnBrowse.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnBrowse.setText("Browse");
		btnBrowse.setBounds(520, 10, 80, 25);
		contentPane.add(btnBrowse);
		btnChose = new JButton();
		btnChose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choseWSDL();
			}
		});
		btnChose.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnChose.setText("Chose");
		btnChose.setBounds(610, 10, 80, 25);
		contentPane.add(btnChose);
		btnCancel = new JButton();
		btnCancel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnCancel.setText("Cancel");
		btnCancel.setBounds(700, 10, 80, 25);
		contentPane.add(btnCancel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBackground(SystemColor.scrollbar);
		tabbedPane.setBounds(10, 50, 915, 630);
		contentPane.add(tabbedPane);
		
		
		
		
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
			parsePanel.setPreferredSize(new Dimension(915, 600));
//			modelPanel = new GenerateModel();
//			tabbedPane.addTab("Generate Models", null, modelPanel, null);
//			gTCPanel = new  GenerateTestCase();
//			tabbedPane.addTab("Generate Test Cases", null, gTCPanel, null);
//			rtPanel = new RunTest();
//			tabbedPane.addTab("Run Tests", null, rtPanel, null);
//			resultPanel = new ResultReport();
//			tabbedPane.addTab("Result Report", null, resultPanel, null);
		}
	}
	
	private void runTomcat() {
		
	}
	
}
