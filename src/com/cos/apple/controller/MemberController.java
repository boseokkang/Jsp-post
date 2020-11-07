package com.cos.apple.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.action.Action;
import com.cos.apple.action.member.MemberJoinFormAction;
import com.cos.apple.action.member.MemberJoinProcAction;
import com.cos.apple.action.member.MemberLoginFormAction;
import com.cos.apple.action.member.MemberLoginProcAction;
import com.cos.apple.action.member.MemberLogoutAction;
import com.cos.apple.action.member.MemberUpDateFormAction;
import com.cos.apple.action.member.MemberUpDateProcAction;


//http://localhost:8000/post/member
@WebServlet("/member")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

			public MemberController() {
				super();
			}

			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doProcess(request, response);
			}
		
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				doProcess(request, response);
			}

			protected void doProcess(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// 1. request UTF-8 세팅 → web.xml 필터 등록
				// 2. response UTF-8 세팅 → doProcess 등록하기
				response.setCharacterEncoding("UTF-8");
				// ↑ response응답할 때 UTF-8로 인코딩한다는 코드
				response.setContentType("text/html; charset=UTF-8");
				System.out.println("이동됨 member");
				// ↑ 'text/html' 은 Default, 'charset=UTF-8' 알려주기 위함
				// 들고가는 데이터가 뭔지 알려주는 것이라서 적지 않아도 크게 상관 없음!
				// 만약 json 응답시 여기 아래로 코드 작성해주면 됨
				// response.setContentType("text/json; charset=UTF-8");
				String cmd = request.getParameter("cmd");
				Action action = router(cmd);
				action.execute(request, response);
			}

			private Action router(String cmd) {
				if (cmd.equals("joinForm")) {
					return new MemberJoinFormAction();
				} else if (cmd.equals("joinProc")) {
					return new MemberJoinProcAction();
				} else if (cmd.equals("loginForm")) {
					return new MemberLoginFormAction();
				} else if (cmd.equals("loginProc")) {
					return new MemberLoginProcAction();
				} else if (cmd.equals("updateForm")) {
					return new MemberUpDateFormAction();
				} else if (cmd.equals("updateProc")) {
					return new MemberUpDateProcAction();
				} else if (cmd.equals("logout")) {
					return new MemberLogoutAction();
				} 
				return null;
			}

}
