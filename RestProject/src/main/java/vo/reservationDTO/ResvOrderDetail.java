package vo.reservationDTO;

public class ResvOrderDetail {
	private int datail_index;
	private String menuID; /* 메뉴 id */
	private int order_num; /* 주문 번호 */
	private int quantity; /* 주문 수량 */
	private String menuNAME; /* 메뉴명 */
	private int resvPRICE; /* 메뉴 가격 */
	private String resvDATE; /* 메뉴 가격 */
	
	
	
	public ResvOrderDetail(int datail_index, String menuID, int order_num, int quantity, String menuNAME) {
		super();
		this.datail_index = datail_index;
		this.menuID = menuID;
		this.order_num = order_num;
		this.quantity = quantity;
		this.menuNAME = menuNAME;
	}



	public ResvOrderDetail(int datail_index, String menuID, int order_num, int quantity, String menuNAME, int resvPRICE,
			String resvDATE) {
		super();
		this.datail_index = datail_index;
		this.menuID = menuID;
		this.order_num = order_num;
		this.quantity = quantity;
		this.menuNAME = menuNAME;
		this.resvPRICE = resvPRICE;
		this.resvDATE = resvDATE;
	}



	public int getDatail_index() {
		return datail_index;
	}



	public void setDatail_index(int datail_index) {
		this.datail_index = datail_index;
	}



	public String getMenuID() {
		return menuID;
	}



	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}



	public int getOrder_num() {
		return order_num;
	}



	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getMenuNAME() {
		return menuNAME;
	}



	public void setMenuNAME(String menuNAME) {
		this.menuNAME = menuNAME;
	}



	public int getResvPRICE() {
		return resvPRICE;
	}



	public void setResvPRICE(int resvPRICE) {
		this.resvPRICE = resvPRICE;
	}



	public String getResvDATE() {
		return resvDATE;
	}



	public void setResvDATE(String resvDATE) {
		this.resvDATE = resvDATE;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
