package cn.v5cn.security.shiro_spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.v5cn.security.shiro_spring.dao.UserDao;
import cn.v5cn.security.shiro_spring.entity.User;
import cn.v5cn.security.shiro_spring.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

}
