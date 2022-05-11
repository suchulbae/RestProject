package vo;



public class MemberDTO {
	
	
	
	/* 아래 6개는 회원가입 폼에 있음 */
	private String mID;
	private String mGRADE; /*회원가입 폼에서 숨김 - 첫 회원가입때 hidden으로 Normal값 전달 */
	private String mPW;
	private String mNAME;
	private String mEMAIL;
	private String mPHONE;
	
	/* 아래 3개는 회원가입 폼에 없음 */
	private String mRDATE;
	private int mQUANTITY; /* 향후 삭제 예정*/
	private int mODERMONEY; /* 향후 삭제 예정*/
	
	// 기본생성자 : (암호화하는 방법중 1번째 방법사용)
	public MemberDTO() {
		super();
	}
	// 생성자 추가
	public MemberDTO(String mID, String mGRADE, String mPW, String mNAME, String mEMAIL, String mPHONE) {
		super();
		this.mID = mID;
		this.mGRADE = mGRADE;
		this.mPW = mPW;
		this.mNAME = mNAME;
		this.mEMAIL = mEMAIL;
		this.mPHONE = mPHONE;
	}
	
	public MemberDTO(String mID, String mNAME, String mEMAIL, String mPHONE) {
		super();
		this.mID = mID;

		this.mNAME = mNAME;
		this.mEMAIL = mEMAIL;
		this.mPHONE = mPHONE;
	}
	
	
	//직접접근이 불가능해  get set으로
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getmGRADE() {
		return mGRADE;
	}
	public void setmGRADE(String mGRADE) {
		this.mGRADE = mGRADE;
	}
	public String getmPW() {
		return mPW;
	}
	public void setmPW(String mPW) {
		this.mPW = mPW;
	}
	public String getmNAME() {
		return mNAME;
	}
	public void setmNAME(String mNAME) {
		this.mNAME = mNAME;
	}
	public String getmEMAIL() {
		return mEMAIL;
	}
	public void setmEMAIL(String mEMAIL) {
		this.mEMAIL = mEMAIL;
	}
	public String getmPHONE() {
		return mPHONE;
	}
	public void setmPHONE(String mPHONE) {
		this.mPHONE = mPHONE;
	}
	public String getmRDATE() {
		return mRDATE;
	}
	public void setmRDATE(String mRDATE) {
		this.mRDATE = mRDATE;
	}
	public int getmQUANTITY() {
		return mQUANTITY;
	}
	public void setmQUANTITY(int mQUANTITY) {
		this.mQUANTITY = mQUANTITY;
	}
	public int getmODERMONEY() {
		return mODERMONEY;
	}
	public void setmODERMONEY(int mODERMONEY) {
		this.mODERMONEY = mODERMONEY;
	}
	
	
	
	
	
	

	

}


