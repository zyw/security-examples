package cn.v5cn.security.shiro_spring.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.v5cn.security.shiro_spring.dao.UserDao;
import cn.v5cn.security.shiro_spring.entity.Resource;
import cn.v5cn.security.shiro_spring.entity.Role;
import cn.v5cn.security.shiro_spring.entity.User;
import cn.v5cn.security.shiro_spring.service.ResourceService;
import cn.v5cn.security.shiro_spring.service.RoleService;
import cn.v5cn.security.shiro_spring.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public Set<String> findByPermission(String username) {
		List<Resource> resources = resourceByUsername(username);
		Set<String> result = new HashSet<String>();
		for(Resource res : resources){
			result.add(res.getPermission());
		}
		return result;
	}

	@Override
	public Set<String> findByRole(String username) {
		User user = findByUserName(username);
		return roleService.findRolesByIds(user.getRole_Ids());
	}

	@Override
	public List<Resource> findResourceByUserName(String username) {
		List<Resource> resources = resourceByUsername(username);
		List<Resource> result = new ArrayList<Resource>();
		for(Resource res: resources){
			if(!"menu".equals(res.getType())){
				continue;
			}
			result.add(res);
		}
		return result;
	}
	private List<Resource> resourceByUsername(String username){
		User user = findByUserName(username);
		List<Role> roles = roleService.findByStrIds(user.getRole_Ids());
		List<String> pids = new ArrayList<String>();
		for(Role role : roles){
			pids.add(role.getResource_Ids());
		}
		return resourceService.findByStrIds(StringUtils.join(pids,","));
	}
}
