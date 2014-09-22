package cn.v5cn.security.shiro_spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.v5cn.security.shiro_spring.entity.Resource;

@Repository
public interface ResourceDao {
	List<Resource> findByIds(Long[] array);
}
