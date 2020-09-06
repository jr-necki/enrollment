package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WMain extends JFrame {
	private static final long serialVersionUID=1L;
	private WImage wImage;
	private WInput wInput;
	private WBottom wBottom;
	private boolean isLogin=false;
	
	public WMain() {
		this.setLocation(100,80);
		this.setSize(500,606);
		this.getContentPane().setBackground(Color.white);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		this.wImage=new WImage();
		this.add(this.wImage);
		this.wInput=new WInput(this);
		this.add(this.wInput);
		this.wBottom=new WBottom();
		this.add(this.wBottom);
		this.setVisible(true);
		
	}



}
