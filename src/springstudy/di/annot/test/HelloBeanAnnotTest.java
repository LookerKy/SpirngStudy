package springstudy.di.annot.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springstudy.di.annot.Hello;
import springstudy.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/annot.xml")
public class HelloBeanAnnotTest {
	
	@Autowired
	private ApplicationContext context ;
	
	@Test
	public void test() {
		Hello hello = context.getBean("hello",Hello.class);
		assertEquals("HelloSpring", hello.sayHello());
		hello.print();
		List<String> list = hello.getNames();
		for (String string : list) {
			System.out.println(string);
		}
		Printer printer = context.getBean("stringPrinter",Printer.class);
		System.out.println(printer.toString());
	}
}
