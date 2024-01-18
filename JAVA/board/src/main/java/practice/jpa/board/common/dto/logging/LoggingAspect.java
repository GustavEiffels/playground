package practice.jpa.board.common.dto.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Pointcut(
            "execution(* practice.jpa.board.controller..*(..)) || " +
            "execution(* practice.jpa.board.service..*(..))")
    public void commonPointCut() {}

    @Before("commonPointCut()")
    public void beforeCommonPointCut(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        log.info("START METHOD PATH : {}",signature.getDeclaringType()+"."+signature.getName());
    }

    @After("commonPointCut()")
    public void AfterCommonPointCut(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        log.info("END METHOD PATH : {}",signature.getDeclaringType()+"."+signature.getName());
    }

}
