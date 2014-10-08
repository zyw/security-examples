package cn.v5cn.security.shiro_spring.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.v5cn.security.shiro_spring.entity.Resource;
import cn.v5cn.security.shiro_spring.service.ResourceService;

import com.google.common.collect.ImmutableMap;

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
	
	@RequestMapping(value="/resource/{resId}",method=RequestMethod.GET)
	public String editResPage(@PathVariable Long resId,ModelMap modelMap){
		Resource parent = resourceService.findByResId(resId);
		modelMap.addAttribute("parent", parent);
		Resource resource = new Resource();
		resource.setParent_Id(resId);
		resource.setParent_Ids(parent.getParent_Ids()+parent.getId()+"/");
		modelMap.addAttribute("resource", resource);
		modelMap.addAttribute("op", "新增子节点");
		return "resource/edit_res";
	}
	
	@ResponseBody
	@RequestMapping(value="/resource",method=RequestMethod.POST)
	public ImmutableMap<String,String> editResPost(Resource resource){
		System.out.println(resource);
		int result = resourceService.addRes(resource);
		if(result > 0){
			return ImmutableMap.of("state","1","success", "添加资源成功！");
		}
		return ImmutableMap.of("state","0","success", "添加资源失败！");
	}
}
