package presentation;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WImage extends JPanel implements MouseListener {
	private Image img = null;
	private JLabel label;

	public WImage() {

		try {
			File sourceImage = new File("img/mju2.png");
			img = ImageIO.read(sourceImage);
		} catch (IOException e) {
			System.out.println("이미지 파일이 없다");
		}
		init();
		
		this.add(label);
		this.setBackground(Color.white);
		this.addMouseListener(this);

	}

	private void init() {
		this.label = new JLabel(new ImageIcon(img));
		
	}

	public void openUrl(String url) {
		String os = System.getProperty("os.name");
		Runtime runtime = Runtime.getRuntime();
		try {
			// Block for Windows Platform
			if (os.startsWith("Windows")) {
				String cmd = "rundll32 url.dll,FileProtocolHandler " + url;
				Process p = runtime.exec(cmd);
			}
		} catch (Exception x) {
			System.err.println("Exception occurd while invoking Browser!");
			x.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		 openUrl("https://www.mju.ac.kr/sites/mjukr/intro/intro.html");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setToolTipText("홈페이지로...");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
