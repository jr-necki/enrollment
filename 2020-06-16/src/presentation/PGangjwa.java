package presentation;

import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class PGangjwa {
	VGangjwa g;

	public PGangjwa() {
		// TODO Auto-generated constructor stub
	}

	public String show(Scanner scanner, String fileName) {
		System.out.println("선택해 주십시오");
		SGangjwa sGangjwa=new SGangjwa();
		Vector<VGangjwa> vData=sGangjwa.getData(fileName);
		if(vData !=null) {
			for(VGangjwa vDatum: vData) {
				System.out.println(vDatum.getId()+" "+vDatum.getGangjwaName()+" "+vDatum.getGyosuName()+" "+vDatum.getHakjeom()+" "+vDatum.getTime());	
			}
			System.out.println("입력 : ");
			int selection=scanner.nextInt();
			
//			for(VGangjwa vDatum: vData) {
//				if(vDatum.getId()==selection) {
//					this.g=new VGangjwa();
//					g=vDatum;
//					return vDatum.getGangjwaName();
//				}
		//	}
		}
		
		return null;
	}

	public VGangjwa showGangjwa() {
		
		return g ;
	}

}
