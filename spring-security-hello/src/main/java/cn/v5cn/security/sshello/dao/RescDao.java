package cn.v5cn.security.sshello.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.v5cn.security.sshello.entity.Resc;

@Repository("rescDao")
public interface RescDao {
	List<Resc> findAll();
}
