package presentation;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MPersonalInfo;

public class WInfo extends JPanel implements ActionListener{
	private JLabel lbNo = new JLabel("학번");
	private JLabel lbName = new JLabel("이름");
	private JLabel lbID = new JLabel("I D   ");
	
	private JTextField tfNo = new JTextField(10);
	private JTextField tfName = new JTextField(10);
	private JTextField tfID = new JTextField(10);
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	
	private JButton btnPW;
	private Color color = new Color(4, 20, 74);
	private Image img = null;
	private ImageIcon imgIcon;
	private JLabel l;
	MPersonalInfo mPersonalInfo=new MPersonalInfo();
	
	public WInfo() {
		l=new JLabel("                   p            w          찾              기     ");
		l.setBackground(color);
		l.setForeground(Color.white);
		this.add(l);
		this.setBackground(color);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		p1.add(lbNo); p1.add(tfNo);
		p2.add(lbName);p2.add(tfName);
		p3.add(lbID);p3.add(tfID);
		
		
		this.btnPW = new JButton();
		try {
			File sourceImage = new File("img/search.png");
			img = ImageIO.read(sourceImage);
			imgIcon = new ImageIcon((Image) img);

		} catch (IOException e) {
			System.out.println("이미지 파일이 없다");
		}
		btnPW.setBorderPainted(false);
		btnPW.setIcon(imgIcon);
		btnPW.setBackground(color);
		btnPW.addActionListener(this);
		p4.add(btnPW);
		this.add(p1); this.add(p2);this.add(p3);this.add(p4);
		lbNo.setBackground(Color.white);tfNo.setBackground(Color.white);
		lbName.setBackground(Color.white);tfName.setBackground(Color.white);
		lbID.setBackground(Color.white);tfID.setBackground(Color.white);
		
		this.setBackground(color);
		p1.setBackground(Color.white);p2.setBackground(Color.white);
		p3.setBackground(Color.white);p4.setBackground(color);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnPW)){
			if(mPersonalInfo.read(tfNo.getText())!=null) {
				if(mPersonalInfo.read(tfName.getText())!=null) {
					if(mPersonalInfo.read(tfID.getText())!=null) {
						JOptionPane.showMessageDialog(null,"PW: "+ mPersonalInfo.read(tfName.getText()).password,
								"Success", JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null,"없는 ID 입니다",
								"Success", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"없는 이름 입니다",
							"Success", JOptionPane.WARNING_MESSAGE);
				}
				}
			}else {
				JOptionPane.showMessageDialog(null,"없는학번 입니다",
						"Success", JOptionPane.WARNING_MESSAGE);
			}
	}

}
