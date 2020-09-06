package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.SLogin;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class WLogin extends JPanel implements MouseListener {
	private JLabel lbID = new JLabel("ID");
	private JLabel lbPW = new JLabel("PW");
	private JTextField tfID = new JTextField(10);
	private JPasswordField tfPW = new JPasswordField(10);
	private Color color = new Color(209, 228, 251);
	JOptionPane jOptionPane = new JOptionPane();
	WMain wMain;
	
	JButton btnLogin;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	VLoginInfo vLoginInfo = new VLoginInfo();
	boolean isLogin = false;

	public WLogin(WMain wMain) {
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(1, 1, 7, 7));
		p.setBackground(Color.white);

		tfID.addMouseListener(this);
		tfPW.addMouseListener(this);
		p1.setLayout(new GridLayout(2, 2, 2, 2));
		p1.setBackground(Color.white);
		p1.add(lbID);
		p1.add(tfID);
		p1.add(lbPW);
		p1.add(tfPW);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.white);
		btnLogin.setSize(10, 15);
		btnLogin.addMouseListener(this);
		p2.add(btnLogin);
		p2.setBackground(Color.white);

		p.add(p1);
		p.add(p2);
		this.add(p);
		
		this.wMain=wMain;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().equals(btnLogin)) {
			this.vLoginInfo.id = tfID.getText();
			this.vLoginInfo.password = tfPW.getText();

			SLogin sLogin = new SLogin();
			VPersonalInfo vPersonalInfo = sLogin.validate(vLoginInfo);
			if (vPersonalInfo != null) {
				this.jOptionPane.showMessageDialog(null, "로그인 완료!", "Success", JOptionPane.WARNING_MESSAGE);
				this.isLogin=true;
				isLogin(vPersonalInfo);

			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패!", "Fail", JOptionPane.WARNING_MESSAGE);

			}
		}

	}

	private void isLogin(VPersonalInfo vPersonalInfo) {
		if(isLogin) {
			this.wMain.dispose();
			WMain2 wMain2=new WMain2(vPersonalInfo);
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent().equals(tfID)) {
			this.tfID.setBackground(color);
		} else if (e.getComponent().equals(tfPW)) {
			this.tfPW.setBackground(color);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.tfID.setBackground(Color.white);
		this.tfPW.setBackground(Color.white);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
