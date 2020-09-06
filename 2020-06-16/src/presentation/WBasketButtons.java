package presentation;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import service.SBasket;
import valueObject.VGangjwa;

public class WBasketButtons extends JPanel implements MouseListener {
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();

	private Image moveImg = null;
	private ImageIcon moveimgIcon;
	private Image moveImg2 = null;
	private ImageIcon moveimgIcon2;

	private Image removeImg = null;
	private ImageIcon removeimgIcon;
	private Image removeImg2 = null;
	private ImageIcon removeimgIcon2;

	private Image clearImg = null;
	private ImageIcon clearimgIcon;
	private Image clearImg2 = null;
	private ImageIcon clearimgIcon2;

	WBasket wBasket;
	WEnrollment wEnroll;
	
	public WBasketButtons(WBasket wBasket, WEnrollment wEnroll) {
		this.wBasket = wBasket;
		this.wEnroll=wEnroll;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);

		try {
			File sourceImage = new File("img/right.png");
			File sourceImage2 = new File("img/right2.png");

			File sourceImage3 = new File("img/remove.png");
			File sourceImage4 = new File("img/remove2.png");

			File sourceImage5 = new File("img/garbage.png");
			File sourceImage6 = new File("img/garbage2.png");

			moveImg = ImageIO.read(sourceImage);
			moveimgIcon = new ImageIcon((Image) moveImg);
			moveImg2 = ImageIO.read(sourceImage2);
			moveimgIcon2 = new ImageIcon((Image) moveImg2);

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

		btn1.setBackground(Color.white);
		btn1.setIcon(moveimgIcon);
		btn1.addMouseListener(this);

		btn2.setBackground(Color.white);
		btn2.setIcon(removeimgIcon);
		btn2.addMouseListener(this);

		btn3.setBackground(Color.white);
		btn3.setIcon(clearimgIcon);
		btn3.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SBasket sBasket = new SBasket();
		boolean find=false;
		if (e.getComponent().equals(btn1)) {
			int n = wBasket.table.getSelectedRow();
			if (n == -1) {
				JOptionPane.showMessageDialog(null, "선택된 강좌가 없습니다!", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				String target = wBasket.model.getValueAt(n, 0).toString();
				System.out.println("타겟: " + target);
				
				for(int i=0;i<wEnroll.model.getRowCount();i++) {
					if((wEnroll.model.getValueAt(i,0).toString()).equals(target)) {
						
						JOptionPane.showMessageDialog(null, "이미 수강신청 했습니다!", "Error", JOptionPane.WARNING_MESSAGE);
						find=true;
					}
				}
				if(!find) {
					VGangjwa vData=sBasket.moveGangjwa(wBasket.vPersonalInfo, target);

					wBasket.model.removeRow(n);
					wEnroll.model.addRow(new Object[] { vData.getId(), vData.getGangjwaName(), vData.getGyosuName(),
							vData.getHakjeom(), vData.getTime() });
					wBasket.lb2.setText("총 학점: "+Integer.toString(wBasket.total()));
				}
				
			}
		} else if (e.getComponent().equals(btn2)) {
			int n = wBasket.table.getSelectedRow();
			if (n == -1) {
				JOptionPane.showMessageDialog(null, "선택된 강좌가 없습니다!", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				System.out.println("삭제");
				String target = wBasket.model.getValueAt(n, 0).toString();
				System.out.println("타겟: " + target);

				sBasket.removeGangjwa(wBasket.vPersonalInfo, target);

				wBasket.model.removeRow(n);
				wBasket.lb2.setText("총 학점: "+Integer.toString(wBasket.total()));

			}
		} else if (e.getComponent().equals(btn3)) {
			sBasket.clear(wBasket.vPersonalInfo);
			wBasket.model.setNumRows(0);
			wBasket.lb2.setText("총 학점: "+Integer.toString(wBasket.total()));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent().equals(btn1)) {
			btn1.setIcon(moveimgIcon2);
		} else if (e.getComponent().equals(btn2)) {
			btn2.setIcon(removeimgIcon2);
		} else {
			btn3.setIcon(clearimgIcon2);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent().equals(btn1)) {
			btn1.setIcon(moveimgIcon);
		} else if (e.getComponent().equals(btn2)) {
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
