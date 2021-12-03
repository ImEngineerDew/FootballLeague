package com.toadsdewin.FootballLeague.utils;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class Autorization implements Filter
{
    public static final String KEY = "trolololo";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Obtain the main PATH
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //This variable represents us the main path http//localhost:8080/

        String url = httpServletRequest.getRequestURI();
        if(url.contains("/api/matches") || url.contains("/api/users/login") || url.contains("index"))
        {
            chain.doFilter(request,response);
        }
    }
}
