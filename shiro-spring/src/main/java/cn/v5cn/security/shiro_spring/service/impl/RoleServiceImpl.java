package cn.v5cn.security.shiro_spring.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.v5cn.security.shiro_spring.dao.RoleDao;
import cn.v5cn.security.shiro_spring.entity.Role;
import cn.v5cn.security.shiro_spring.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> findByIds(Long... roleIds) {
		return roleDao.findByIds(StringUtils.join(roleIds, ","));
	}

	@Override
	public List<Role> findByStrIds(String roleIds) {
		String[] temp = StringUtils.split(roleIds,",");
		Long[] ids = new Long[temp.length];
		for(int i=0;i<temp.length;i++){
			ids[i] = Long.valueOf(temp[i]);
		}
		return findByIds(ids);
	}

	@Override
	public Set<String> findRolesByIds(String roleIds) {
		List<Role> temps = findByStrIds(roleIds);
		Set<String> roles = new HashSet<String>();
		for(Role role : temps){
			roles.add(role.getRole());
		}
		return roles;
	}

}
