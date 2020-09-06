package presentation;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import valueObject.VPersonalInfo;

public class WCenterPanel extends JPanel {
	WTables wTables;
	WList wList;

	public WCenterPanel(VPersonalInfo vPersonalInfo) {
		this.setBackground(Color.white);
		
		this.wTables=new WTables(vPersonalInfo);
		this.wList=new WList(wTables.wBasket,wTables.wEnroll);
		
		this.setLayout(new GridLayout(2,1,5,5));
		 this.add(wList);this.add(wTables);
		
	}

}
