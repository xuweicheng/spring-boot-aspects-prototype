package com.weicheng.services;

import com.weicheng.domain.Team;

import java.util.List;

/**
 * Created by Weicheng on 8/10/2017.
 */
public interface TeamService
{
    Team createTeam(String name);
    Team changeTeam(long id, String name);

    Team getTeam(long id);

    List<Team> findByName(String name);
}
