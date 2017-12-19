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
//	@Autowired //변수의 type을 기준으로 받아온다 그러기때문에 현재 stringprinter 와 consolePrinter가 동시에 존재함
//	@Qualifier("stringPrinter") //consoleprinter와 stringPrinter 중 사용할 클래스 명시 
	@Resource(name="${printer1}") //properties 파일에 지정되있는 내용을 가지고 오고싶을 때 사용하는 어노태이션
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
