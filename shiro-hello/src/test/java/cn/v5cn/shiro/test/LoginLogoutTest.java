package cn.v5cn.shiro.test;

import java.security.Security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {

	@Test
	public void testHelloWorld(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			
		}
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
	}
	
	@Test
	public void testCustomRealm(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken passwordToken = new UsernamePasswordToken("zhang","123");
		
		subject.login(passwordToken);
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
	}
	
	@Test
	public void testCustomMultiRealm(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("wang","123");
		
		subject.login(token);
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
	}
	
	@Test
	public void testJDBCRealm(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		subject.login(token);
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		subject.logout();
	}
}
