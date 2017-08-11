package com.weicheng.infrastrcture;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Weicheng on 8/10/2017.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.weicheng.domain.factories",
        "com.weicheng.services"
})
public class AppConfig
{
}
