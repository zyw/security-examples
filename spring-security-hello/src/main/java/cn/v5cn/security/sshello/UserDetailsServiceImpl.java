package cn.v5cn.security.sshello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.v5cn.security.sshello.dao.RoleDao;
import cn.v5cn.security.sshello.dao.UserDao;
import cn.v5cn.security.sshello.entity.Role;
import cn.v5cn.security.sshello.entity.User;

/**
 * UserDetailsService接口的主要任务是查询用户所具有的权限
 * 
 * */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findUserByName(username);
		if(user == null){
			throw new UsernameNotFoundException("用户名或密码错误，请重试！");
		}
		List<Role> roles = roleDao.findByUserId(user.getId());
		
		if(roles == null || roles.isEmpty()){
			throw new UsernameNotFoundException("权限不足！");
		}
		
		Collection<GrantedAuthority> gaRoles = new ArrayList<GrantedAuthority>();
		
		for(Role role : roles){
			gaRoles.add(new SimpleGrantedAuthority(role.getName()));
		}
		org.springframework.security.core.userdetails.User userDetails = 
				new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), gaRoles);
		return userDetails;
	}

}
