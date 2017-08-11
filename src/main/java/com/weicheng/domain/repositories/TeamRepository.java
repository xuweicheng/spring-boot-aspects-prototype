package com.weicheng.domain.repositories;

import com.weicheng.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>
{
    List<Team> findByName(String name);
}
