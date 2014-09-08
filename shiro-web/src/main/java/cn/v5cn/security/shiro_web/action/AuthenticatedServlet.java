package cn.v5cn.security.shiro_web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@WebServlet(name="authenticatedServlet",urlPatterns="/authenticated")
public class AuthenticatedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			req.getRequestDispatcher("/WEB-INF/jsp/authenticated.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}
}
