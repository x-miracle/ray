package com.ray.pipeline;


import com.ray.filter.AbstractFilter;
import com.ray.filter.Filter;

/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
public interface PipeLine {

    void fireFilter();


    PipeLine addNext(AbstractFilter filter);
}
