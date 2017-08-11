package com.weicheng.services;

import com.weicheng.domain.Team;
import com.weicheng.domain.factories.TeamFactory;
import com.weicheng.domain.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Service
public class TeamServiceImpl implements TeamService
{
    @Override
    @Transactional
    public Team createTeam(String name)
    {
        Team team = teamFactory.create(name);

        teamRepository.save(team);

        return team;
    }

    @Override
    @Transactional
    public Team changeTeam(long id, String name)
    {
        Team team = teamRepository.findOne(id);

        team.changeName(name);

        return team;
    }

    @Override
    public Team getTeam(long id)
    {
        Team team = teamRepository.findOne(id);

        return team;
    }

    @Override
    public List<Team> findByName(String name)
    {
        List<Team> teamList = teamRepository.findByName(name);

        return teamList;
    }

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TeamFactory teamFactory;
}
