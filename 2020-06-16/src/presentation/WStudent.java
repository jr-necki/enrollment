package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import valueObject.VPersonalInfo;

public class WStudent extends JPanel {
	private Image img = null;
	private JLabel label;
	private Color color = new Color(4, 20, 74);
	TitledBorder b1 = new TitledBorder(new LineBorder(color));
	
	public WStudent(VPersonalInfo vPersonalInfo) {
		this.setLayout(new FlowLayout());
		
		try {
			File file=new File(vPersonalInfo.id+"/img");
			Scanner scanner=new Scanner(file);
			String fileName=scanner.next();
			
			File sourceImage = new File(fileName);
			img = ImageIO.read(sourceImage);
		} catch (IOException e) {
			System.out.println("이미지 파일이 없다");
		}
		init();
		
	
		this.add(label);
		this.add(new JLabel(vPersonalInfo.name+" "+vPersonalInfo.No));
		this.setBackground(Color.white);

	}

	private void init() {
		this.label = new JLabel(new ImageIcon(img));
		this.label.setBorder(b1);
		
		
	}

}
