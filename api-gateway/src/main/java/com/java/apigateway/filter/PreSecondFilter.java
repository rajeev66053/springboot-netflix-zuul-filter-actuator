package com.java.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

//We don't want to excute this filter now so we have not added @Configuration annotation
//@Configuration
public class PreSecondFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PreSecondFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("[PreSecondfilter]Request method = {}, url = {}", request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}