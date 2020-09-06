package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import valueObject.VPersonalInfo;

public class WHeader extends JPanel implements ActionListener, Runnable {
	JLabel info;
	JLabel logo;
	JButton btnLogOut=new JButton("·Î±×¾Æ¿ô");
	JLabel lbTime=new JLabel("");
	ArrayList<JButton> btns=new ArrayList<JButton>();
	WMain2 m2;
	
	private Image img = null;
	private Image img2 = null;
	private JLabel label;
	private Color color = new Color(4, 20, 74);
	TitledBorder b1 = new TitledBorder(new LineBorder(color));
	
	private Thread thread;
	
	public WHeader(WMain2 wMain2, VPersonalInfo vPersonalInfo) {
		
		if(thread==null) {
			thread=new Thread(this);
			thread.start();
		}
		
		this.setBackground(Color.white);
		this.setBorder(b1);
		
		this.m2=wMain2;
		this.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		this.info=new JLabel(vPersonalInfo.name+" "+vPersonalInfo.No);
		try {
			File file=new File(vPersonalInfo.id+"/img");
			File logoFile=new File("data/logo.jpg");
			
			img2=ImageIO.read(logoFile);
			init();
			
		} catch (IOException e) {
			
		}
		this.add(logo);
		this.add(new JLabel("                                                                                                    "));
		this.add(info);
		btns.add(btnLogOut);
		for(JButton b:btns) {
			b.setBackground(Color.white);
			b.addActionListener(this);
			this.add(b);
			}
		this.lbTime.setBackground(color);
		//this.lbTime.setForeground(Color.white);
		this.add(lbTime);
		}
	private void init() {
		
		this.logo=new JLabel(new ImageIcon(img2));
	}
	public void run() {
		while(true) {
			Calendar cal=Calendar.getInstance();
			String now=
			cal.get(Calendar.HOUR)+":"+
			cal.get(Calendar.MINUTE)+":"+
			cal.get(Calendar.SECOND);
			
			this.lbTime.setText(now);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("·Î±×¾Æ¿ô")) {
			this.m2.dispose();
			WMain wMain=new WMain();
		}
		
	}

}
