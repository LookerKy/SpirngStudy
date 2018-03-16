package springstudy.user.test;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springstudy.user.service.UserService;
import springstudy.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class) // singleton�� ApplicationContext �� �����Ѵ�. �Ѱ��� �������ش�.
@ContextConfiguration(locations="classpath:config/beans.xml")//bean ���� ������ ��ġ�� ������ �� ����ϴ� ������̼�

public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;
	
	@Test @Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource)context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void getUserTest() {
		UserVO user = service.getUser("gildong");
		System.out.println(user);
		assertEquals("ȫ�浿", user.getName());
	}
	@Test @Ignore
	public void insertUserTest(){
		service.insertUser(new UserVO("dooly","�Ѹ�","��","���"));
		
		for(UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	@Test
	public void getUserListTest() {
		for(UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	@Test @Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("dooly","��Ѹ�","��","�λ�"));
		
		UserVO user = service.getUser("dooly");
		System.out.println(user);
	}
	
	@Test @Ignore
	public void deleteUserTest() {
		service.deleteUser("dooly");
		
		for(UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
}
