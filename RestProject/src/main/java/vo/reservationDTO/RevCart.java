package vo.reservationDTO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class RevCart {
	private String menuID;
	private String category;
	private String menuNAME ;
	private int resvPRICE;
	private Date resvORDERDATE;
	private String resvDATE ; //예약 요일
	private String image ;
	private int qty;
	
	private String encoding_menuID;
	
	public String getEncoding_menuID() {
		
		try {
			encoding_menuID=URLEncoder.encode("menuID","UTF-8");
			
		}catch(UnsupportedEncodingException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encoding_menuID;
		
		
		
		
		
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setEncoding_menuID(String encoding_menuID) {
		this.encoding_menuID = encoding_menuID;
	}

	public String getResvDATE() {
		return resvDATE;
	}

	public void setResvDATE(String resvDATE) {
		this.resvDATE = resvDATE;
	}

		
	
	
	
}
