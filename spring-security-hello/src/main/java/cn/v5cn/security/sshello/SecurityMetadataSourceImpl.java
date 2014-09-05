package cn.v5cn.security.sshello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import cn.v5cn.security.sshello.dao.RescDao;
import cn.v5cn.security.sshello.dao.RoleDao;
import cn.v5cn.security.sshello.entity.Resc;
import cn.v5cn.security.sshello.entity.Role;

/**
 * 
 * FilterInvocationSecurityMetadataSource接口的作用是查询资源所属于的角色
 * 
 * */

@Service("securityMetadataSource")
public class SecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RescDao rescDao;
	
	private RequestMatcher requestMatcher;
	
	private String matcher = "ant";
	
	public RequestMatcher getRequestMatcher() {
		return requestMatcher;
	}

	public void setRequestMatcher(RequestMatcher requestMatcher) {
		this.requestMatcher = requestMatcher;
	}

	public String getMatcher() {
		return matcher;
	}

	public void setMatcher(String matcher) {
		this.matcher = matcher;
	}

	private Map<String,Collection<ConfigAttribute>> resourceMap = null;
	
	@PostConstruct
	private void loadResourceDefine(){
		List<Resc> rescs = rescDao.findAll();
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> cas = null;
		for(Resc resc : rescs){
			List<Role> roles = roleDao.findByRescId(resc.getId());
			cas = new ArrayList<ConfigAttribute>();
			for(Role role : roles){
				cas.add(new SecurityConfig(role.getName()));
			}
			resourceMap.put(resc.getRes_string(), cas);
		}
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		HttpServletRequest req = ((FilterInvocation)object).getHttpRequest();
		
		Iterator<String> iterator = resourceMap.keySet().iterator();
		while(iterator.hasNext()){
			String uri = iterator.next();
			if(matcher.equalsIgnoreCase("ant")){
				requestMatcher = new AntPathRequestMatcher(uri);
			}
			if(matcher.equalsIgnoreCase("regex")){
				requestMatcher = new RegexRequestMatcher(uri, req.getMethod(),true);
			}
			if(requestMatcher.matches(req)){
				return resourceMap.get(uri);
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
		for(Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap.entrySet()){
			attributes.addAll(entry.getValue());
		}
		return attributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
