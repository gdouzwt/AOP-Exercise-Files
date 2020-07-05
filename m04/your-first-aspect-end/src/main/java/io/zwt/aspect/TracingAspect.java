package io.zwt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

    public boolean isEnteringCalled() {
        return enteringCalled;
    }

    Logger logger = LoggerFactory.getLogger(TracingAspect.class);

    boolean enteringCalled = false;

    // 改了 PointCut
    //@Before("execution(* *(..))")
    @Before("execution(public * io.zwt..*(..))")
    public void entering(JoinPoint joinPoint) {
        enteringCalled = true;
        logger.trace("entering " + joinPoint.getStaticPart().getSignature().toString());
    }
}