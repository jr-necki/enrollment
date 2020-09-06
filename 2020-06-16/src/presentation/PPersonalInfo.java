package presentation;
import java.util.Scanner;

import service.SPersonalInfo;
import valueObject.VPersonalInfo;

// presentation 
public class PPersonalInfo {

	public PPersonalInfo() {
	}

	public void show(Scanner scanner) {
		System.out.println("개인정보 입력 하세요.");
		
		// new valueObject
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		
		System.out.print("아이디 입력 하세요: ");
		vPersonalInfo.id = scanner.next();
		
		System.out.print("패스워드 입력 하세요: ");
		vPersonalInfo.password = scanner.next();
		
		System.out.print("이름 입력 하세요: ");
		vPersonalInfo.name = scanner.next();

		// service
		SPersonalInfo sPersonalInfo = new SPersonalInfo();
		sPersonalInfo.write(vPersonalInfo);	
	}

}
