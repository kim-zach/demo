package com.kimi.demo.aop;


import com.kimi.demo.result.R;
import com.kimi.demo.utils.JwtUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录验证AOP
 */
@Component
@Aspect
public class LoginCheck {

    private static Logger logger = LogManager.getLogger(LoginCheck.class.getName());

    @Pointcut("within(com.kimi.demo.controller..*)")
    // IndexController中写了登录方法
    public void login() {
    }

    @Around("login()")
    public Object auth(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURL = request.getRequestURL().toString();
        logger.info("requestURL:{}",requestURL);
        if("http://localhost:8081/aopController/login".equals(requestURL)){
            return joinPoint.proceed();
        }
        String token = request.getHeader("token");

        if(token == null || !JwtUtils.checkToken(token)) {
            logger.info("未登录");
            return R.error().message("未登录");
        }
        logger.info("token: " + token);
        return joinPoint.proceed();
    }
}
