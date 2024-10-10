package ru.apzakharov.comfort_soft.demo.application.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private static final org.apache.logging.log4j.Logger log
            = org.apache.logging.log4j.LogManager.getLogger(ApplicationExceptionHandler.class);

    @Pointcut("@within(ru.apzakharov.comfort_soft.demo.application.annotation.UseCase)")
    public void useCasePointcut() {
    }

    @Around("useCasePointcut()")
    public Object aroundCallAt(ProceedingJoinPoint pjp) throws Throwable {
        Object useCase = pjp.getTarget();
        Object[] useCaseArgs = pjp.getArgs();

        log.info("Use case: {} with args: {} started", useCase.getClass().getSimpleName(), Arrays.toString(useCaseArgs));
        Object proceed = pjp.proceed(useCaseArgs);
        log.info("Use case: {} with args: {} finished result: {}", useCase.getClass().getSimpleName(), Arrays.toString(useCaseArgs), proceed);

        return proceed;
    }
}
