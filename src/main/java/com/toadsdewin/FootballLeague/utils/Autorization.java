package com.toadsdewin.FootballLeague.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class Autorization implements Filter
{
    public static final String KEY = "trolololo";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
        {
            //Hey, let's get the main path
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            //http://localhost:8080/
            String url =httpServletRequest.getRequestURI();

            //Let's show if the following directions is going to be public
            if(url.contains ("/api/matches") || url.contains("/api/users") || url.contains("/api/users/login") || url.contains("index"))
            {
                chain.doFilter(request,response);
            }
            else
            {
                try
                {

                }catch (Exception e)
                {
                    
                }
            }
        }
    }


