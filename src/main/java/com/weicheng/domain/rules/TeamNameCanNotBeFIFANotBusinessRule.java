package com.weicheng.domain.rules;

import com.weicheng.infrastrcture.BusinessRule;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Aspect
//@Order(3) order doesn't work when LTW two aspects to one pointcut
public class TeamNameCanNotBeFIFANotBusinessRule
{
    @Before("execution(* com.weicheng.domain.Team.changeName(String))")
    public void check(JoinPoint joinPoint) throws Throwable
    {
        Object[] args = joinPoint.getArgs();
        String name = (String) args[0];

        if(name.toUpperCase().equals("FIFA"))
        {
            throw new BusinessRuleException("Team name can not be FIFA.");
        }
    }
}
