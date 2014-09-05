package cn.v5cn.security.sshello.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.v5cn.security.sshello.entity.Role;

@Repository("roleDao")
public interface RoleDao {
	List<Role> findByUserId(Long uid);
	List<Role> findByRescId(Long rid);
}
