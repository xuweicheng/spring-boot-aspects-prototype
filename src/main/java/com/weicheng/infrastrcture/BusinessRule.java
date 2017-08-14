package com.weicheng.infrastrcture;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Weicheng on 8/14/2017.
 */
@Aspect
public abstract class BusinessRule
{
    void check(JoinPoint joinPoint){}
}
