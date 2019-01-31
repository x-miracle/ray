package com.ray.context;

import com.ray.constant.HeaderConstant;
import com.ray.pipeline.PipeLine;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by haiyan@meili-inc.com on 2019/1/30
 */
public class RequestContext {

    private final HttpServletRequest httpServletRequest;

    private final HttpServletResponse httpServletResponse;

    private final AsyncContext asyncContext;

    private final ServletOutputStream outputStream;

    private RequestData requestData;

    private ResponseData responseData;

    private final static Long TIMEOUT = 1000L;


    public RequestContext(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.outputStream = httpServletResponse.getOutputStream();
        this.asyncContext = httpServletRequest.startAsync();
        try {
            httpServletRequest.setCharacterEncoding(HeaderConstant.ENCODE);
        } catch (UnsupportedEncodingException e) {

        }
        this.asyncContext.setTimeout(TIMEOUT);
        this.asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {

            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {

            }

            @Override
            public void onError(AsyncEvent event) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }
        });


    }

    public RequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void writeResponse(){

    }


    public void start(final PipeLine pipeLine){
        this.asyncContext.start(()->{
            pipeLine.fireFilter();
            this.asyncContext.complete();
        });
    }
}
