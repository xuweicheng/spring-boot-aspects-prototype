package com.weicheng.domain.factories;

import com.weicheng.domain.Team;
import org.springframework.stereotype.Component;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Component
public class TeamFactoryImpl implements TeamFactory
{
    @Override
    public Team create(String name)
    {
        Team team = new Team(name);

        return team;
    }
}
