package springstudy.di.xml;


public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();
	
	public void print(String message) {
		buffer.append(message);
	}
	public String toString() {
		return buffer.toString();
	}
}
