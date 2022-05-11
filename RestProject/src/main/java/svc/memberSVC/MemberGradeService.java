
package svc.memberSVC;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberDTO;

public class MemberGradeService {

	
	
	//메서드 
	public static MemberDTO updateGrade(MemberDTO member) {
		Connection con = getConnection();//
		
		
		MemberDAO memberDAO = MemberDAO.getInstance();//
		
		
		memberDAO.setConnection(con);//
		
		
		int LastMonthMoney = memberDAO.getLastMonthMoney(member.getmID());  // 저번달 돈 밑에서 처리
		
		String grade = member.getmGRADE();//사용자 등급
		
		int gradeCount=0;//등급 업그레이드 카운트
		if(grade.trim().equalsIgnoreCase("Familly")&&LastMonthMoney>=100000) {
			//등급이 Familly 면서 저번달 20만원 지출시 
			gradeCount=memberDAO.upGrade(member);// 스테틱 메서드가 아니기때문에 위객체로 호출 
			if(gradeCount>0) {
				  commit(con);        //조건에 맞는 변경사항이있으면
			}else {
				rollback(con);
			}
			
		
		}
		else if(grade.trim().equalsIgnoreCase("VIP") && LastMonthMoney < 100000) {
			// 등급을 NORMAL로 다운
			gradeCount = memberDAO.downGrade(member); // 성공하면 1리턴받음
			if(gradeCount > 0) {
				commit(con); // 업데이트한 내용을 영구저장
			}else {
				rollback(con); // 실패시 이전상태로 복구
			}
		}
		
		if(grade.trim().equalsIgnoreCase("VIP")&&LastMonthMoney>=400000) {
			//등급이 VIP 면서 저번달 20만원 지출시 
			gradeCount=memberDAO.upGradeVVIP(member);// 스테틱 메서드가 아니기때문에 위객체로 호출 
			if(gradeCount>0) {
				  commit(con);        //조건에 맞는 변경사항이있으면
			}else {
				rollback(con);
			}
			
		
		}
		
		
		else if(grade.trim().equalsIgnoreCase("VVIP") && LastMonthMoney < 200000) {
			// 등급을 VIP로 다운
			gradeCount = memberDAO.downGrade(member); // 성공하면 1리턴받음
			if(gradeCount > 0) {
				commit(con); // 업데이트한 내용을 영구저장
			}else {
				rollback(con); // 실패시 이전상태로 복구
			}
		}
		
		
		
		
		// 갱신된 DB를 다시 id로 조회한 사용자 정보를 리턴함
		MemberDTO memberInfo = memberDAO.getMemberInfo(member.getmID());
		
		
		//  db해제 꼭해주기
		
		close(con); // Connection 객체 해제
		
		
		
		return memberInfo;
		
		
		
		
		
		
		
		
		
	}
	
	
	//등급 별 로  세일비율 조회
	public double getSaleRate(String mGRADE) {
		Connection con = getConnection();//1 컨객체생성 반복임
		
		
		MemberDAO memberDAO = MemberDAO.getInstance();//2 DAO 객체 생성
		
		
		memberDAO.setConnection(con);// DB연결을위해 DAO객체에 커넥션
		
	
		double saleRate = 1.0;//세일비율 기본
		
		saleRate = memberDAO.selectSaleRate(mGRADE); // 처리를위해 메서드 생성
		
		// 4. 해제
		close(con); // Connection 객체 해제 !!!
		
		return saleRate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
