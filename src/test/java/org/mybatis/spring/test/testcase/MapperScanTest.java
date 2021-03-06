package org.mybatis.spring.test.testcase;

import java.util.List;

import org.mybatis.spring.test.model.Account;
import org.mybatis.spring.test.model.User;
import org.mybatis.spring.test.service.AccountService;
import org.mybatis.spring.test.service.UserService;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * @Title: MapperScanTest.java
 * @Package org.mybatis.spring.test.testcase
 * @Description: 测试扫描加载Mapper
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2013年7月13日 下午1:12:50 
 * $Revision: 1.00$
 * @version V1.0
 */
public class MapperScanTest extends
		AbstractDependencyInjectionSpringContextTests {

	@Override
	protected void prepareTestInstance() throws Exception {
		this.setAutowireMode(AUTOWIRE_BY_NAME);
		super.prepareTestInstance();
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[]{"classpath*:/applicationContext-sample-scan.xml"};
	}
	
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService){
		this.accountService = accountService;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	public void testScanXmlMapper() {
		Account account = accountService.getAccount("ACID");

		assertEquals("acid@yourdomain.com", account.getEmail());
	}
	
	public void testScanAnnotationMapper(){
		List<User>  users = userService.selectAll();
		
		assertEquals(users.get(0).getUserName(), "zhanghp");
	}
}
