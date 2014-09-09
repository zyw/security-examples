package cn.v5cn.security.shiro_spring.dao;

import org.springframework.stereotype.Repository;

import cn.v5cn.security.shiro_spring.entity.User;

@Repository
public interface UserDao {
	User findByUserName(String username);
}
