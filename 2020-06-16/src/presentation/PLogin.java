package presentation;
import java.util.Scanner;

import service.SLogin;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class PLogin {

	public PLogin() {
	}

	public VPersonalInfo show(Scanner scanner) {
		System.out.println("로그인 ");
		
		// new valueObject
		VLoginInfo vLoginInfo = new VLoginInfo();
		System.out.print("아이디: ");
		vLoginInfo.id = scanner.next();
		System.out.print("패스워드: ");
		vLoginInfo.password = scanner.next();

		// service
		SLogin sLogin = new SLogin();
		VPersonalInfo vPersonalInfo = sLogin.validate(vLoginInfo);
		
		return vPersonalInfo;

	}
}
