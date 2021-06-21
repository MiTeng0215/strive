package com.miteng.strive.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CalculatorAspect {
//    @Before("execution(public int com.miteng.strive.aop.MyCalculator.*(int, int))")
//    public static void logStart(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();//参数名
//        Signature signature = joinPoint.getSignature();//方法签名,方法详细信息
//        String name = signature.getName();
//        System.out.println(name+"方法开始执行...参数:"+ Arrays.asList(args));
//    }
//    @AfterReturning(value = "execution(public int com.miteng.strive.aop.MyCalculator.*(int, int))", returning = "result")
//    public static void result(JoinPoint joinPoint, Object result) {
//        System.out.println("结果返回..."+result);
//    }
//    @AfterThrowing("execution(public int com.miteng.strive.aop.MyCalculator.*(int, int))")
//    public static void logException() {
//        System.out.println("方法出现异常...");
//    }
//    @After("execution(public int com.miteng.strive.aop.MyCalculator.*(int, int))")
//    public static void afterInvoke() {
//        System.out.println("方法执行结束...");
//    }

    @Around(value = "execution(public int com.miteng.strive.aop.MyCalculator.*(int, int))" )
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        //这里前置
        Object proceed = null;
        System.out.println("开始执行");
        try {
            proceed = pjp.proceed(args);//这里相当于对象原方法的执行
            System.out.println("结果.."+ proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常通知
        }
        //这里结果返回
        //方法结束
        System.out.println("方法结束");
        return proceed;
    }
}
