package by.htp.easyfly.filter;


import by.htp.easyfly.bin.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.htp.easyfly.util.ConstantValue.*;

/**
 * Created by Ayumazec on 11.07.2017.
 */
public class AuthenticationFilter implements Filter {
    private String page=PAGE_ERROR_ACCESS_DENIED;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession();

        User user = (User)httpSession.getAttribute(REQUEST_PARAM_SESSION_USER);
        if(user==null || user.getRole()!=null){
            httpServletResponse.sendRedirect(page);
        }
    }

    @Override
    public void destroy() {

    }
}
