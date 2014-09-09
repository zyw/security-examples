package cn.v5cn.security.shiro_spring.service;

import cn.v5cn.security.shiro_spring.entity.User;

public interface UserService {
	User findByUserName(String username);
}
