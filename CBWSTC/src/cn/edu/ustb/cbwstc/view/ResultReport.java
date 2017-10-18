package cn.edu.ustb.cbwstc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class ResultReport extends JPanel {
	
	private JTabbedPane tabbedPane;
	private JPanel panelhtml;
	private JWebBrowser webBrowser = new JWebBrowser();
	String projectName ="";
	/**
	 * Create the panel.
	 */
	public ResultReport(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
//		init();
		initComponents();
//		init();
	}
	
	private void initComponents() {
//		init();
		setLayout(null);
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setSize(500, 375);
		shell.setText("WebKit");
		final Browser browser;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			System.out.println("Could not instantiate Browser: " + e.getMessage());
			display.dispose();
			return;
		}
		shell.open();
		String separator = File.separator;
		String html = System.getProperty("user.dir") + separator 
				+ "CBWSTC_WorkSpace" + separator + "ResultHtml/docs/demo.html";
		browser.setUrl("http://mail.xs.ustb.edu.cn/");
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
		panelhtml = new JPanel();
		panelhtml.setBounds(10, 10, 895, 425);
		panelhtml.setLayout(new BoxLayout(panelhtml,
				BoxLayout.LINE_AXIS));
		add(panelhtml);
//		panelhtml.add(webBrowser, BorderLayout.CENTER);
	}
	
	void init() {
//		panelhtml.setLayout(new BoxLayout(panelhtml,
//				BoxLayout.LINE_AXIS));
//		panelhtml.setBorder(BorderFactory.createEtchedBorder());
//		webBrowser.setBarsVisible(false);
		String separator = File.separator;
		String html = System.getProperty("user.dir") + separator 
				+ "CBWSTC_WorkSpace" + separator + "ResultHtml/docs/demo.html";
		webBrowser.useWebkitRuntime();
		webBrowser.navigate("E:\\BMD4WS_index\\index.html");//file:///E:/研究生毕业设计/template/html/chart_columnar.html
//		panelhtml.add(webBrowser, BorderLayout.CENTER);
//		this.add(panelhtml);
//		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

//	void init() {
////		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//		this.setLayout(new BoxLayout(this,
//				BoxLayout.LINE_AXIS));
//		this.setBorder(BorderFactory.createEtchedBorder());
////		webBrowser.setBarsVisible(false);
//		String separator = File.separator;
//		String html = System.getProperty("user.dir") + separator 
//				+ "CBWSTC_WorkSpace" + separator + "ResultHtml/docs/demo.html";
//		webBrowser.navigate("E:\\ResultHtml\\docs\\demo.html");//file:///E:/研究生毕业设计/template/html/chart_columnar.html
//
//		this.add(webBrowser, BorderLayout.CENTER);
////		this.add(this);
//		this.setBorder(BorderFactory.createLineBorder(Color.black));
//	}

}
