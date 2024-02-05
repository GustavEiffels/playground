package practice.jpa.board.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class LoggingAspect {

    private final LogDto log;

    @Pointcut(
            "execution(* practice.jpa.board.controller..*(..)) || " +
            "execution(* practice.jpa.board.service..*(..))")
    public void commonPointCut() {}

    @Before("commonPointCut()")
    public void beforeCommonPointCut(JoinPoint joinPoint) {
        Signature signature  = joinPoint.getSignature();
        String    classPath  = signature.getDeclaringTypeName().replace("practice.jpa.board.","");
        String    methodName = signature.getName();
        log.info("METHOD START",classPath+"."+methodName);
    }

    @After("commonPointCut()")
    public void AfterCommonPointCut(JoinPoint joinPoint) {
        Signature signature  = joinPoint.getSignature();
        String    classPath  = signature.getDeclaringTypeName().replace("practice.jpa.board.","");
        String    methodName = signature.getName();
        log.info("METHOD OVER",classPath+"."+methodName);
    }

}
