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


@RunWith(SpringJUnit4ClassRunner.class) // singleton�� ApplicationContext �� �����Ѵ�. �Ѱ��� �������ش�.
@ContextConfiguration(locations="classpath:config/beans.xml")//bean ���� ������ ��ġ�� ������ �� ����ϴ� ������̼�
public class HelloBeanJunitSpringTest {
	
	@Autowired //�ش� ������ �ں����� �ش�Ǵ� bean�� ���� ���ش�.
	private ApplicationContext context; //���� ������ �ʿ䰡����.
	
	@Test @Ignore
	public void test2() {
		Hello hello = (Hello)context.getBean("hello2");
		
		Hello hello2 = (Hello)context.getBean("hello2");
		
		assertSame(hello, hello2); // �̱������� ����
		
	}
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		//1.IOC�����̳� ����
		//2.HelloBean ��������
		Hello hello = (Hello)context.getBean("hello2");
		assertEquals("HelloSpring", hello.sayHello());
		assertEquals(3,hello.getNames().size());
		List<String> list = hello.getNames();
		for (String string : list) {
			System.out.println(string);
		}
		hello.print();
		//3. StringPrinter Bean ��������
		Printer printer = context.getBean("printer",Printer.class);
		assertEquals("HelloSpring", printer.toString()); // �̱������� ��ü�� ��������� ������ HelloSpring�̶�� ���ڿ��� toString�޼ҵ忡 ������
	}
	

}