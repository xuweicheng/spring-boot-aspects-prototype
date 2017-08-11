package com.weicheng.domain.rules;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Aspect
public class TeamNameCanNotBeFIFA
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
