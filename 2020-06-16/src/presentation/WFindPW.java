package presentation;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WFindPW extends JFrame{
	private static final long serialVersionUID=1L;
	private WInfo wInfo;
	private JPanel p;
	private Color color = new Color(4, 20, 74);
	
	public WFindPW() {
		this.setLocation(120,100);
		this.setSize(400,220);
		this.getContentPane().setBackground(Color.white);
		p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		this.wInfo=new WInfo();
		p.add(this.wInfo);
		this.add(p);
		 setVisible(true);
	}

}
