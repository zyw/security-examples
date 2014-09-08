package cn.v5cn.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatorTest {
	
	@Test
	public void testAllSuccessfulStrategyWithSuccess(){
		login("classpath:shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		
		PrincipalCollection principals = subject.getPrincipals();
		System.out.println(principals.asList().get(1));
		Assert.assertEquals(2, principals.asList().size());
	}
	@Test(expected=UnknownAccountException.class)
	public void testAllSuccessfulStrategyWithFail(){
		login("classpath:shiro-authenticator-all-fail.ini");
	}
	
	private void login(String configFile){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		subject.login(token);
		
		
	}
}
