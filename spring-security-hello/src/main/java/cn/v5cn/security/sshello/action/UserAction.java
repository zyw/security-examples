package cn.v5cn.security.sshello.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.v5cn.security.sshello.dao.UserDao;
import cn.v5cn.security.sshello.entity.User;

@Controller
public class UserAction {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		System.out.println("------------------");
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request){
		User dbuser = userDao.findUserByName(user.getUsername());
		Authentication authentication = myAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		HttpSession session = request.getSession(true);  
	    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);  
	    // 当验证都通过后，把用户信息放在session里
		request.getSession().setAttribute("userSession", dbuser);
		// 记录登录信息
//		UserLoginList userLoginList = new UserLoginList();
//		userLoginList.setUserId(users.getUserId());
//		userLoginList.setLoginIp(Common.toIpAddr(request));
//		userLoginListService.add(userLoginList);
		return "index";
	}
}
