package vo;

public class MemberPwChange {
	//멤버 변수
	private String mID;
	private String pre_password;
	private String new_password;
	
	
	//매개값없는 기본생성자 필수
	
	public MemberPwChange() {
		
	}


	public MemberPwChange(String mID, String pre_password, String new_password) {
		super();
		this.mID = mID;
		this.pre_password = pre_password;
		this.new_password = new_password;
	}


	public String getmID() {
		return mID;
	}


	public void setmID(String mID) {
		this.mID = mID;
	}


	public String getPre_password() {
		return pre_password;
	}


	public void setPre_password(String pre_password) {
		this.pre_password = pre_password;
	}


	public String getNew_password() {
		return new_password;
	}


	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	
	
	
	
	
	
	
	
	
	
}
