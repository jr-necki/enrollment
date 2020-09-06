package presentation;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import valueObject.VPersonalInfo;

public class WMain2 extends JFrame {
	WHeader wHeader;
	WCenterPanel wCenter;
	WBelow wBelow;
	public WMain2(VPersonalInfo vPersonalInfo) {
		this.setLocation(0,0);
		this.setSize(1200,700);
		this.setBackground(Color.white);
		this.wHeader=new WHeader(this,vPersonalInfo);
		this.wCenter=new WCenterPanel(vPersonalInfo);
		this.wBelow=new WBelow();
		BorderLayout b=new BorderLayout();
		
		this.setLayout(b);
		this.add(wHeader,b.NORTH);
		this.add(wCenter,b.CENTER);
		this.add(wBelow,b.SOUTH);
		this.setVisible(true);
		
		this.pack();
	}
}
