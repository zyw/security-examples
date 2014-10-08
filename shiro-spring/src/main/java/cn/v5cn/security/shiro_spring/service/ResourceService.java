package cn.v5cn.security.shiro_spring.service;

import java.util.List;

import cn.v5cn.security.shiro_spring.entity.Resource;

public interface ResourceService {
	List<Resource> findByIds(Long ...resIds);
	List<Resource> findByStrIds(String resIds);
	List<Resource> findAll();
	Resource findByResId(Long resId);
	int addRes(Resource resource);
}
