package com.game.game;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class Notice {

    @Around("execution(public * com.game.game.controller.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object[] args = joinPoint.getArgs();
        Object proceed = joinPoint.proceed(args);

//        log.info(Arrays.toString(args));
        long end = System.currentTimeMillis();
        log.info("用时:"+(end-start));
        return proceed;
    }

    @After(value = "execution(public * com.game.game.controller.*.*(..))")
    public void printTime(JoinPoint point){

        Object[] args = point.getArgs();
//        System.out.println(args.length);
        log.info("====执行方法为："+point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
//        User/index 为空参数
        if (args.length != 0){
            log.info("====执行操作为："+ args[0]);
        }
        log.info("==============================");
//        log.info("                               ");
//        System.out.println("+++++++++++++");
//        log.info(point.getSourceLocation().getFileName());
//        获取方法名字
//        log.info(point.getThis().getClass().getName());
    }


}
