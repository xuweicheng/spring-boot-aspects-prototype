package com.weicheng.controllers;

import com.weicheng.domain.Team;
import com.weicheng.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Weicheng on 8/10/2017.
 */
@RestController
public class TeamController
{
    @Autowired
    TeamService teamService;

    @RequestMapping(method = {RequestMethod.GET}, value = "/Teams/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Team getTeamById(@PathVariable long id){
        Team team = teamService.getTeam(id);
        return team;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/Team/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String updateTeam(@PathVariable long id, @PathVariable String name)
    {
        try
        {
            teamService.changeTeam(id, name);
        }catch(Exception e)
        {
            return "Team name changed failed." + e.getMessage();
        }

        return "Team name changed successfully.";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Team/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String createTeam(@PathVariable String name)
    {
        try
        {
            Team team = teamService.createTeam(name);
        }catch(Exception e)
        {
            return "Create team failed." + e.getMessage();
        }
        return "Create team successfully.";
    }
}
