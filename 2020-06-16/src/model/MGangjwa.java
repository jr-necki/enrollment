package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;
import valueObject.VHakgwa;

public class MGangjwa {
	public MGangjwa() {
		
	}

	public Vector<VGangjwa> getData(String fileName) {
		
		Vector<VGangjwa> vGangjwas = null;
		try {
			File file = new File("data/" + fileName);
			Scanner scanner = new Scanner(file);
			
			vGangjwas = new Vector<VGangjwa>();
			while(scanner.hasNext()) {
				VGangjwa vGangjwa = new VGangjwa();
				// read
				vGangjwa.setId(scanner.next());
				vGangjwa.setGangjwaName(scanner.next());
				vGangjwa.setGyosuName(scanner.next());
				vGangjwa.setHakjeom(scanner.next());
				vGangjwa.setTime(scanner.next());
				vGangjwas.add(vGangjwa);
			}			
			scanner.close();		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vGangjwas;
	}

}
