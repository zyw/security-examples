package cn.v5cn.security.shiro_spring.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.v5cn.security.shiro_spring.entity.User;
import cn.v5cn.security.shiro_spring.service.UserService;

public class V5Realm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 String username = (String)principals.getPrimaryPrincipal();
		 //User user = userService.findByUserName(username);
		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		 info.setRoles(userService.findByRole(username));
		 info.setStringPermissions(userService.findByPermission(username));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		User user = userService.findByUserName(username);
		if(user == null){
			throw new UnknownAccountException();
		}
		
		if(Boolean.TRUE.equals(user.getLocked())){
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getUsername(),
				user.getPassword(),
				getName()
				);
		return authenticationInfo;
	}

}
