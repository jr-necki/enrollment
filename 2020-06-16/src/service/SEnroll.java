package service;

import java.io.IOException;
import java.util.Vector;

import model.MBasket;
import model.MEnroll;
import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class SEnroll {
	public SEnroll() {
		// TODO Auto-generated constructor stub
	}

	public SEnroll(VGangjwa vData, VPersonalInfo vPersonalInfo) {
		MEnroll mEnroll=new MEnroll();
		try {
			mEnroll.write(vData,vPersonalInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<VGangjwa> getData(VPersonalInfo vPersonalInfo){
		MEnroll mEnroll=new MEnroll();
		return mEnroll.read(vPersonalInfo);
	}

	public void removeGangjwa(VPersonalInfo vPersonalInfo, String target) {
		MEnroll mEnroll=new MEnroll();
		mEnroll.removeGangjwa(vPersonalInfo,target);
	}

	public void clear(VPersonalInfo vPersonalInfo) {
		MEnroll mEnroll=new MEnroll();
		mEnroll.clear(vPersonalInfo);
		
	}

	public VGangjwa moveGangjwa(VPersonalInfo vPersonalInfo, String target) {
		MEnroll mEnroll=new MEnroll();
		return mEnroll.move(vPersonalInfo,target);
	}

}
