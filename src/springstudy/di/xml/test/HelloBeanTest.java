package springstudy.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springstudy.di.xml.Hello;
import springstudy.di.xml.Printer;



public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.IOC�����̳� ����
		@SuppressWarnings("resource")
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		//2.HelloBean ��������
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		//3. StringPrinter Bean ��������
		Printer printer = context.getBean("printer",Printer.class);
		System.out.println(printer.toString());
		
		Hello hello2 =context.getBean("hello",Hello.class);
		System.out.println(hello==hello2);
		
	}

}