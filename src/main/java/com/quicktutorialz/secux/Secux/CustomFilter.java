package com.quicktutorialz.secux.Secux;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter("/AuthenticationFilter")
public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request   = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String pathInfo = request.getServletPath();
        String[] pathParts = pathInfo.split("/");

        if((JwtUtils.getJwtFromHttpRequest(request) == null) && !"signin.html".equals(pathParts[pathParts.length - 1])){
            response.sendRedirect("http://localhost:8684/signin.html");
            return;
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {System.out.println("Init do Filter");}

    @Override
    public void destroy() {}

}
