package com.ray.filter;

import com.ray.context.RequestContext;

/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
public class ParseFilter extends AbstractFilter{
    @Override
    public void invoke(RequestContext requestContext) {
        System.out.println("parse ");
    }
}
