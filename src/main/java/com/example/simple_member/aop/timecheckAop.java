package com.example.simple_member.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class timecheckAop {
    @Around("execution(* com.example.simple_member..*(..))")
    public Object timecheck(ProceedingJoinPoint jp) throws Throwable{
        Long start = System.currentTimeMillis();

        try{
            System.out.println("Start :"+jp.toString());
            return  jp.proceed();

        } finally {

            Long end = System.currentTimeMillis();
            Long time = end-start;
            System.out.println("End :"+jp.toString()+","+time+"ms");
        }

    }
}
