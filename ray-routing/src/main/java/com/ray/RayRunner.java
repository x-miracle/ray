package com.ray;

import com.ray.context.RequestContext;
import com.ray.pipeline.PipeLine;


/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
public class RayRunner {



    public void run(RequestContext requestContext, PipeLine pipeLine){
        requestContext.start(pipeLine);
    }
}
