package spring.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Before("execution(public * springstudy..*(..))")
	public void before(JoinPoint joinpoint) {
		String signatureString = joinpoint.getSignature().getName();
		for (Object arg : joinpoint.getArgs())
			System.out.println("@Before [ " + signatureString + " ] �ƱԸ�Ʈ" + arg);
	}
	@AfterReturning(pointcut="execution(public * springstudy.user.service.*.*(..))",returning="ret")
	public void afterReturning(JoinPoint joinPoint , Object ret) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ "+signatureString + " ] �޼��� ���� ��ó�� ����");
		System.out.println("@AfterReturning [ "+signatureString + " ] ���ϰ� ="+ ret);
		
	}
	@AfterThrowing(pointcut="execution(* *..UserService*.*(..))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ "+signatureString + " ] �޼��� ���� �� ���� �߻�");
		System.out.println("@AfterReturning [ "+signatureString + " ] ���� ="+ ex.getMessage());
	}
	
	@After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@After [ "+signatureString+" ] �޼��� ���� �Ϸ�");
	}
	
}
