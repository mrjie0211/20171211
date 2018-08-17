package booksystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter  {
	  @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        
	        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
	            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
	            HandlerMethod handlerMethod = (HandlerMethod) handler; 
	            //System.out.println("handlerMethod.getMethod()"+handlerMethod.getMethod().getName()); 
	            String methodName = handlerMethod.getMethod().getName();
	            
	                if(authPassport == null || authPassport.validate() == false)//û��������ҪȨ��,������������֤Ȩ��
	                	return true;
	                else{
	                	
	                	HttpSession session = request.getSession();
	                	String privilege=(String) session.getAttribute("privilege") ;
	                	if(privilege.indexOf(methodName)!=-1){
	         
	                		return true;
	                	}
	                	
	                	
	                    return false;
	                }       
	            
	        }else
	            return true;   
	     }
	

}

