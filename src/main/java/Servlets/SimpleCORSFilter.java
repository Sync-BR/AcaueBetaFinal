package Servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleCORSFilter implements Filter  {



    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)  throws IOException, ServletException {
      
        
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");     
        response.setHeader("Content-Type", "*");
         chain.doFilter(req, res);
         
       

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0)  throws ServletException {
    }
}