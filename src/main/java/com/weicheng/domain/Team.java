package com.weicheng.domain;

import javax.persistence.*;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Entity
@Table(name = "team")
public class Team
{
    public Team(String name)
    {
        this.name = name;
    }

    private Team()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public void changeName(String name)
    {
        this.name = name;
    }

    public long getId()
    {
        return id;
    }
}
