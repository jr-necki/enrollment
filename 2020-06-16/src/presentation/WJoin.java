package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WJoin extends JFrame {
	private static final long serialVersionUID=1L;
	private WPersonalInfo wPersonalInfo;
	private JPanel p;
	public WJoin() {
		this.setLocation(120,100);
		this.setSize(500,530);
		this.getContentPane().setBackground(Color.white);
		p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		this.wPersonalInfo=new WPersonalInfo();
		p.add(this.wPersonalInfo);
		this.add(p);
		setVisible(true);
	}
	

}
