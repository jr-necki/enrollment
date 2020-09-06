package presentation;

import java.util.Vector;

import model.MGangjwa;
import valueObject.VGangjwa;

public class SGangjwa {

	public SGangjwa() {
		// TODO Auto-generated constructor stub
	}

	public Vector<VGangjwa> getData(String fileName) {
		MGangjwa mGangjwa=new MGangjwa();
		
		return mGangjwa.getData(fileName);
	}

}
