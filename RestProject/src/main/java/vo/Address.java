package vo;

public class Address { //주소관리 DTO
	private String mID;
	
	private int postcode;
	
	private String address1;
	private String address2;
	
	public Address() {
		super();
	}
	
	public Address(int postcode, String address1, String address2) {
		super();
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
	}

	public Address(String mID, int postcode, String address1, String address2) {
		super();
		this.mID = mID;
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
	}

	public String getmID() {
		return mID;
	}

	public void setmID(String mID) {
		this.mID = mID;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	
	
	
}
