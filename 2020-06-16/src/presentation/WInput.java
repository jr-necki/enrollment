package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class WInput extends JPanel {
	 WLogin wLogin;

	public WInput(WMain wMain) {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.white);
		this.wLogin=new WLogin(wMain);
		this.add(wLogin);
	}

	

}
