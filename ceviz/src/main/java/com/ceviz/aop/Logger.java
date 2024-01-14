package com.ceviz.aop;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Component
@Log4j2
@Aspect
@Slf4j
public class Logger {

    @Pointcut("execution(* com.ceviz.controller.*.*(..))")
    public void controllerPointCut() {
    }

    @Around("(controllerPointCut())")
    public Object controllerLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            log.log(Level.INFO, Arrays.toString(proceedingJoinPoint.getArgs()) + "Sayın Yolcularımız, Requestimiz "
                    + proceedingJoinPoint.getTarget() + "'a iniş yapmak üzeredir." +
                    " Lütfen validasyonlarınızı hazırlayınız.");

            proceedingJoinPoint.proceed();
        } catch (Exception e) {
            log.log(Level.ERROR, "PÜÜ PATLADIK. İşlem yapılırken bir hata oluştu. Hata mesajımız: " + e.getMessage());
        } finally {
            stopWatch.stop();
            log.log(Level.INFO, "İşlemlerin tamamlanması " + stopWatch.getTotalTimeSeconds() + " saniye sürdü.");
        }
        return null;
    }

}
