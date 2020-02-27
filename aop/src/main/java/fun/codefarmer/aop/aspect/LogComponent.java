package fun.codefarmer.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ @ClassName LogComponent
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/27 16:47
 **/
@Component
//切面
@Aspect
public class LogComponent {
    //定义拦截规则

    /**
     * 第一个 * 方法的返回值任意
     * 第二个参数，方法位置
     *      fun.codefarmer.aop.service.*    这个包下的任意类里面的任意方法，
     *      (..)方法的参数任意：参数类型任意，参数个数任意
     */
    @Pointcut("execution(* fun.codefarmer.aop.service.*.*(..))")
    public void pc1() {

    }
    /**
     * aop 中有五种通知：
     * 前置通知
     */
    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println("before--方法名："+name);
    }

    /**
     * 后置通知
     * @param jp
     */
    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println("after--方法名："+name);
    }

    /**
     * 返回通知：有返回参数时
     * returning 获取方法返回值时什么
     * @param jp
     */
    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result) {
        String name = jp.getSignature().getName();
        System.out.println("afterReturning--方法名："+name+"--result"+result);
    }

    /**
     * 异常通知
     * 如果想要收到所有通知就用异常的父类：Exception
     * @param jp
     */
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e) {
        String name = jp.getSignature().getName();
        System.out.println("afterThrowing--方法名："+name+"--Exception"+e);
    }

    /**
     * 环绕通知:相当与上三种集合
     *
     * @param pjp
     */
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //前置通知
        //写在前面
        Object proceed = pjp.proceed();
        //后置通知
        //写在后面
        return proceed;
    }

}
