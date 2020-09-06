package service;

import java.io.IOException;
import java.util.Vector;

import model.MBasket;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class SBasket {
	public SBasket() {
	}

	public SBasket(VGangjwa vData, VPersonalInfo vPersonalInfo) {
		MBasket mBasket=new MBasket();
		try {
			mBasket.write(vData,vPersonalInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<VGangjwa> getData(VPersonalInfo vPersonalInfo){
		MBasket mBasket=new MBasket();
		return mBasket.read(vPersonalInfo);
	}
	public void removeGangjwa(VPersonalInfo vPersonalInfo, String target) {
		MBasket mBasket=new MBasket();
		mBasket.removeGangjwa(vPersonalInfo,target);
	}

	public void clear(VPersonalInfo vPersonalInfo) {
		MBasket mBasket=new MBasket();
		mBasket.clear(vPersonalInfo);
		
	}

	public VGangjwa moveGangjwa(VPersonalInfo vPersonalInfo, String target) {
		MBasket mBasket=new MBasket();
		
		return mBasket.move(vPersonalInfo,target);
	}
}
