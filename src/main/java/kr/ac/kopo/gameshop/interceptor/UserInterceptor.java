package kr.ac.kopo.gameshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.gameshop.model.Member;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		if(member != null) {
			System.out.println("UserInterceptor: TRUE");
			return true;
		}
		
		String query = request.getQueryString();
		session.setAttribute("target_url", request.getRequestURI() + (query != null ? "?" + query : "") );
		System.out.println("INTERCEPTOR: " + session.getAttribute("target_url"));
		
		response.sendRedirect("/login");
		
		System.out.println("UserInterceptor: FALSE");
		return false;	
	}
}
