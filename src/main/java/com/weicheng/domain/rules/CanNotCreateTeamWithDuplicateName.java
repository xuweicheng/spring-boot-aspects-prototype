package com.weicheng.domain.rules;

import com.weicheng.domain.Team;
import com.weicheng.domain.repositories.TeamRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Aspect
@Component
public class CanNotCreateTeamWithDuplicateName
{
    @Before("execution(* com.weicheng.domain.factories.TeamFactory.create(String))")
    public void check(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = (String) args[0];
        List<Team> teamList = teamRepository.findByName(name);
        if(teamList.size() > 0)
        {
            throw new BusinessRuleException("Can not create team with duplicate name.");
        }
    }

    @Autowired
    TeamRepository teamRepository;
}
