package com.example.simple_member.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Slf4j
public class saveAop {
    @Around("execution(* com.example.simple_member..save*(..)))")
    public Object saveCall(ProceedingJoinPoint jp) throws Throwable{
        try{
            return jp.proceed();
        }finally {
            log.info("Save method Execute");
        }

    }
}
