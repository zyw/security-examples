package cn.v5cn.security.shiro_spring.service;

import java.util.List;
import java.util.Set;

import cn.v5cn.security.shiro_spring.entity.Role;

public interface RoleService {
	List<Role> findByIds(Long... roleIds);
	List<Role> findByStrIds(String roleIds);
	Set<String> findRolesByIds(String roleIds);
}
