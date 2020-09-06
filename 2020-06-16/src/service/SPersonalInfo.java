package service;
import model.MPersonalInfo;
import valueObject.VPersonalInfo;

public class SPersonalInfo {

	public SPersonalInfo() {
		// TODO Auto-generated constructor stub
	}

	public void write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		
		mPersonalInfo.write(vPersonalInfo);
		mPersonalInfo.makeFolder(vPersonalInfo);
	
	}

}
