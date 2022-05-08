package com.o7planning.SpringBootRoutingDS.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//33 DataSourceInterceptor sẽ phân tích URL của request, và quyết định Datasource nào sẽ được sử dụng.
public class DataSourceInterceptor extends HandlerInterceptorAdapter {

    // Request:

    // /nganhangs1/list
    // /nganhangs2/list
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String contextPath = request.getServletContext().getContextPath();

        // /SomeContextPath/NGANHANGS1
        String prefixNganHangS1 = contextPath + "/benthanh";

        // /SomeContextPath/NGANHANGS2
        String prefixNganHangS2 = contextPath + "/tandinh";
        
        String uri = request.getRequestURI();
        
        // System.out.println("URI:"+ uri);
        
        if(uri.startsWith(prefixNganHangS1)) {
            request.setAttribute("keyDS", "BENTHANH_DS");
        }
        else if(uri.startsWith(prefixNganHangS2)) {
            request.setAttribute("keyDS", "TANDINH_DS");
        }

        return true;
    }

}