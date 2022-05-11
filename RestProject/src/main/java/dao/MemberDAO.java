package dao;

import static db.JdbcUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import vo.Address;
import vo.MemberDELETE;
import vo.MemberDTO;
import vo.MemberPwChange;
import vo.reservationDTO.ReservationDelete;
import vo.reservationDTO.ResvMenuDTO;
import vo.reservationDTO.ResvOrder;
import vo.reservationDTO.ResvOrderDetail;







public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private MemberDAO() {}

	private static MemberDAO memberDAO;// 반드시 static이여야 한다.

	public static MemberDAO getInstance() {
		if (memberDAO == null) {//없을때 생성
			memberDAO = new MemberDAO();
		}

		return memberDAO;// 기존 memberDAO리턴
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(MemberDTO member) {
		String loginId = null;

		
		String sql = "SELECT mID, mPW FROM MEMBER WHERE mID = ? AND mPW=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getmID());//구문객체에 넣어서
			pstmt.setString(2, member.getmPW());
			rs = pstmt.executeQuery(); //결과값으로 변경

			if (rs.next()) { // resultSet에 정보가있으면
				
				
				
				
				loginId = rs.getString("mID");// db에 저장된 내용 을 loginId 에 담는다

			} // if문 끝
		} catch (Exception e) {
			 System.out.println("selectLoginId INFO 에러 : " + e );
		} finally {
			// JdbcUtil.close(rs);
			// JdbcUtil.close(pstmt);
			close(rs);
			close(pstmt);

		}

		return loginId;
	}
	// ID 로 MEMBER 정보 조회
	public MemberDTO getMemberInfo(String mID) { 
		MemberDTO memberInfo = null;
		
String sql = "SELECT * FROM MEMBER WHERE mID = '" + mID +"'"; // [방법 2]
		
		try {
			pstmt = con.prepareStatement(sql); // prepareStatement 객체생성 
			
		

			rs = pstmt.executeQuery(); // 실행
			
			if(rs.next()) { // sql문에서 insert한 값이 1개라도 있으면
				memberInfo = new MemberDTO(); // 기본값으로 채워짐
				
				memberInfo.setmID(rs.getString("mID")); // 객체에 SQL결과로 반환받은 회원정보로 값 설정
				memberInfo.setmGRADE(rs.getString("mGRADE"));
				memberInfo.setmNAME(rs.getString("mNAME"));
				memberInfo.setmEMAIL(rs.getString("mEMAIL"));
				memberInfo.setmPHONE(rs.getString("mPHONE"));
				
			
			} // if문 끝
			
		} catch (Exception e) {
			System.out.println("getMEMBERInfo 에러 : " + e); // e: 예외종류 + 예외 메세지
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberInfo;
	}

	public int getLastMonthMoney(String mID) {
			int LastMonthMoney = 0;//기본값 0원
			String sql = "select SUM(totalmoney) from orderTable  "
					+ "where mID=? AND YEAR(order_date) = YEAR(now())  "
					+ "AND MONTH(order_date) = MONTH(now())-1 AND order_status ='get'" ; // MONTH(now())-1 : 지난달 
			          // 주문한 날짜(2022-2-15, 2022-3-1, 2022-3-30)의 달과 오늘 날짜(2022-4-4)의 달(4)-1을 비교하여 같으면
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,mID);
				
				rs= pstmt.executeQuery();
				if(rs.next()) {
					LastMonthMoney=rs.getInt("SUM(totalmoney)");
				}
				
				
			}catch(Exception e){
				System.out.println("getLastMonthMoney"+e);
			}finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			
			
		return LastMonthMoney;
	}

		public int upGrade(MemberDTO member) { // static에 절대올리면안됨
		int gradeCount =0; //업데이트 성공여부
		String sql= "update MEMBER set mGRADE='VIP' where mID=? ";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,member.getmID());
			
			gradeCount=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("upGrade 에러 : " + e);
		}finally {
			close(pstmt);
		}
		
		return gradeCount;
	
	

	
}
		
		
		public int upGradeVVIP(MemberDTO member) { // static에 절대올리면안됨
		int gradeCount =0; //업데이트 성공여부
		String sql= "update MEMBER set mGRADE='VVIP' where mID=? ";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,member.getmID());
			
			gradeCount=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("upGrade 에러 : " + e);
		}finally {
			close(pstmt);
		}
		
		return gradeCount;
	
	

	
}
		// 사용자의 등급을 'Normal'로 다운
		public int downGrade(MemberDTO member) {
			int gradeCount = 0; // 업데이트 성공여부 (0: 실패, 1 : 성공)
			
			String sql = "UPDATE MEMBER SET mGRADE = 'Familly' WHERE mID = ?";
			
			try {
				pstmt = con.prepareStatement(sql); // prepareStatement 객체생성 
				
				pstmt.setString(1, member.getmID());

				gradeCount = pstmt.executeUpdate(); // 업데이트에 성공하면 1을 리턴받음
				
				
			} catch (Exception e) {
				System.out.println("[]downGrade 에러 : " + e); // e: 예외종류 + 예외 메세지
			}finally {
				// close(rs);
				close(pstmt);
			}
			
			return gradeCount;
		}

		
		
		
		

		public MemberDTO findId(String mEMAIL) {
			
			MemberDTO memberInfo=null;
			String sql= "SELECT * FROM MEMBER WHERE mEMAIL='"+mEMAIL+"'";
			try {
				pstmt =con.prepareStatement(sql);
				rs =pstmt.executeQuery();
				
				if(rs.next()) {
					memberInfo = new MemberDTO(); // 기본값으로 채워진 객체에
					memberInfo.setmID(rs.getString("mID")); // 조회한 id값 셋팅
					memberInfo.setmEMAIL(rs.getString("mEMAIL"));
				}
				
				
				
				
			}catch (Exception e) {
				System.out.println("memberDAO findID에러 :"+e);
			}finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			
			return memberInfo;
		}

		public double selectSaleRate(String mGRADE) {
			double saleRate = 1.0;
			String sql = "SELECT SALERATE FROM GRADE WHERE mGRADE =?";
			try {
				pstmt = con.prepareStatement(sql); // prepareStatement 객체생성 
				pstmt.setString(1, mGRADE);
				rs = pstmt.executeQuery(); // 실행
			
				if(rs.next()) {
					saleRate = rs.getInt("salerate")/100.0; //기본 
				
				} // if문 끝
				
			} catch (Exception e) {
				System.out.println("[Member DAO]selectSaleRate 에러 : " + e); // e: 예외종류 + 예외 메세지
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return saleRate;
		}

		public MemberDTO findHashPw(String mID, String mEMAIL) {
			MemberDTO memberInfo=null;
			
			String sql = "SELECT * FROM MEMBER WHERE mID =? AND mEMAIL = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mID);
				pstmt.setString(2, mEMAIL);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					memberInfo = new MemberDTO(); 
					
					// 조회한 id값을 셋팅
					memberInfo.setmID(mID);
					memberInfo.setmEMAIL(mEMAIL);
					memberInfo.setmNAME(rs.getString("mNAME")); // 매개로 받은게 없기때문에조회한 값 셋팅
				
				}
				
			}catch (Exception e) {
				System.out.println("[MAMBERDAO]findHashPw 에러 : " + e); // e: 예외종류 + 예외 메세지
				
			}finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			
			return memberInfo;
		}

		public int setHashPw(String mID, String mEMAIL,String random_password) {
			
			
			int setHashPwCount = 0; // 업데이트 성공여부 (0: 실패, 1 : 성공)
			

			String sql = "UPDATE MEMBER SET mPW = ? WHERE mID = ? AND mEMAIL = ?";
			
		try {
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, random_password);
			pstmt.setString(2, mID);
			pstmt.setString(3, mEMAIL);
			
		
			setHashPwCount = pstmt.executeUpdate(); // 업데이트에 성공하면 1을 리턴받음
		
		
		}catch(Exception e) {
			System.out.println("MemberDAO setHashPw 에러"+ e);
		}finally {
	 // update는 rs를 사용안했기때문에 close()해줄 필요 없음 (select에서는 해줘야함)
			close(pstmt);
		}
			
			
			
			return setHashPwCount;
		}

		public int changeHashPw(MemberPwChange memberPwChange) {
			int changePwCount = 0;
			
			String sql = "UPDATE MEMBER SET mPW = ? WHERE mID = ? AND mPW = ?";
			
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, memberPwChange.getNew_password());
				pstmt.setString(2,memberPwChange.getmID());
				pstmt.setNString(3, memberPwChange.getPre_password());
				changePwCount = pstmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("memberDAO changeHashPw"+e);
			}finally {
				close(pstmt);
			}
			
			
			
			
			
			
			
			
			return changePwCount;
		}

		public int insertMember(MemberDTO member) {
			 int insertMemberCount = 0;
			 
			 String sql = "INSERT INTO MEMBER(mID, mGRADE, mPW, mNAME, mEMAIL, mPHONE, mRDATE) "
			 		+ "VALUES(?, ?, ?, ?, ?, ?, NOW())";
			 
			 try {
				 
				 pstmt= con.prepareStatement(sql);
				 pstmt.setString(1, member.getmID());
				 pstmt.setString(2, member.getmGRADE());
				 pstmt.setString(3, member.getmPW());
				 pstmt.setString(4, member.getmNAME());
				 pstmt.setString(5, member.getmEMAIL());
				 pstmt.setString(6, member.getmPHONE());
				 
				 insertMemberCount = pstmt.executeUpdate();
				 
			 }catch(Exception e) {
				 System.out.println("[MemberDAO]insertUser 에러 : " + e);
			 }finally {
					// close(rs); // insert는 rs를 사용안했기때문에 close()해줄 필요 없음 (select에서는 해줘야함)
					close(pstmt);
				}
			 
			 
			 
			return insertMemberCount;
		}

		public int insertAddr(Address addr) {
			int insertAddrCount = 0;
			String sql = "INSERT INTO ADDRESS(mID, POSTCODE, ADDRESS1, ADDRESS2) VALUES(?, ?, ?, ?)";
			
			try {

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, addr.getmID());
				pstmt.setInt(2, addr.getPostcode());
				pstmt.setString(3, addr.getAddress1());
				pstmt.setString(4, addr.getAddress2());
				
				insertAddrCount = pstmt.executeUpdate();
				
			}catch (Exception e) {
				System.out.println("[memberDAO]insertAddr 에러 : " + e); // e: 예외종류 + 예외 메세지
			}finally {
				// close(rs); // insert는 rs를 사용안했기때문에 close()해줄 필요 없음 (select에서는 해줘야함)
				close(pstmt);
			}
			
			return insertAddrCount;
		}

		public int deleteMember(MemberDELETE memberdelete) {
			 int deletememberCount = 0;//삭제 성공여부
			
			 String sql =  "DELETE from MEMBER WHERE mID = ? AND mPW= ?"; //조건에 mID mPW 만족 시키는 사람 삭제
			
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,memberdelete.getmID() );
			    pstmt.setString(2, memberdelete.getmPW());
			
				
				
				deletememberCount =pstmt.executeUpdate(); // 성공할시 1리턴
				
			}catch(Exception e) {
				System.out.println("deleteMember 오류" +e);
			}finally {
				close(pstmt);
			}
			
			
			
			return deletememberCount;
		}

		public MemberDTO selectMemberInfo(String viewId) {
			MemberDTO memberInfo=null;
			
			String sql = "SELECT * FROM MEMBER WHERE mID ='" + viewId + "'" ;
			
			try {
				pstmt = con.prepareStatement(sql);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					memberInfo = new MemberDTO();
					
					
					memberInfo.setmID(rs.getString("mID"));
					memberInfo.setmGRADE(rs.getString("mGRADE"));
					memberInfo.setmNAME(rs.getString("mNAME"));
					memberInfo.setmEMAIL(rs.getString("mEMAIL"));
					memberInfo.setmPHONE(rs.getString("mPHONE"));
			
					
					
					
					
				}
				
				
				
			}catch(Exception e) {
				System.out.println("select member info error"+e);
			}finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			
			
			return memberInfo;
		}

		public Address selectMemberAddrInfo(String viewId) {
			Address memberAddrInfo=null;

			
			String sql = "SELECT * FROM ADDRESS WHERE mID ='" + viewId + "'" ;
			
			try {
				pstmt = con.prepareStatement(sql);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					memberAddrInfo = new Address();
					
					
					memberAddrInfo.setmID(rs.getString("mID"));
					memberAddrInfo.setPostcode(rs.getInt("postcode"));
					memberAddrInfo.setAddress1(rs.getString("address1"));
					memberAddrInfo.setAddress2(rs.getString("address2"));
					
			
					
					
					
					
				}
				
				
				
			}catch(Exception e) {
				System.out.println("select memberADDR info error"+e);
			}finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			
			
			
			
			
			return memberAddrInfo;
		}

		public int updateMember(MemberDTO member) {
			int updateMemberCount=0;
			String sql = "UPDATE MEMBER SET mNAME=?,mEMAIL=?,mPHONE=?"
					+ "where mID=?";
			try {
				 pstmt= con.prepareStatement(sql);
			
	
				 pstmt.setString(1, member.getmNAME());
				 pstmt.setString(2, member.getmEMAIL());
				 pstmt.setString(3, member.getmPHONE());
				 pstmt.setString(4, member.getmID());
				 
				 updateMemberCount = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("updateMember error"+e);
			}finally {
				//JdbcUtil.close(rs);
				//JdbcUtil.close(pstmt);
				close(pstmt);
			}
			
			
			
			return updateMemberCount;
		}

		public int updateAddr(Address addr) {
			int updateAddrCount=0;
			String sql = "UPDATE ADDRESS SET postcode=?,address1=?,address2=?"
					+ "where mID=?";
			try {
				 pstmt= con.prepareStatement(sql);
			
	
				 pstmt.setInt(1, addr.getPostcode());
				 pstmt.setString(2, addr.getAddress1());
				 pstmt.setString(3, addr.getAddress2());
			
				 pstmt.setString(4, addr.getmID());
				 
				 updateAddrCount = pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("updateAddrCount error"+e);
			}finally {
				//JdbcUtil.close(rs);
				//JdbcUtil.close(pstmt);
				close(pstmt);
			}
			
			
			
			return updateAddrCount;
		}

		public ArrayList<ResvMenuDTO> selectReservationMenuList() {
			ArrayList<ResvMenuDTO> resvMenuList = null;
			
			String sql = "SELECT * FROM RESERVATION_MENU WHERE category='Course'";
			
			try {
				 pstmt= con.prepareStatement(sql);
				 rs	= pstmt.executeQuery();
				
				
				if(rs.next()){
				
				
					resvMenuList=new ArrayList<ResvMenuDTO>();
					do {
						//결과값 담기 
						resvMenuList.add(new ResvMenuDTO(
							rs.getString("menuID"),
							rs.getString("category"),
							rs.getString("menuNAME"),
							rs.getString("menuDETAIL"),
							rs.getString("m_status"),
							rs.getInt("resvPRICE"),
							rs.getDate("resvORDERDATE"),
						
							rs.getString("image")
						                 ));
							
						
			
						
						
						
					}while(rs.next());
					
				
			} // if() end
					
		} catch (SQLException e) {
			System.out.println("selectReservationMenuList 에러: " + e); // e: 예외종류 + 에외 메시지
		} finally {
		
			close(rs);
			close(pstmt);
		}
		
		return resvMenuList;
	}

		public ArrayList<ResvMenuDTO> selectReservationMenu2List() {
ArrayList<ResvMenuDTO> resvMenuList2 = null;
			
			String sql = "SELECT * FROM RESERVATION_MENU WHERE category='PREMIUMSIDES'";
			
			try {
				 pstmt= con.prepareStatement(sql);
				 rs	= pstmt.executeQuery();
				
				
				if(rs.next()){
				
				
					resvMenuList2=new ArrayList<ResvMenuDTO>();
					do {
						//결과값 담기 
						resvMenuList2.add(new ResvMenuDTO(
							rs.getString("menuID"),
							rs.getString("category"),
							rs.getString("menuNAME"),
							rs.getString("menuDETAIL"),
							rs.getString("m_status"),
							rs.getInt("resvPRICE"),
							rs.getDate("resvORDERDATE"),
						
							rs.getString("image")
						                 ));
							
				
						
						
						
					}while(rs.next());
					
				
			} // if() end
					
		} catch (SQLException e) {
			System.out.println("selectReservationMenuList 에러: " + e); // e: 예외종류 + 에외 메시지
		} finally {
		
			close(rs);
			close(pstmt);
		}
		
		return resvMenuList2;
		}

		public ArrayList<ResvMenuDTO> selectReservationMenu3List() {
ArrayList<ResvMenuDTO> ResvMenuList3 = null;
			
			String sql = "SELECT * FROM RESERVATION_MENU WHERE category='SALAD'";
			
			try {
				 pstmt= con.prepareStatement(sql);
				 rs	= pstmt.executeQuery();
				
				
				if(rs.next()){
				
				
					ResvMenuList3=new ArrayList<ResvMenuDTO>();
					do {
						//결과값 담기 
					ResvMenuDTO resvMenuDTO = new ResvMenuDTO(
							rs.getString("menuID"),
							rs.getString("category"),
							rs.getString("menuNAME"),
							rs.getString("menuDETAIL"),
							rs.getString("m_status"),
							rs.getInt("resvPRICE"),
							rs.getDate("resvORDERDATE"),
							
						
							rs.getString("image")
						                 );
							
						
					ResvMenuList3.add(resvMenuDTO);
						
						
						
					}while(rs.next());
					
				
			} // if() end
					
		} catch (SQLException e) {
			System.out.println("selectReservationMenuList 에러: " + e); // e: 예외종류 + 에외 메시지
		} finally {
		
			close(rs);
			close(pstmt);
		}
		
		return ResvMenuList3;
		}
			//예약메뉴 구매전 상세보기 이거다음 바로 구매화면 구현예정
		public ResvMenuDTO selectRsvMenuInfo(String menuID) {
			ResvMenuDTO rsvMenuInfo =null;
			
			String sql = "SELECT * FROM RESERVATION_MENU WHERE menuID=?";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, menuID);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					rsvMenuInfo = new ResvMenuDTO(	rs.getString("menuID"),
							rs.getString("category"),
							rs.getString("menuNAME"),
							rs.getString("menuDETAIL"),
							rs.getString("m_status"),
							rs.getInt("resvPRICE"),
							rs.getDate("resvORDERDATE"),
					
							rs.getString("image")
						                 );
				} 

			} catch (Exception e) {
				System.out.println("selectMenuInfo 에러: " + e);// e: 예외종류 + 예외메세지
			} finally {
			
				close(rs);
				close(pstmt);
			}
			
			
			
			
			
			
			
			
			return rsvMenuInfo;
		}

		
		
		
		
		public int insertOrderMenu(String mID, String mEMAIL, ArrayList<ResvMenuDTO> rsvMenuList, int saleTotalMoney, String resvDATE) {
			  int insertOrderMenuCount = 0;
			  PreparedStatement pstmt2 = null;
		        ResultSet rs2 = null;
		       
		        PreparedStatement pstmt3 = null;
		        System.out.println("[MemberDAO]insertOrderMenu:"+resvDATE);
		        
		        String sql = "insert into ReservationOrder_table(mID,mEMAIL,resvORDERDATE,order_status, totalmoney,resvDATE) "
		        		//+ "values(?,?,now(),'order', ? , DATE_FORMAT(?,'%Y-%m-%d %H/%i') )";
		        		+ "values(?,?,now(),'order', ? , ? )";
		        
		        try {
		              pstmt = con.prepareStatement(sql);
		              
		              pstmt.setString(1, mID);
		              pstmt.setString(2, mEMAIL);
		              pstmt.setInt(3, saleTotalMoney);
		              pstmt.setString(4, resvDATE);
		              
		              pstmt.executeUpdate();
		              
		              pstmt2 =con.prepareStatement("select MAX(order_num) from ReservationOrder_table where mID=?");
		              pstmt2.setString(1, mID);
		              rs2=pstmt2.executeQuery();
		              
		              if(rs2.next()) {
		  
		            	  for(int i=0;i<rsvMenuList.size();i++) {
		            		
		            		  pstmt3 = con.prepareStatement("insert into ResOrderDetail_table(menuID,order_num,quantity,menuNAME,resvPRICE,resvDATE) value(?,?,?,?,?,?)");  
		            		  
		            		  ResvMenuDTO ResMenu =rsvMenuList.get(i);
		            		  pstmt3.setString(1, ResMenu.getMenuID());
		            		  pstmt3.setInt(2, rs2.getInt("MAX(order_num)"));
		            		  pstmt3.setInt(3, ResMenu.getQuantity());
		            		  pstmt3.setString(4, ResMenu.getMenuNAME());
		            		  pstmt3.setInt(5,ResMenu.getResvPRICE());
		            		  pstmt3.setString(6, resvDATE);
		            		
		            
		            		  insertOrderMenuCount = pstmt3.executeUpdate();
		            		  
		            		  
		            	  }
		              }
		              
		              
		              
		              
		              }catch (Exception e) {
		            	  System.out.println("insertOrderMenu 오류"+ e);
		              } finally {
		                  // close(rs);
		                  // close(rs2);
		                  close(pstmt);
		                  close(pstmt2);
		                  close(pstmt3);
		              }
			  
			  
			  
			return insertOrderMenuCount;
		}

		public ArrayList<ResvOrder> selectResvOrder(String mID, String mEMAIL) {
			ArrayList<ResvOrder> resvOrder = null;
			// 주문 요일보단 예약요일 최신순으로
			String sql = "SELECT * FROM ReservationOrder_table WHERE mID=? AND mEMAIL=? ORDER BY resvDATE DESC";
			
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mID);
				pstmt.setString(2, mEMAIL);
				rs = pstmt.executeQuery();
				
			if(rs.next()) { // 결과를 해당객체에 담기위해 생성
				resvOrder = new ArrayList<ResvOrder>();
			}
				
				//예약날은 스트링으로
			do {resvOrder.add(new  ResvOrder(rs.getInt("order_num"),rs.getString("mID"),
					rs.getString("mEMAIL"),rs.getTimestamp("resvORDERDATE"),rs.getString("order_status"),
					rs.getInt("totalmoney"),rs.getString("resvDATE")
					)  );
				
			}while (rs.next());
				
				
				
				
			}catch (Exception e) {
				System.out.println("selectResvOrder 오류"+e);
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			return resvOrder;
		}

		public ArrayList<ResvOrderDetail> selectDetailOrder(int order_num) {
			ArrayList<ResvOrderDetail> reservationDetailInfoView = null;
			
			
			String sql = "SELECT * FROM ResOrderDetail_table WHERE ORDER_NUM=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, order_num);
				rs = pstmt.executeQuery();
			
				if (rs.next()) {
					reservationDetailInfoView = new ArrayList<ResvOrderDetail>();
					
					do {
						reservationDetailInfoView.add(
								new ResvOrderDetail(rs.getInt("datail_index"), rs.getString("menuID"), rs.getInt("order_num"),
										rs.getInt("quantity"), rs.getString("menuNAME"), rs.getInt("resvPRICE"),rs.getString("resvDATE")
										
										
										
										)
								
								);
					}while (rs.next());
					
					
					
					
				}
			
			
			}catch (Exception e) {
				System.out.println("selectDetailOrder 에러: " + e);
			
			
			
			}finally {
				close(rs);
				close(pstmt);
			}

			
			
			
			
			
			
			
			return reservationDetailInfoView;
		}

		public  int deleteResv(ReservationDelete delete) {
			int deleteResv=0;
			  PreparedStatement pstmt2 = null;
			
			String sql="DELETE FROM ReservationOrder_table WHERE order_num=? AND resvDATE=?";
			
			try {
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1,delete.getOrder_num());
				pstmt.setString(2,delete.getResvDATE());
				
				 pstmt.executeUpdate();
			    //주의 예약 디테일도 지워야함
			    pstmt2 =con.prepareStatement("DELETE FROM ResOrderDetail_table WHERE order_num=? AND resvDATE=?");
			    pstmt2.setInt(1,delete.getOrder_num());
			    pstmt2.setString(2,delete.getResvDATE());
			  
			    
			    deleteResv = pstmt2.executeUpdate();
			    
			    
			}catch(Exception e) {
				System.out.println("ReservationDelete 오류"+e);
			}finally {
			      close(pstmt);
                  close(pstmt2);
			}
			
			return deleteResv;
		}

		public int resvModify(ReservationDelete modyfyDate) {
		
			int resvModifySuccess=0;
			  PreparedStatement pstmt2 = null;
			
			String sql="UPDATE ReservationOrder_table SET resvDATE=? WHERE order_num=? ";
			
			try {
				pstmt= con.prepareStatement(sql);
				pstmt.setString(1,modyfyDate.getResvDATE());
				pstmt.setInt(2,modyfyDate.getOrder_num());
			
				
				 pstmt.executeUpdate();
			    //주의 예약 디테일도 지워야함
			    pstmt2 =con.prepareStatement("UPDATE ResOrderDetail_table SET resvDATE=? WHERE order_num=?");
			 
			    pstmt2.setString(1,modyfyDate.getResvDATE());
			    pstmt2.setInt(2,modyfyDate.getOrder_num());
			
			    
			    resvModifySuccess = pstmt2.executeUpdate();
			    
			    
			}catch(Exception e) {
				System.out.println("ReservationDelete 오류"+e);
			}finally {
			      close(pstmt);
                close(pstmt2);
			}
			
			return resvModifySuccess;
		}

		public int selectTable(String limitTime) {
			int resvOrder = 0;
			System.out.println(limitTime);
			String sql = "SELECT count(order_num) FROM ReservationOrder_table WHERE DATE(resvDATE)=? and order_status='order'";
			
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, limitTime);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					resvOrder = rs.getInt("count(order_num)");
					
			
				}
				
				
					
					
					
				
			
			
			}catch (Exception e) {
				System.out.println("selectDetailOrder 에러: " + e);
			
			
			
			}finally {
				close(rs);
				close(pstmt);
			}

			
			
			
			
			
			
			
			return resvOrder;
		}

		public int selectLimitTable() {
			int resvOrder = 0;
		
			String sql = "SELECT count(order_num) FROM ReservationOrder_table WHERE DATE(resvDATE)=curdate() and order_status='order' ";
			
			
			try {
				pstmt = con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					resvOrder = rs.getInt("count(order_num)");
					
			
				}
				
				
					
					
					
				
			
			
			}catch (Exception e) {
				System.out.println("selectDetailOrder 에러: " + e);
			
			
			
			}finally {
				close(rs);
				close(pstmt);
			}

			
			
			
			
			
			
			
			return resvOrder;
		}
	
		
		
		
		
		

}
		




