package cn.v5cn.security.sshello;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * 
 * AccessDecisionManager接口的任务是判断用户所拥有的角色跟权限所属的角色是否匹配
 * 
 * */
@Service("accessDecisionManager")
public class AccessDecisionManagerImpl implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if(configAttributes == null) return;
		
		for(ConfigAttribute ca : configAttributes){
			String needRole = ((SecurityConfig)ca).getAttribute();
			for(GrantedAuthority ga : authentication.getAuthorities()){
				if(needRole.equals(ga.getAuthority()))
					return;
			}
		}
		throw new AccessDeniedException("权限不足！");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
