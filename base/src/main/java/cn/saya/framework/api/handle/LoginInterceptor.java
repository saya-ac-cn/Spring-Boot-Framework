package cn.saya.framework.api.handle;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String checkName = (String)httpServletRequest.getParameter("name");
        //String sessionCollege= (String) httpServletRequest.getSession().getAttribute("Student");//在session中取出学生的信息
        if (checkName != null) {
            System.out.println("you can go to the Student's controller");
            return true;
        }
        else
        {
            System.err.println("Student's controller tell you Please login");
            //httpServletRequest.getRequestDispatcher("/login.html").forward(httpServletRequest, httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
