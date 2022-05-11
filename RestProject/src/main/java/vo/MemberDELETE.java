package vo;

public class MemberDELETE {
	// 멤버변수
	private String mID;
	private String mPW;
	
	
	
	
	
	
	
	//기본생성자 
	public MemberDELETE() {
		
	}
	
	
	
	
	
	
	// 매게 변수 있는 생성자 
	
	public MemberDELETE(String mID, String mPW) {
		super();
		this.mID = mID;
		this.mPW = mPW;
		
	}



	//프라이빗 멤버변수라 가져올때 게터세터로
	
	
	

	public String getmID() {
		return mID;
	}











	public void setmID(String mID) {
		this.mID = mID;
	}






	public String getmPW() {
		return mPW;
	}






	public void setmPW(String mPW) {
		this.mPW = mPW;
	}








	
	
	
	
	
	
	
	
}
