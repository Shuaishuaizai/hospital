package com.kkb.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author xiaoyou
 * @date 2021/4/24
 * @time 15:19
 */
@Aspect
@Component
@Slf4j
public class WebLogConfig {

        @Pointcut("execution(public * com.kkb.controller.*.*(..))")
        public void logPointCut() {
        }

        @Before("logPointCut()")
        public void doBefore(JoinPoint joinPoint) throws Throwable {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            // 记录下请求内容
            log.info("请求地址 : " + request.getRequestURL().toString());
            log.info("HTTP METHOD : " + request.getMethod());
            log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName());
            log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));

        }

        @AfterReturning(returning = "ret", pointcut = "logPointCut()")
        public void doAfterReturning(Object ret) throws Throwable {
            log.info("返回值 : " + ret);
        }

        @Around("logPointCut()")
        public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
            long startTime = System.currentTimeMillis();
            Object ob = pjp.proceed();
            log.info("耗时 : " + (System.currentTimeMillis() - startTime));
            return ob;
        }
}


