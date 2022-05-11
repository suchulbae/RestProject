package vo.reservationDTO;

import java.util.Date;

public class ResvOrder {

	private int order_num;/*주문 번호*/
	private String mID;/*주문한 사용자의 id*/
	private String mEMAIL;
	private Date resvORDERDATE;/*주문한 날짜(하루매출조회)*/
	private String order_status;
	private int totalMoney;
	private String resvDATE; //예약 요일

	
	
	
	
	
	
	
	
	
	
	public ResvOrder() {};
	
	
	
	
	

	
	
	
	
	
	
	// 생성자
	
	public ResvOrder( int totalMoney,Date resvORDERDATE) {
		super();
		this.totalMoney = totalMoney;
		this.resvORDERDATE = resvORDERDATE;
	
	}












	public ResvOrder(int order_num, String mID, String mEMAIL, Date resvORDERDATE, String order_status, int totalMoney,
			String resvDATE) {
		
		this.order_num = order_num;
		this.mID = mID;
		this.mEMAIL = mEMAIL;
		this.resvORDERDATE = resvORDERDATE;
		this.order_status = order_status;
		this.totalMoney = totalMoney;
		this.resvDATE = resvDATE;
	}
























	public ResvOrder(int order_num, String mID, String mEMAIL, Date resvORDERDATE, int totalMoney, String resvDATE) {
		super();
		this.order_num = order_num;
		this.mID = mID;
		this.mEMAIL = mEMAIL;
		this.resvORDERDATE = resvORDERDATE;
		this.totalMoney = totalMoney;
		this.resvDATE = resvDATE;
	}












	public int getOrder_num() {
		return order_num;
	}












	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}












	public String getmID() {
		return mID;
	}












	public void setmID(String mID) {
		this.mID = mID;
	}












	public String getmEMAIL() {
		return mEMAIL;
	}












	public void setmEMAIL(String mEMAIL) {
		this.mEMAIL = mEMAIL;
	}












	public Date getResvORDERDATE() {
		return resvORDERDATE;
	}












	public void setResvORDERDATE(Date resvORDERDATE) {
		this.resvORDERDATE = resvORDERDATE;
	}












	public String getOrder_status() {
		return order_status;
	}












	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}












	public int getTotalMoney() {
		return totalMoney;
	}












	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}












	public String getResvDATE() {
		return resvDATE;
	}












	public void setResvDATE(String resvDATE) {
		this.resvDATE = resvDATE;
	}





























	
	
	
}
