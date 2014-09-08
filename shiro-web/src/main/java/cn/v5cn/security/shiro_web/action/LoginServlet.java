package cn.v5cn.security.shiro_web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet(name="loginServlet",urlPatterns="/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errMsg = null;
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,pwd);
		token.setRememberMe(true);
		try {
			subject.login(token);
		} catch(UnknownAccountException e){
			errMsg = "用户名或者密码错误！";
		}catch(IncorrectCredentialsException e){
			errMsg = "用户名或者密码错误！";
		}catch (AuthenticationException e) {
			errMsg = "其他错误："+ e.getMessage();
		}
		
		if(errMsg != null){
			req.setAttribute("error", errMsg);
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}else{
			req.getSession().setAttribute("subject",subject);
			req.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp").forward(req, resp);
		}
	}
}
