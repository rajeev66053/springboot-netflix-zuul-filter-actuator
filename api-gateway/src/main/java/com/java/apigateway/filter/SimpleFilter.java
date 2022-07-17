package com.java.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

//We don't want to excute this filter now so we have not added @Configuration annotation
//@Configuration
public class SimpleFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
    static Random rand = new Random();
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctxt = RequestContext.getCurrentContext();
        String param = ctxt.getRequest().getParameter("deviceType");
        return param != null && param.equals("BrokenDevice") ? true : true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("Inside simple filter..");
        try {
            Thread.sleep(rand.nextInt(20000)); // Sleep for a random number of seconds between [0-20]
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}