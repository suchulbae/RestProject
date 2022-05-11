package vo.reservationDTO;

public class ReservationDelete {
	private int order_num;
	private String resvDATE;
	
	
	
	
	
	public	ReservationDelete() {
		
	}





	public ReservationDelete(int order_num, String resvDATE) {
		super();
		this.order_num = order_num;
		this.resvDATE = resvDATE;
	}





	public int getOrder_num() {
		return order_num;
	}





	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}





	public String getResvDATE() {
		return resvDATE;
	}





	public void setResvDATE(String resvDATE) {
		this.resvDATE = resvDATE;
	}
	
	
	
	
	
	
	
	
	
}
