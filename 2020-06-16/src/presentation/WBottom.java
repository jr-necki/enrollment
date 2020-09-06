package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WBottom extends JPanel implements MouseListener {
	private Color color = new Color(4, 20, 74);

	ArrayList<JLabel> labels = new ArrayList<>();
	JLabel pJoin = new JLabel("                      회원가입                               ");
	JLabel pFindID = new JLabel("ID찾기                                        ");
	JLabel pFindPW = new JLabel("PW찾기                   ");

	public WBottom() {

		labels.add(pJoin);
		labels.add(pFindID);
		labels.add(pFindPW);
		for (JLabel l : labels) {
			l.setBackground(color);
			l.setForeground(Color.white);
			l.addMouseListener(this);
			this.add(l);

		}
		this.setBackground(color);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(pJoin)) {
			WJoin wJoin=new WJoin();
		}else if(e.getComponent().equals(pFindID)) {
			WFindID wFindID=new WFindID();
		}else if(e.getComponent().equals(pFindPW)) {
			WFindPW wFindPW=new WFindPW();
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

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
