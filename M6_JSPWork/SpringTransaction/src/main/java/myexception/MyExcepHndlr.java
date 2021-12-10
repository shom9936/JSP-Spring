package myexception;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class MyExcepHndlr extends Exception{
	
	public void process(JoinPoint thisJoinPoint, Exception exception) throws Exception{
		Signature sign = thisJoinPoint.getSignature();
		
		System.out.println("---[Exception]" + sign.getDeclaringTypeName()
						+ " : " + sign.getName() + "---");
		
		// 등록된 상품이 없습니다(remain_not)
		// 재고가 부족합니다(remain_lack)
		String msg = exception.getMessage();
		System.out.println(msg);
	} // process()
}
