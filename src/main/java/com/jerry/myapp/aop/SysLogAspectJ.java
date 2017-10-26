package com.jerry.myapp.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //该注解标示该类为切面类 
@Component //注入依赖
public class SysLogAspectJ {
	
	@Pointcut("execution(* com.jerry.myapp.controller.*.*(..))")  
    public void checkToken(){  
    }  
	
	@Before("checkToken()") 
	public void beforeCheckToken(){  
        System.out.println("调用方法之前。。。。");  
    }
	
    @AfterReturning("checkToken()")  
    public void afterCheckToken(){  
        System.out.println("调用方法结束之后。。。。");  
    }  

}
