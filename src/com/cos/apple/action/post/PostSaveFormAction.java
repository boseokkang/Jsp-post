package com.cos.apple.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.action.Action;

public class PostSaveFormAction implements Action {
			@Override
			public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
				if (session.getAttribute("principal") == null) {
					response.sendRedirect("member/loginForm.jsp");
					// return 없으면 밑의 response 를 타기 때문에 꼭 걸어줘야함!
					return;
				}
		
				response.sendRedirect("post/saveForm.jsp");
		
			}
}

