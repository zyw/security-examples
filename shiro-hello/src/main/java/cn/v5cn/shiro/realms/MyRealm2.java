package cn.v5cn.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm {

	public String getName() {
		return "myRealm2";
	}

	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)	throws AuthenticationException {
		String username = (String)token.getPrincipal();
		String pwd = new String((char[])token.getCredentials());
		if(!"wang".equals(username)){
			throw new UnknownAccountException();
		}
		if(!"123".equals(pwd)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username,pwd,getName());
	}

}
