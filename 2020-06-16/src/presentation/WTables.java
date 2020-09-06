package presentation;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import valueObject.VPersonalInfo;

public class WTables extends JPanel{
	WBasket wBasket;
	WEnrollment wEnroll;

	public WTables(VPersonalInfo vPersonalInfo) {
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(1,2,5,5));
		this.wEnroll=new WEnrollment(vPersonalInfo);
		this.wBasket=new WBasket(vPersonalInfo,this.wEnroll);

		
		
		this.add(wBasket);
		this.add(wEnroll);
	}

}
