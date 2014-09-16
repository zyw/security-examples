package cn.v5cn.security.shiro_spring.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.v5cn.security.shiro_spring.service.UserService;

public class V5UserFilter extends PathMatchingFilter {
	
	@Autowired
	private UserService userService;
	@Override
	protected boolean onPreHandle(ServletRequest request,ServletResponse response, Object mappedValue) throws Exception {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		System.out.println(username+"===============");
		request.setAttribute("user",userService.findByUserName(username));
		return true;
	}
}
