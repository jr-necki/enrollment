package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import service.SBasket;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class WBasket extends JPanel {
	JLabel lb = new JLabel("미리담기");
	JLabel lb2 = new JLabel("총 학점: ");

	JTable table;
	JButton btn = new JButton();
	String header[] = { "id", "강좌명", "교수이름", "학점", "시간" };
	String contents[][];

	VPersonalInfo vPersonalInfo;
	JPanel panel = new JPanel();
	DefaultTableModel model;
	JOptionPane jOptionPane = new JOptionPane();
	
	WBasketButtons wBasketButtons;
	WEnrollment wEnroll;

	public WBasket(VPersonalInfo vPersonalInfo, WEnrollment wEnroll) {
		this.wEnroll=wEnroll;
		wBasketButtons=new WBasketButtons(this,wEnroll);
		this.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		panel.add(lb);

		this.vPersonalInfo = vPersonalInfo;
		int i = 0;
		// 파일정보가지고 테이블넣기
		SBasket sBasket = new SBasket();
		Vector<VGangjwa> tGangjwa = sBasket.getData(vPersonalInfo);
		contents = new String[tGangjwa.size()][5];
		String s = "";
		for (VGangjwa v : tGangjwa) {
			contents[i][0] = v.getId();
			contents[i][1] = v.getGangjwaName();
			contents[i][2] = v.getGyosuName();
			
			contents[i][3] = v.getHakjeom();
			contents[i][4] = v.getTime();
			i++;
		}
		this.model = new DefaultTableModel(contents, header);
		this.table = new JTable(model);
		this.table.setPreferredScrollableViewportSize(new Dimension(500, 150));
		JScrollPane scrollpane = new JScrollPane(table);

		
		lb.setBackground(Color.white);
		lb.setBackground(Color.white);

		panel.add(BorderLayout.CENTER, scrollpane);
		panel.add(BorderLayout.NORTH, lb);
		panel.add(BorderLayout.EAST, wBasketButtons);
		panel.add(BorderLayout.SOUTH,lb2);
		this.add(panel);
		
		lb2.setText("총 학점: "+Integer.toString(total()));

	}

	public int total() {
		int sum=0;
		for(int i=0;i<this.model.getRowCount();i++) {
			sum+=Integer.parseInt(model.getValueAt(i,3).toString());
		}
		return sum;
	}

	public void getInfo(VGangjwa vData) {
		SBasket sBasket = new SBasket();
		Vector<VGangjwa> tGangjwa = sBasket.getData(vPersonalInfo);
		boolean check = true;

		for (VGangjwa v : tGangjwa) {
			if (v.getId().equals(vData.getId())) {
				check = false;
				this.jOptionPane.showMessageDialog(null, "이미 동일한 강좌가 있습니다!", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (check) {
			// s-m-파일에 저장
			sBasket = new SBasket(vData, this.vPersonalInfo);
			this.model.addRow(new Object[] { vData.getId(), vData.getGangjwaName(), vData.getGyosuName(),
					vData.getHakjeom(), vData.getTime() });
			lb2.setText(Integer.toString(total()));

		}

	}
}
