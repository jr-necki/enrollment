package presentation;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WMove extends JPanel{
	JButton btn1;
	JButton btn2;
	private Image img = null;
	private ImageIcon imgIcon;
	private Image img2 = null;
	private ImageIcon imgIcon2;

	public WMove() {
		this.setBackground(Color.white);
		this.btn1=new JButton();
		this.btn2=new JButton();
		try {
			File sourceImage = new File("data/right.png");
			img = ImageIO.read(sourceImage);
			imgIcon = new ImageIcon((Image)img);
			
			File sourceImage2 = new File("data/left.png");
			img2 = ImageIO.read(sourceImage2);
			imgIcon2 = new ImageIcon((Image)img2);
			
			

		} catch (IOException e) {
			System.out.println("이미지 파일이 없다");
		}
		btn1.setIcon(imgIcon);
		btn2.setIcon(imgIcon2);
		btn1.setBackground(Color.white);btn2.setBackground(Color.white);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(btn1); this.add(btn2);
	}

}
