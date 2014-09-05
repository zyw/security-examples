package cn.v5cn.security.sshello.dao;

import org.springframework.stereotype.Repository;

import cn.v5cn.security.sshello.entity.User;

@Repository("userDao")
public interface UserDao {
	User findUserByName(String username);
}
