package krd.antonov.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* krd.antonov.controllers.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* krd.antonov.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* krd.antonov.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        logger.info("=====>> in @Before: calling method" + joinPoint.getSignature().toShortString());
        for (Object arg :
                joinPoint.getArgs()) {
            logger.info("=====>> with argument: " + arg);
        }
    }
}
