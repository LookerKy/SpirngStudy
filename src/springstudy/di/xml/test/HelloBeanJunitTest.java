package springstudy.di.xml.test;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springstudy.di.xml.Hello;
import springstudy.di.xml.Printer;
import static org.junit.Assert.*;



public class HelloBeanJunitTest {

	private ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	@Test
	public void test2() {
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		assertSame(hello, hello2); // �̱������� ����
		
	}
	@Test @Ignore
	public void test1() {
		// TODO Auto-generated method stub
		//1.IOC�����̳� ����
		//2.HelloBean ��������
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("HelloSpring", hello.sayHello());
		hello.print();
		//3. StringPrinter Bean ��������
		Printer printer = context.getBean("printer",Printer.class);
		assertEquals("HelloSpring", printer.toString());
	}
	

}