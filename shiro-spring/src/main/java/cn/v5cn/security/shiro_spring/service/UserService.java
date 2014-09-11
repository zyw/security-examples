package cn.v5cn.security.shiro_spring.service;

import java.util.Set;

import cn.v5cn.security.shiro_spring.entity.User;

public interface UserService {
	User findByUserName(String username);
	Set<String> findByPermission(String username);
	Set<String> findByRole(String username);
}
