package cn.edu.ustb.cbwstc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.fonts.DefaultMacFontPolicy;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceSaharaLookAndFeel;
import org.jvnet.substance.theme.SubstanceLightAquaTheme;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class InfoJPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel functionPanel = new JPanel();
	
	final JWebBrowser webBrowser = new JWebBrowser();
	String projectName ="";

	void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		functionPanel.setLayout(new BoxLayout(functionPanel,
				BoxLayout.LINE_AXIS));
		functionPanel.setBorder(BorderFactory.createEtchedBorder());
//		webBrowser.setBarsVisible(false);  
		webBrowser.navigate("E:/ResultHtml/docs/demo.html");

		functionPanel.add(webBrowser, BorderLayout.CENTER);
		this.add(functionPanel);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	InfoJPanel() {
//		this.projectName = Project.getInstance().getSelectProject();
		init();
	}

	InfoJPanel(String projectName) {
		this.projectName = projectName;
		init();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public static void main(String [] args)
	{
		NativeInterface.open();
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame f=new JFrame();
					InfoJPanel info=new InfoJPanel();
					f.add(info);

			        f.setLocation(200, 100);  
			        f.setSize(800,600);  
			        f.setVisible(true);  
					f.show();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		NativeInterface.runEventPump();
		
	}

}