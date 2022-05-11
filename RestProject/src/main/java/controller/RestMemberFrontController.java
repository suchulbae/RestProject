package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.board.BoardDeleteProAction;
import action.board.BoardDetailAction;
import action.board.BoardListAction;
import action.board.BoardModifyFormAction;
import action.board.BoardModifyProAction;
import action.board.BoardReplyFormAction;
import action.board.BoardReplyProAction;
import action.board.BoardWriteAction;
import action.memberaction.MemberDELETEAction;
import action.memberaction.MemberHashPwChangeAction;
import action.memberaction.MemberHashPwFindAction;
import action.memberaction.MemberIdFindAction;
import action.memberaction.MemberJoinAction;
import action.memberaction.MemberLoginAction;


import action.memberaction.MemberViewAction;
import action.memberaction.memberUpdateAction;
import vo.ActionForward;



@WebServlet("*.RC")
public class RestMemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RestMemberFrontController() {
        super();
    
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response); // doGet이든 doPost든 doProcess에서 처리함
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response); // doGet이든 doPost든 doProcess에서 처리함
	}
	
	// 이 서블릿으로 들어오는 모든 요청은 doProcess()를 호출하여 처리
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8"); // ★ 반드시 첫줄
			
			// 요청객체로부터 '프로젝트명+파일경로'를 가져옴 (예) /project/memberLogin.RC 
			String requestURI = request.getRequestURI();
			
			// 요청객체로부터 'contextPath'를 가져옴 (예) /project
			String contextPath = request.getContextPath();
			
			/*
			 * [ dogList.dog(어떤요청이 왔는지 판단을 하는 단서)만 추출하기 위한 작업 ]
			 * 
			 *    /project/memberLogin.RC   - /project =  /memberLogin.RC 
			 * 
			 */
			
			String command = requestURI.substring(contextPath.length()); // 시작인덱스(index : 8 (두번째 / )) ~ 끝까지 부분문자열 생성
			
			/*
			 * 컨트롤러에서 요청이 파악되면 해당 요청을 처리하는 각 Action클래스를 사용해서 요청 처리
			 * 각 요청에 해당하는 Action클래스 객체들을 다형성을 이용해서 동일한 타입인 Action으로 참조하기 위해
			 */
			Action action = null;  // Action부모 인터페이스 = Action을 구현한 객체
			ActionForward forward = null;
			
			/*
			 * 
			 */
			
					
				
					
	
			
			/* -- '로그인 폼 보기' -> 처리 -------------------------------------------------*/
			  if(command.equals("/memberLogin.RC")) { // '로그인 폼 보기'요청이면
				
				request.setAttribute("showPage", "/member/loginForm.jsp"); // showPage(보여줄 페이지)안에 "/member/logingForm.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false);
				
			}
			else if(command.equals("/memberLoginAction.RC")) { // '로그인 처리'요청이면
				action = new MemberLoginAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					
					System.out.println("로그인 컨트롤러 오류"+e);
				}
			}
			
			/* -- 'id 찾기' 폼보기 -> 처리 -------------------------------------------------*/
			else if(command.equals("/memberIdFindForm.RC")) { // 'id 찾기 폼보기'요청이면
				
				request.setAttribute("showPage", "member/memberIdFind.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false); // false : 요청을 그대로 전달해야지 action에서 처리가 가능하기 때문
				
			}
			else if(command.equals("/memberIdFindAction.RC")) { // '아이디 찾기 처리'요청이면
				action = new MemberIdFindAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/* -- '암호화된 비밀번호 찾기' 폼보기 -> 처리 -------------------------------------------------*/
			else if(command.equals("/memberHashPwFindForm.RC")) { // '비밀번호 찾기 폼보기'요청이면
				
				request.setAttribute("showPage", "member/memberHashPwFind.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false); // false : 요청을 그대로 전달해야지 action에서 처리가 가능하기 때문
				
			}
			else if(command.equals("/memberHashPwFindAction.RC")) { // '비밀번호 찾기 처리'요청이면
				action = new MemberHashPwFindAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			/* -- '암호화된 비밀번호 변경' 폼보기 -> 처리 -------------------------------------------------*/
			else if(command.equals("/memberHashPwChangeForm.RC")) { // '비밀번호 변경 폼보기'요청이면
				
				request.setAttribute("showPage", "member/memberHashPwChange.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false); // false : 요청을 그대로 전달해야지 action에서 처리가 가능하기 때문
				
			}
			else if(command.equals("/memberHashPwChangeAction.RC")) { // '비밀번호 찾기 처리'요청이면
				action = new MemberHashPwChangeAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			/* -- '회원가입' 폼보기 -> 처리 -------------------------------------------------*/
			else if(command.equals("/memberJoin.RC")) { // '회원가입 폼보기'요청이면
				
				request.setAttribute("showPage", "member/joinForm.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false); // false : 요청을 그대로 전달해야지 action에서 처리가 가능하기 때문
				
			}
			else if(command.equals("/memberJoinAction.RC")) { // '회원가입'요청이면
				action = new MemberJoinAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if(command.equals("/memberLogout.RC")) {
				
				HttpSession session = request.getSession();
				//session.invalidate();
				//session.removeAttribute(//저장된정보); 하나씩지울때
				session.removeAttribute("mID");
				session.removeAttribute("mGRADE");
				session.removeAttribute("mPW");
				session.removeAttribute("mNAME");
				session.removeAttribute("mEMAIL");
				session.removeAttribute("mPHONE");
				
				
				forward = new ActionForward("memberMain.jsp", true);//이동시키는 부분
				

		
			}
			
			
			/* -- '사용자 한명 상세 정보보기' 폼보기 -> 처리 -------------------------------------------------*/
			else if(command.equals("/memberView.RC")) { // '정보보기 폼보기'요청이면
				//폼부터 보여줌
				//request.setAttribute("showPage", "member/joinForm.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				
				action =new MemberViewAction();
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
				
				
			}
			else if(command.equals("/memberUpdate.RC")) { // '사용자 한명 상세 정보 수정 '요청이면
				action = new memberUpdateAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			///-------- 강사님 코드아님 직접 제작  게시판
			
			/* -- 'id 찾기' 폼보기 -> 처리 -------------------------------------------------*/
			else if(command.equals("/memberIdFindForm.RC")) { // 'id 찾기 폼보기'요청이면
				
				request.setAttribute("showPage", "member/memberIdFind.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false); // false : 요청을 그대로 전달해야지 action에서 처리가 가능하기 때문
				
			}
			else if(command.equals("/memberIdFindAction.RC")) { // '아이디 찾기 처리'요청이면
				action = new MemberIdFindAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			
			
			
			//////////---------- 미강쌤외에 따론한부분-------------------------------
			
			
			
			if(command.equals("/boardWriteForm.RC")){
				forward=new ActionForward();
				forward.setPath("/board/qna_board_write.jsp");
			}else if(command.equals("/boardWritePro.RC")){
				action  = new BoardWriteAction();
				try {
					forward=action.execute(request, response );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			else if(command.equals("/boardList.RC")){
				action = new BoardListAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(command.equals("/boardDetail.RC")){
				action = new BoardDetailAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(command.equals("/boardReplyForm.RC")){
				action = new BoardReplyFormAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(command.equals("/boardReplyPro.RC")){
				action = new BoardReplyProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(command.equals("/boardModifyForm.RC")){
				action = new BoardModifyFormAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(command.equals("/boardModifyPro.RC")){
				action = new BoardModifyProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(command.equals("/boardDeleteForm.RC")){
				String nowPage = request.getParameter("page");
				request.setAttribute("page", nowPage);
				int board_num=Integer.parseInt(request.getParameter("board_num"));
				request.setAttribute("board_num",board_num);
				forward=new ActionForward();
				forward.setPath("/board/qna_board_delete.jsp");
			}
			else if(command.equals("/boardDeletePro.RC")){
				action = new BoardDeleteProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
	
			//--- 미강쌤외에 따로 한 부분
			//회원탈퇴
			else if(command.equals("/memberDELETE.RC")) { // '회원가입 폼보기'요청이면
				
				request.setAttribute("showPage", "member/deleteForm.jsp"); // showPage(보여줄 페이지)안에 "member/logingIdFind.jsp" 저장
				forward = new ActionForward("memberTemplate.jsp", false); // false : 요청을 그대로 전달해야지 action에서 처리가 가능하기 때문
				
			}
			else if(command.equals("/memberDELETEAction.RC")) { // '회원가입'요청이면
				action = new MemberDELETEAction(); // Action 인터페이스를 부모로해서 실행메서드(DogListAction.java의 execute())를 재정의함
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			
			//----------------
		
			/******************************************************************
			 **   포워딩
			 *******************************************************************/
			if(forward != null) {
				//if(forward.isRedirect())
				if(forward.isRedirect() == true) { // isRedirect() == true이면 리다이렉트(새요청) 방식 -> 기존 request 공유 못함
					response.sendRedirect(forward.getPath()); // memberMain.jsp
				}else {
					//RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // dogList.jsp
					// 기존요청, 기존응답을 매개값으로 그대로 전달하므로 request 공유할 수 있다.
					//dispatcher.forward(request, response);
					
					request.getRequestDispatcher(forward.getPath()).forward(request, response); // dogView.jsp로 이동 (한줄로 표현하기)
				}
			}
			
		}

}
