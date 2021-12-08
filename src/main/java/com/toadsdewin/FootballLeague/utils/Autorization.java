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
            throws IOException, ServletException {

        //Obtain the main PATH
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;

        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        //This variable represents us the main path http//localhost:8080/

        String url = httpServletRequest.getRequestURI();
        if(url.contains("/api/matches") || url.contains("/api/users/login") || url.contains("index"))
        {
            chain.doFilter(request,response);
        }
        else
        {
            String hash = httpServletRequest.getHeader("Authorization");
            if(hash == null || hash.trim().equals(""))
            {
                response.setContentType("application/json");
                String body = "{\"authorization\":\"NO\"}";
                response.getWriter().write(body);
            }
            try
            {
                Jws<Claims> claim = Jwts.parser().setSigningKey(KEY).parseClaimsJws(hash);
                if(url.contains("/api/teams")|| url.contains("/api/matches")&& (!claim.getBody().get("username").equals("")))
                {
                    chain.doFilter(request,response);
                }
            }catch(Exception e)
            {
                response.setContentType("application/json");
                String body="{\"autorizacion\":\"TOKEN NO VALIDO\"}";
                response.getWriter().write(body);
            }
        }
    }
}