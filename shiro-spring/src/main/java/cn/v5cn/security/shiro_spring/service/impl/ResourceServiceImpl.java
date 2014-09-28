package cn.v5cn.security.shiro_spring.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.v5cn.security.shiro_spring.dao.ResourceDao;
import cn.v5cn.security.shiro_spring.entity.Resource;
import cn.v5cn.security.shiro_spring.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public List<Resource> findByIds(Long... resIds) {
		return resourceDao.findByIds(resIds);
	}

	@Override
	public List<Resource> findByStrIds(String resIds) {
		String[] temp = StringUtils.split(resIds,",");
		Long[] ids = new Long[temp.length];
		for(int i=0;i<temp.length;i++){
			ids[i] = Long.valueOf(temp[i]);
		}
		System.out.println("---------------:::"+resourceDao.findByIds(ids));
		return resourceDao.findByIds(ids);
	}

	@Override
	public List<Resource> findAll() {
		return resourceDao.findAll();
	}
	
	

}
