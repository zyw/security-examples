package cn.v5cn.security.shiro_spring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.v5cn.security.shiro_spring.annotation.CurrentUser;
import cn.v5cn.security.shiro_spring.entity.User;

@Controller
public class IndexAction {
	
	@RequestMapping(value={"/","/index"})
	public String index(@CurrentUser User user){
		System.out.println(user.getUsername());
		return "index";
	}
}
