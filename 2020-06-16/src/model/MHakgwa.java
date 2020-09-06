package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VHakgwa;

public class MHakgwa {
	public MHakgwa() {
		
	}

	public Vector<VHakgwa> getData(String fileName) {
		
		Vector<VHakgwa> vCampus = null;
		try {
			File file = new File("data/" + fileName);
			Scanner scanner = new Scanner(file);
			
			vCampus = new Vector<VHakgwa>();
			while(scanner.hasNext()) {
				VHakgwa vData = new VHakgwa();
				// read
				vData.setId(scanner.nextInt());
				vData.setText(scanner.next());
				vData.setFileName(scanner.next());
				vCampus.add(vData);
			}			
			scanner.close();		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vCampus;
	}

}
