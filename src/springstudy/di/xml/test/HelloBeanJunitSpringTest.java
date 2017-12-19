package springstudy.di.xml.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springstudy.di.xml.Hello;
import springstudy.di.xml.Printer;


@RunWith(SpringJUnit4ClassRunner.class) // singleton의 ApplicationContext 를 보장한다. 한개만 생성해준다.
@ContextConfiguration(locations="classpath:config/beans.xml")//bean 설정 파일의 위치를 지정할 때 사용하는 어노테이션
public class HelloBeanJunitSpringTest {
	
	@Autowired //해당 변수에 자봉으로 해당되는 bean을 매핑 해준다.
	private ApplicationContext context; //직접 생성할 필요가없다.
	
	@Test @Ignore
	public void test2() {
		Hello hello = (Hello)context.getBean("hello2");
		
		Hello hello2 = (Hello)context.getBean("hello2");
		
		assertSame(hello, hello2); // 싱글톤으로 관리
		
	}
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		//1.IOC컨테이너 생성
		//2.HelloBean 가져오기
		Hello hello = (Hello)context.getBean("hello2");
		assertEquals("HelloSpring", hello.sayHello());
		assertEquals(3,hello.getNames().size());
		List<String> list = hello.getNames();
		for (String string : list) {
			System.out.println(string);
		}
		hello.print();
		//3. StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class);
		assertEquals("HelloSpring", printer.toString()); // 싱글톤으로 객체가 만들어지기 때문에 HelloSpring이라는 문자열이 toString메소드에 존재함
	}
	

}