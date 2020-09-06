package presentation;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WFindID extends JFrame {
	private static final long serialVersionUID=1L;
	private WNoName wNoName;
	private JPanel p;
	private Color color = new Color(4, 20, 74);
	
	public WFindID() {
		this.setLocation(120,100);
		this.setSize(400,200);
		this.getContentPane().setBackground(Color.white);
		p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		this.wNoName=new WNoName();
		p.add(this.wNoName);
		this.add(p);
		 setVisible(true);
	}

}
