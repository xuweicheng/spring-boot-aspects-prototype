package com.weicheng.domain.factories;

import com.weicheng.domain.Team;

/**
 * Created by Weicheng on 8/10/2017.
 */
public interface TeamFactory
{
    Team create(String name);
}
