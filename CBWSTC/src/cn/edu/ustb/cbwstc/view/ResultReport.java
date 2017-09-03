package cn.edu.ustb.cbwstc.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ResultReport extends JPanel {
	
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public ResultReport(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		initComponents();
	}
	
	private void initComponents() {
		setLayout(null);
	}

}
