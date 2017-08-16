package com.weicheng.domain.rules;

import com.weicheng.domain.repositories.TeamRepository;
import com.weicheng.infrastrcture.BusinessRule;
import com.weicheng.services.TeamService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Aspect
@Component
//@Order(2) order doesn't work when LTW two aspects to one pointcut
public class TeamNameCanNotBeFIFA extends BusinessRule
{
    //Added here to see if autowired worked, checked when debug
    @Autowired
    TeamRepository teamRepository;

    //Added here to see if autowired worked, checked when debug
    @Autowired
    TeamService teamService;

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
