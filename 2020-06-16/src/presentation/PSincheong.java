package presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import valueObject.VGangjwa;

public class PSincheong {

	public PSincheong() {
		// TODO Auto-generated constructor stub
	}

	public void put(VGangjwa g) {
		try {
			File file = new File("Enrolments/gangjwa");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println(g.getId());
			printWriter.println(g.getGangjwaName());
			printWriter.println(g.getGyosuName());
			printWriter.println(g.getHakjeom());
			printWriter.println(g.getTime());
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
