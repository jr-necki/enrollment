package presentation;

import java.util.Scanner;

import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class PSugangsincheong {

	public PSugangsincheong() {

	}

	public void show(Scanner scanner, VPersonalInfo vPersonalInfo) {
		System.out.println(vPersonalInfo.name + "님!, 안녕하세요. ");
		String fileName = "root";

		System.out.println("다음 메뉴를 선택 하세요");
		boolean finished = false;
		while (!finished) {
			System.out.println("1:검색, 2:종료");
			System.out.print("입력: ");
			int selection = scanner.nextInt();
			if (selection == 3) {
				finished = true;
			} else {
				PHakgwa pCampus = new PHakgwa();
				fileName = pCampus.show(scanner, fileName);

				PHakgwa pCollege = new PHakgwa();
				fileName = pCollege.show(scanner, fileName);

				PHakgwa pHakgwa = new PHakgwa();
				fileName = pHakgwa.show(scanner, fileName);

				PGangjwa pGangjwa = new PGangjwa();
				fileName = pGangjwa.show(scanner, fileName);

				System.out.println("미리담기 1   수강신청 2");
				selection = scanner.nextInt();
				if (selection == 1) {
					PMiridamgi pMiridamgi = new PMiridamgi();
					pMiridamgi.put(pGangjwa.g);

				} else if (selection == 2) {
					PSincheong pSincheong = new PSincheong();
					pSincheong.put(pGangjwa.g);
					
				}
				fileName = "root";

			}
		}
	}
}
