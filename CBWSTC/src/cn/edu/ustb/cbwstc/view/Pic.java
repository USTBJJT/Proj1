package cn.edu.ustb.cbwstc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class Pic extends JFrame {

	private JPanel contentPane;
	private String picName = "CBWSTC_WorkSpace/Projects/ExpenseReimbursementSystem/Graph/graphP.png";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pic frame = new Pic();
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
	public Pic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon icon = new ImageIcon(picName);
		Image image1 = icon.getImage();
		JPanel jPanel1 = new JPanel(){  
		    @Override  
		    public void paint(Graphics g) {  
		        super.paint(g); 
		        
				if(image1 != null){  
		            g.clearRect(0, 0, this.getWidth(), this.getHeight());  
		            g.drawImage(image1, 0, 0, null);  
		            g.dispose();  
		        }  
		    }  
		};
		jPanel1.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));  
		jPanel1.updateUI();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 414, 242);
		scrollPane.setViewportView(jPanel1); 
		contentPane.add(scrollPane);
		
	}
}
