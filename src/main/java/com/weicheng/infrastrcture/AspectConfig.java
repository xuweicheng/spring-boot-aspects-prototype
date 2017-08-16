package com.weicheng.infrastrcture;

import com.weicheng.domain.rules.TeamNameCanNotBeFIFA;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class AspectConfig
{
//    The following bean config for the aspect is NOT working with LTW.
//    According to this post https://stackoverflow.com/questions/30413186/nosuchmethoderror-with-aspectj
//    An aspect needs to be woven, then aspectOf method is generated for this aspect.
    @Bean
    public TeamNameCanNotBeFIFA teamNameCanNotBeFIFA()
    {
        TeamNameCanNotBeFIFA teamNameCanNotBeFIFA = Aspects.aspectOf(TeamNameCanNotBeFIFA.class);
        return teamNameCanNotBeFIFA;
    }
}
