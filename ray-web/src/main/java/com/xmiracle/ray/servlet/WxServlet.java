package com.xmiracle.ray.servlet;

import com.ray.context.RequestContext;
import com.ray.pipeline.PipeLine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
@WebServlet(name="wxServlet",urlPatterns = "/wx/*",asyncSupported = true)
public class WxServlet extends MainServlet{

    @Override
    protected PipeLine defaultPipeLine(RequestContext requestContext) {
        return super.defaultPipeLine(requestContext);
    }

    @Override
    protected RequestContext createRequestContext(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return super.createRequestContext(req, resp);
    }
}
