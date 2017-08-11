package com.weicheng.services;

import com.weicheng.domain.Team;
import com.weicheng.domain.rules.BusinessRuleException;
import com.weicheng.infrastrcture.AppConfig;
import com.weicheng.infrastrcture.AspectConfig;
import com.weicheng.infrastrcture.HibernateConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by Weicheng on 8/10/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        HibernateConfig.class,
        AspectConfig.class,
        AppConfig.class
})
public class TeamServiceTest
{
    @Before
    public void setUp() throws Exception
    {
        List<Team> teamList = teamService.findByName("Juventus FC");
        if(teamList.size() > 0)
        {
            teamId = teamList.get(0).getId();
            return;
        }
        Team team = teamService.createTeam("Juventus FC");
        teamId = team.getId();
    }

    @Test(expected=BusinessRuleException.class)
    public void shouldThrowException_WhenChangeNameToFIFA() throws Exception
    {
        Team team = teamService.getTeam(teamId);
        team.changeName("FIFA");
    }

    @Autowired
    TeamService teamService;

    long teamId;
}