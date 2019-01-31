package com.ray.pipeline;

import com.ray.context.RequestContext;
import com.ray.filter.AbstractFilter;

/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
public class DefautPipeLine implements PipeLine {

     AbstractFilter head;

    AbstractFilter tail;

    private final RequestContext requestContext;


    public DefautPipeLine(AbstractFilter head, RequestContext requestContext) {
        this.head = head;
        this.requestContext = requestContext;
        this.tail = this.head;
    }

    @Override
    public void fireFilter() {
        AbstractFilter executor = head;
        while (executor!=null){
            executor.invoke(requestContext);
            executor = executor.next;
        }
    }

    @Override
    public PipeLine addNext(AbstractFilter filter) {
        this.tail.next = filter;
        return this;
    }
}
