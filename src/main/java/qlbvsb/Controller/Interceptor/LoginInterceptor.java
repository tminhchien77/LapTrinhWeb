package qlbvsb.Controller.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	
	  @Override public boolean preHandle(HttpServletRequest request,
		  								HttpServletResponse response, Object handler) throws Exception {
		  System.out.println("Trước  khi vào  controller"); 
		  HttpSession session = request.getSession(); 
		  if(session.getAttribute("user")==null) {
			  System.out.println("Trong If");
			  response.sendRedirect(request.getContextPath()+"/views/admin/login.htm");
			  return false; 
		  } 
		  System.out.println("Chạy tới đây rồi 1");
	  
	  return true; }
	 
	
	/*
	 * @Override public boolean preHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler) throws Exception {
	 * System.out.println("Trước  khi vào  controller"); HttpSession session =
	 * request.getSession(); if(session.getAttribute("user")==null) {
	 * System.out.println("Trong If");
	 * response.sendRedirect(request.getContextPath()+"/views/admin/login.htm");
	 * return false; } System.out.println("Chạy tới đây rồi 1");
	 * 
	 * return true; }
	 */
	
	
	  /*@Override public void postHandle(HttpServletRequest request,
			  						HttpServletResponse response, Object handler, 
			  						ModelAndView modelAndView) throws Exception { 
		  System.out.println("Sau khi post controller");
	  
	  }*/
	 
	
	
	
	  /*@Override public void afterCompletion(HttpServletRequest request,
			  								HttpServletResponse response, Object handler
			  								, Exception ex) throws Exception {
		  // TODO Auto-generated method stub
		  System.out.println("Sau khi thuc hien xong controller");
	  }*/
	 
	

}
