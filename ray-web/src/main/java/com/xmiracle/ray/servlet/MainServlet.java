package com.xmiracle.ray.servlet;

import com.ray.RayRunner;
import com.ray.context.RequestContext;
import com.ray.filter.*;
import com.ray.pipeline.DefautPipeLine;
import com.ray.pipeline.PipeLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
@WebServlet(name="mainServlet",urlPatterns = "/ray/*",asyncSupported = true)
public class MainServlet extends HttpServlet{

    private RayRunner rayRunner;

    private static Logger LOGGER = LoggerFactory.getLogger(MainServlet.class);


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

       /* String bufferReqsStr = config.getInitParameter("buffer-requests");
        boolean bufferReqs = bufferReqsStr != null && bufferReqsStr.equals("true") ? true : false;
*/
        rayRunner = new RayRunner();
    }

    protected RequestContext createRequestContext(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return new RequestContext(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestContext requestContext = createRequestContext(req,resp);
        rayRunner.run(requestContext,defaultPipeLine(requestContext));
    }


    protected PipeLine defaultPipeLine(RequestContext requestContext){
        AbstractFilter filter = new ParseFilter();
        return new DefautPipeLine(filter,requestContext)
                .addNext(new PermisionFilter())
                .addNext(new FlowLimitFilter());
    }



}
