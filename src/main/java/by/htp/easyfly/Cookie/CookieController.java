package by.htp.easyfly.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static by.htp.easyfly.util.ConstantValue.*;

/**
 * Created by Ayumazec on 11.07.2017.
 */
public class CookieController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies;
        cookies = request.getCookies();
        if(cookies!=null && checkCookieExists(cookies))
        {
            searchCookie(cookies,request);
        }
        else {
            HttpSession session = request.getSession(true);
            String cookieValue= (String) session.getAttribute(REQUEST_PARAM_SESSION_USERNAME);
            if(cookieValue!=null) {
                setCookie(response, cookieValue); // create cookie
                // Extracting cookies and adding information to the request
                request.setAttribute(COOKIE_PARAM_USER_NAME, cookieValue);
            }
        }
    }

    private void setCookie(HttpServletResponse resp,String cookieValue){
        Cookie c = new Cookie(COOKIE_PARAM_USER_NAME, cookieValue);
        c.setMaxAge(60 * 60); // lifecycle cookie 1 hour
        c.setValue(cookieValue);
        resp.addCookie(c); // Add a cookie to the response object
    }
    private static void searchCookie(Cookie[] cookies, HttpServletRequest request){
        Cookie cookie;
        String param;
        for (Cookie cooky : cookies) {
            param = cooky.getName();
            if (param.equals(COOKIE_PARAM_USER_NAME)) {
                cookie = cooky;
                String value = cookie.getValue();
                request.setAttribute(COOKIE_PARAM_USER_NAME, value);
            }
        }
    }
    private boolean checkCookieExists(Cookie[] cookies){
        String param;
        boolean cookieExist=false;
        for (Cookie cooky : cookies) {
            param = cooky.getName();
            if (param.equals(COOKIE_PARAM_USER_NAME)) {
                cookieExist = true;
            }
        }
        return cookieExist;
    }
}
