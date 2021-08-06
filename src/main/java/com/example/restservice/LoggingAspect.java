package com.example.restservice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(GreetingController.class.getName());

    @Around("execution(public Greeting greeting(..))")
    public Object checkRestControllerMethod(ProceedingJoinPoint jp) throws Throwable {
        Object[] inParametrs = jp.getArgs();
        for(Object i : inParametrs) {
            logger.info("args into method " + i);
        }
        Object outParametrs = jp.proceed();
        logger.info("arg out of method " + outParametrs);
        return  outParametrs;
    }


}
