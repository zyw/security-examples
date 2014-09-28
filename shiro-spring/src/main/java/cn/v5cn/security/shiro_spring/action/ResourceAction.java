package cn.v5cn.security.shiro_spring.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.v5cn.security.shiro_spring.entity.Resource;
import cn.v5cn.security.shiro_spring.service.ResourceService;

@Controller
public class ResourceAction {
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value="/resource",method=RequestMethod.GET)
	public String resourceList(ModelMap modelMap){
		List<Resource> result = resourceService.findAll();
		System.out.println(result);
		modelMap.addAttribute("ress", result);
		return "resource/resources";
	}
}
