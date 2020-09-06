package presentation;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.MPersonalInfo;
import service.SPersonalInfo;
import valueObject.VPersonalInfo;

public class WPersonalInfo extends JPanel implements MouseListener {
	private JLabel lbNo = new JLabel("학번");
	private JLabel lbName = new JLabel("이름");
	private JLabel lbID = new JLabel(" ID");
	private JLabel lbPW = new JLabel("PW");
	private JLabel lbPhoto=new JLabel("사진등록");
	String filePath="";
	private JLabel imageLabel=new JLabel();
	private JButton btnCheck;

	private JTextField tfNo = new JTextField(10);
	private JTextField tfName = new JTextField(10);
	private JTextField tfID = new JTextField(10);
	private JPasswordField tfPW = new JPasswordField(10);
	private JLabel l=new JLabel("      회                원               가              입                       ");
	
	private JLabel l1 = new JLabel("                                                ");
	private JLabel l2 = new JLabel("                                                ");
	private JLabel l3 = new JLabel("                  ");
	private JLabel l4 = new JLabel("                                               ");

	ArrayList<JPanel> panels = new ArrayList<>();
	ArrayList<JLabel> labels = new ArrayList<>();
	ArrayList<JTextField> t = new ArrayList<>();
	
	
	private Color color = new Color(4, 20, 74);
	private Color color2 = new Color(209, 228, 251);
	private JButton btnSelect=new JButton("사진 찾아보기");
	private JButton btnJoin;
	
	JFileChooser chooser;
	MPersonalInfo mPersonalInfo;
	

	public WPersonalInfo() {
		l.setBackground(color);
		l.setForeground(Color.white);
		this.add(l);
		this.setBackground(color);
		
		JPanel p=new JPanel();
		panels.add(p);
		
		JPanel p1 = new JPanel();
		p1.add(lbNo);
		p1.add(tfNo);
		t.add(tfNo);
		p1.add(this.l1);

		JPanel p2 = new JPanel();
		p2.add(lbName);

		p2.add(tfName);
		t.add(tfName);
		p2.add(this.l2);

		JPanel p3 = new JPanel();
		p3.add(lbID);
		p3.add(tfID);
		t.add(tfID);
		btnCheck = new JButton("중복확인");
		btnCheck.setBackground(Color.white);
		btnCheck.addMouseListener(this);
		p3.add(btnCheck);
		p3.add(l3);

		JPanel p4 = new JPanel();
		p4.add(lbPW);
		p4.add(tfPW);
		t.add(tfPW);
		p4.add(this.l4);
		
		JPanel p5=new JPanel();
		imageLabel.setIcon(new ImageIcon("img/default.png"));
		p5.add(imageLabel);
		btnSelect.setBackground(Color.white);
		btnSelect.addMouseListener(this);
		p5.add(btnSelect);
		
		JPanel p6=new JPanel();
		
		
		
		JPanel p7=new JPanel();
		this.btnJoin=new JButton("가입하기");
		this.btnJoin.addMouseListener(this);
		btnJoin.setBackground(color);
		btnJoin.setForeground(Color.white);
		p7.add(btnJoin);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panels.add(p1);
		panels.add(p2);
		panels.add(p3);
		panels.add(p4);
		panels.add(p5);
		panels.add(p6);
		panels.add(p7);
		
		for (JPanel a : panels) {
			a.setBackground(Color.white);
			this.add(a);
		}
		for(JTextField j: t) {
			j.addMouseListener(this);
			
		}
		
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(btnCheck)) {
			this.mPersonalInfo=new MPersonalInfo();
			if(mPersonalInfo.read(tfID.getText())!=null) {
				JOptionPane.showMessageDialog(null, "이미 있는 ID 입니다",
						"Fail", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "사용 가능한 ID 입니다!",
						"Success", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getComponent().equals(btnJoin)) {
			if(tfNo.getText()!=""&&tfName.getText()!=""&&tfID.getText()!=""&&tfPW.getText()!="") {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.No=tfNo.getText();
				vPersonalInfo.name=tfName.getText();
				vPersonalInfo.id=tfID.getText();
				vPersonalInfo.password=tfPW.getText();
				SPersonalInfo sPersonalInfo = new SPersonalInfo();
				sPersonalInfo.write(vPersonalInfo);	
				JOptionPane.showMessageDialog(null, tfName.getText() + "님 가입되셨습니다!",
						"Success", JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "모두 입력하세요!",
						"Fail", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}else if(e.getComponent().equals(btnSelect)) {
			this.chooser=new JFileChooser();
			FileNameExtensionFilter filter=new FileNameExtensionFilter("JPG&GIF Images","jpg","gif");
			chooser.setFileFilter(filter);
			
			int ret=chooser.showOpenDialog(null);
			if(ret!=JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				this.filePath="img/default.png";
				imageLabel.setIcon(new ImageIcon(filePath));
			}else {
				this.filePath=chooser.getSelectedFile().getPath();
				imageLabel.setIcon(new ImageIcon(filePath));
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getComponent().equals(tfNo)) {
			this.tfNo.setBackground(color2);
		}else if(e.getComponent().equals(tfName)) {
			this.tfName.setBackground(color2);
		}else if(e.getComponent().equals(tfID)) {
			this.tfID.setBackground(color2);
		}else if(e.getComponent().equals(tfPW)) {
			this.tfPW.setBackground(color2);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for(JTextField j: t) {
			j.setBackground(Color.white);
		}
		
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
