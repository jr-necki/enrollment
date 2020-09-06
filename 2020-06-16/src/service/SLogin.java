package service;
import model.MPersonalInfo;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class SLogin {

	public SLogin() {
	}

	public VPersonalInfo validate(VLoginInfo vLoginInfo) {
		
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		VPersonalInfo vPersonalInfo = mPersonalInfo.read(vLoginInfo.id);
		
		if (vPersonalInfo == null) {
			return null;
		} else {
			if (vLoginInfo.password.equals(vPersonalInfo.password)) {
				return vPersonalInfo;
			} else {
				return null;
			}
		}
	}
}
