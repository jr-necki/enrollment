package presentation;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import service.SEnroll;

public class WEnrollButtons extends JPanel implements MouseListener {
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();

	private Image removeImg = null;
	private ImageIcon removeimgIcon;
	private Image removeImg2 = null;
	private ImageIcon removeimgIcon2;

	private Image clearImg = null;
	private ImageIcon clearimgIcon;
	private Image clearImg2 = null;
	private ImageIcon clearimgIcon2;

	// WBasket wBasket;
	WEnrollment wEnroll;

	public WEnrollButtons(WEnrollment wEnrollment) {
		// this.wBasket = wBasket;
		this.wEnroll = wEnrollment;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(btn2);
		this.add(btn3);

		try {
			File sourceImage3 = new File("img/remove.png");
			File sourceImage4 = new File("img/remove2.png");

			File sourceImage5 = new File("img/garbage.png");
			File sourceImage6 = new File("img/garbage2.png");

			removeImg = ImageIO.read(sourceImage3);
			removeimgIcon = new ImageIcon((Image) removeImg);
			removeImg2 = ImageIO.read(sourceImage4);
			removeimgIcon2 = new ImageIcon((Image) removeImg2);

			clearImg = ImageIO.read(sourceImage5);
			clearimgIcon = new ImageIcon((Image) clearImg);
			clearImg2 = ImageIO.read(sourceImage6);
			clearimgIcon2 = new ImageIcon((Image) clearImg2);

		} catch (IOException e) {
			System.out.println("이미지 파일이 없다");
		}

		btn2.setBackground(Color.white);
		btn2.setIcon(removeimgIcon);
		btn2.addMouseListener(this);

		btn3.setBackground(Color.white);
		btn3.setIcon(clearimgIcon);
		btn3.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SEnroll sEnroll = new SEnroll();
		if (e.getComponent().equals(btn2)) {
			int n = wEnroll.table.getSelectedRow();
			if (n == -1) {
				JOptionPane.showMessageDialog(null, "선택된 강좌가 없습니다!", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				int result=JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					
				}else if(result==JOptionPane.YES_OPTION) {
					String target = wEnroll.model.getValueAt(n, 0).toString();
					System.out.println("타겟: " + target);

					sEnroll.removeGangjwa(wEnroll.vPersonalInfo, target);

					wEnroll.model.removeRow(n);
					wEnroll.lb2.setText("총 학점: "+Integer.toString(wEnroll.total()));
				}
	
			}
		} else if (e.getComponent().equals(btn3)) {
			sEnroll.clear(wEnroll.vPersonalInfo);
			wEnroll.model.setNumRows(0);
			wEnroll.lb2.setText("총 학점: "+Integer.toString(wEnroll.total()));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent().equals(btn2)) {
			btn2.setIcon(removeimgIcon2);
		} else {
			btn3.setIcon(clearimgIcon2);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		 if (e.getComponent().equals(btn2)) {
			btn2.setIcon(removeimgIcon);
		} else {
			btn3.setIcon(clearimgIcon);
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
