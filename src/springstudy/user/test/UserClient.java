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

@RunWith(SpringJUnit4ClassRunner.class) // singleton의 ApplicationContext 를 보장한다. 한개만 생성해준다.
@ContextConfiguration(locations="classpath:config/beans.xml")//bean 설정 파일의 위치를 지정할 때 사용하는 어노테이션

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
		assertEquals("홍길동", user.getName());
	}
	@Test @Ignore
	public void insertUserTest(){
		service.insertUser(new UserVO("dooly","둘리","남","경기"));
		
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
		service.updateUser(new UserVO("dooly","김둘리","여","부산"));
		
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
