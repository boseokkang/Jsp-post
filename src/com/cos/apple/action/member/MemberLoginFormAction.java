package com.cos.apple.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.action.Action;

public class MemberLoginFormAction implements Action{

			@Override
			public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
				System.out.println("3333");
							response.sendRedirect("member/loginForm.jsp");
			}

}