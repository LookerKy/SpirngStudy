package springstudy.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Hello {
	@Value("${myname}")
	private String name;
//	@Autowired //������ type�� �������� �޾ƿ´� �׷��⶧���� ���� stringprinter �� consolePrinter�� ���ÿ� ������
//	@Qualifier("stringPrinter") //consoleprinter�� stringPrinter �� ����� Ŭ���� ��� 
	@Resource(name="${printer1}") //properties ���Ͽ� �������ִ� ������ ������ ������� �� ����ϴ� ������̼�
	private Printer printer;
	
	@Resource(name="list")
	private List<String> names;
	
	public List<String> getNames() {
		return names;
	}
	
	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
}
