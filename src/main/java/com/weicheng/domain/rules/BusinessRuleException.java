package com.weicheng.domain.rules;

/**
 * Created by Weicheng on 8/10/2017.
 */
public class BusinessRuleException extends RuntimeException
{
    public BusinessRuleException(String message)
    {
        super(message);
    }
}
