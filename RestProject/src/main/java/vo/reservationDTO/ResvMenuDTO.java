package vo.reservationDTO;

import java.sql.Date;



/*
 * CREATE TABLE RESERVATION_MENU(
revMID Nvarchar(20) primary key//예약 메뉴 아이디
cosMENU Nvarchar(50) not null,//코스 이름//
revDETAIL Nvarchar(200),///코스 설명//
revSTATUS VARCHAR(1) NOT NULL, //Y판매 가능 상태 N불가능한상태//
revDATE date,//관리자가 메뉴 올린날짜/
image Nvarchar(100) not null
)

 *   
 * */


public class ResvMenuDTO {
	private String menuID ; //메뉴 id 코스
	private String category ; //카테고리
	private String menuNAME ; //메뉴명
	private String menuDETAIL ; //상세정보
	private String m_status ; //예약 가능한상태
	private int resvPRICE; // 예약금
	private Date resvORDERDATE ;  // 주문한 시간
	private String resvDATE; //예약 요일
	private String image ;
	
	
	
	
	private int quantity;
	
	//생성자
	public ResvMenuDTO() {} // 매개값없는 생성자도 까먹지말기

	
	//필요한 생성자 생성
	
	//메뉴 add 시 필요한 예약시간 뺀 생성자 생성
	
	
	public ResvMenuDTO(String menuID, String category, String menuNAME, String menuDETAIL, String m_status,
			int resvPRICE, String image) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.menuDETAIL = menuDETAIL;
		this.m_status = m_status;
		this.resvPRICE = resvPRICE;
		this.image = image;
	}
	


	public ResvMenuDTO(String menuID, String category, String menuNAME, int resvPRICE, String resvDATE) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.resvPRICE = resvPRICE;
		this.resvDATE =  resvDATE;
	}


	public ResvMenuDTO(String menuID, String category, String menuNAME, int resvPRICE,  String resvDATE,
			int quantity) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.resvPRICE = resvPRICE;
		this.resvDATE =  resvDATE;
		this.quantity = quantity;
	}


	public ResvMenuDTO(String menuID, String category, String menuNAME, int resvPRICE, 
			int quantity) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.resvPRICE = resvPRICE;
	
		this.quantity = quantity;
	}

	
	
	
	
	



	public ResvMenuDTO(String menuID, String category, String menuNAME, String menuDETAIL, String m_status,
			int resvPRICE, Date resvORDERDATE, String image) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.menuDETAIL = menuDETAIL;
		this.m_status = m_status;
		this.resvPRICE = resvPRICE;
		this.resvORDERDATE = resvORDERDATE;

		this.image = image;
	}






	public ResvMenuDTO(String menuID, String category, String menuNAME, String menuDETAIL, String m_status,
			int resvPRICE, Date resvORDERDATE,  String image, int quantity) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.menuDETAIL = menuDETAIL;
		this.m_status = m_status;
		this.resvPRICE = resvPRICE;
		this.resvORDERDATE = resvORDERDATE;

		this.image = image;
		this.quantity = quantity;
	}





	public ResvMenuDTO(String menuID, String category, String menuNAME, String menuDETAIL, String m_status,
			int resvPRICE, Date resvORDERDATE, String resvDATE, String image, int quantity) {
		super();
		this.menuID = menuID;
		this.category = category;
		this.menuNAME = menuNAME;
		this.menuDETAIL = menuDETAIL;
		this.m_status = m_status;
		this.resvPRICE = resvPRICE;
		this.resvORDERDATE = resvORDERDATE;
		this.resvDATE = resvDATE;
		this.image = image;
		this.quantity = quantity;
	}





	public String getMenuID() {
		return menuID;
	}





	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public String getMenuNAME() {
		return menuNAME;
	}





	public void setMenuNAME(String menuNAME) {
		this.menuNAME = menuNAME;
	}





	public String getMenuDETAIL() {
		return menuDETAIL;
	}





	public void setMenuDETAIL(String menuDETAIL) {
		this.menuDETAIL = menuDETAIL;
	}





	public String getM_status() {
		return m_status;
	}





	public void setM_status(String m_status) {
		this.m_status = m_status;
	}





	public int getResvPRICE() {
		return resvPRICE;
	}





	public void setResvPRICE(int resvPRICE) {
		this.resvPRICE = resvPRICE;
	}





	public Date getResvORDERDATE() {
		return resvORDERDATE;
	}





	public void setResvORDERDATE(Date resvORDERDATE) {
		this.resvORDERDATE = resvORDERDATE;
	}








	public String getImage() {
		return image;
	}





	public void setImage(String image) {
		this.image = image;
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public String getResvDATE() {
		return resvDATE;
	}


	public void setResvDATE(String resvDATE) {
		this.resvDATE = resvDATE;
	}






	
	
	
	
	////////////////////////////////////////////////////////////////

	
}
