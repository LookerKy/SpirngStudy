package springstudy.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

//Around Advice
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable {
		//Ÿ��(�����Ͻ� ����) �޼����� signature ����
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "����");
		//Ÿ���� �޼��尡 ȣ��Ǳ� ���� �ð�
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		}finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + "����ð� : " + (finish-start) + "ms");
		}
		
	}
}
