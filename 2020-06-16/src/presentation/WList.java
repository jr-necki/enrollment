package presentation;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import service.SHakgwa;
import valueObject.VGangjwa;
import valueObject.VHakgwa;

public class WList extends JPanel implements MouseListener, ListDataListener {
	JPanel listPanel = new JPanel();

	SHakgwa sCampus = new SHakgwa();
	SGangjwa sGangjwa = new SGangjwa();
	Vector<VHakgwa> vData;

	String fileName = "root";
	DefaultListModel<String> m = new DefaultListModel<>();
	DefaultListModel<String> m1 = new DefaultListModel<>();
	DefaultListModel<String> m2 = new DefaultListModel<>();
	DefaultListModel<String> m3 = new DefaultListModel<>();
	DefaultListModel<String> m4 = new DefaultListModel<>();

	JList lCampus = new JList(m);
	JList lCollege = new JList(m1);
	JList lHakgwa = new JList(m2);
	JList lGangjwa = new JList(m3);

	String c = "";
	String coll = "";
	String h = "";

	TitledBorder b = new TitledBorder(new LineBorder(Color.black));
	TitledBorder b1 = new TitledBorder(new LineBorder(Color.blue), "강좌목록");
	ArrayList<JList> lists = new ArrayList<JList>();
	private Color color2 = new Color(209, 228, 251);
	private Color color = new Color(4, 20, 74);
	
	WBasket basket;
	WEnrollment enroll;

	public WList(WBasket basket,WEnrollment enroll) {
		this.basket=basket;
		this.enroll=enroll;
		
		this.setBackground(Color.white);
		lists.add(lCampus);
		lists.add(lCollege);
		lists.add(lHakgwa);
		lists.add(lGangjwa);

		vData = sCampus.getData(fileName);
		findFile(fileName, m);
		lCampus.setBorder(b);
		listPanel.add(lCampus);

		for (JList l : lists) {
			l.setBackground(Color.white);
			l.addMouseListener(this);
			listPanel.add(l);
		}
		this.add(listPanel);
		this.setVisible(true);

	}


	public void findFile(String fileName, DefaultListModel<String> m) {
		Vector<VHakgwa> vData = sCampus.getData(fileName);
		if (vData != null) {
			for (VHakgwa vDatum : vData) {
				m.addElement(vDatum.getText());
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getComponent().equals(lCampus)) {
			m1.removeAllElements();
			m2.removeAllElements();
			m3.removeAllElements();
			fileName = "root";
			String a = lCampus.getSelectedValue().toString();
			vData = sCampus.getData(fileName);
			for (VHakgwa vDatum : vData) {
				if (vDatum.getText().equals(a)) {
					fileName = vDatum.getFileName();
					this.c = fileName;
					findFile(fileName, m1);
					lCollege.setBorder(b);
					listPanel.add(lCollege);
				}
			}

		} else if (e.getComponent().equals(lCollege)) {
			fileName = c;
			m2.removeAllElements();
			m3.removeAllElements();
			String a = lCollege.getSelectedValue().toString();
			System.out.println(a);
			vData = sCampus.getData(fileName);
			for (VHakgwa vDatum : vData) {
				if (vDatum.getText().equals(a)) {
					fileName = vDatum.getFileName();
					this.coll = fileName;
					findFile(fileName, m2);
					lHakgwa.setBorder(b);
					listPanel.add(lHakgwa);
				}
			}

		} else if (e.getComponent().equals(lHakgwa)) {
			fileName = coll;
			m3.removeAllElements();
			String a = lHakgwa.getSelectedValue().toString();
			vData = sCampus.getData(fileName);
			for (VHakgwa vDatum : vData) {
				if (vDatum.getText().equals(a)) {
					fileName = vDatum.getFileName();
					this.h = fileName;

					Vector<VGangjwa> vData2 = sGangjwa.getData(fileName);
					if (vData2 != null) {
						for (VGangjwa vDatum2 : vData2) {
							m3.addElement(vDatum2.getId() + " " + vDatum2.getGangjwaName() + " "
									+ vDatum2.getGyosuName() + " " + vDatum2.getHakjeom() + " " + vDatum2.getTime());
							m3.addListDataListener(this);
						}

					}
					lGangjwa.setBorder(b1);
					listPanel.add(lGangjwa);
				}

			}
		}
		if (e.getClickCount() == 2) {
			if (e.getComponent().equals(lGangjwa)) {
				String[] a = lGangjwa.getSelectedValue().toString().split(" ");
				 String id = a[0];
				Vector<VGangjwa> vData2 = sGangjwa.getData(fileName);
				System.out.println(fileName);
				for (VGangjwa vDatum2 : vData2) {
					if (vDatum2.getId().equals(id)) {
						try {
							this.enroll.getInfo(vDatum2);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}
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

		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {// 오른쪽 마우스 눌렀을 때만 반응해라
			if (e.getComponent().equals(lGangjwa)) {
				if(lGangjwa.getSelectedValue().toString()==null) {
					JOptionPane.showMessageDialog(null, "강좌를 선택하세요!", "Alert", JOptionPane.WARNING_MESSAGE);
				}else {
					System.out.println(lGangjwa.getSelectedValue().toString());
					String[] a = (lGangjwa.getSelectedValue().toString()).split(" ");
					String id = a[0];
					Vector<VGangjwa> vData2 = sGangjwa.getData(fileName);
					for (VGangjwa vDatum2 : vData2) {
						if (vDatum2.getId().equals(id)) {
							this.basket.getInfo(vDatum2);

						}
					}
				}
				
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void contentsChanged(ListDataEvent arg0) {
	}

	@Override
	public void intervalAdded(ListDataEvent e) {

	}

	@Override
	public void intervalRemoved(ListDataEvent e) {

	}
}
