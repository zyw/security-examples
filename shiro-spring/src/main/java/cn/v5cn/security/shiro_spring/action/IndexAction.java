package cn.v5cn.security.shiro_spring.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.v5cn.security.shiro_spring.annotation.CurrentUser;
import cn.v5cn.security.shiro_spring.entity.Resource;
import cn.v5cn.security.shiro_spring.entity.User;
import cn.v5cn.security.shiro_spring.service.UserService;

@Controller
public class IndexAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/","/index"})
	public String index(@CurrentUser User user,Model model){
		System.out.println(user.getUsername());
		List<Resource> ress = userService.findResourceByUserName(user.getUsername());
		System.out.println("000000::::" + ress.size());
		model.addAttribute("ms", ress);
		return "index";
	}
}
