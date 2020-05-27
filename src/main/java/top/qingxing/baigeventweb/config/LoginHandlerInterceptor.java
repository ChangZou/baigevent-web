package top.qingxing.baigeventweb.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.qingxing.baigeventweb.domain.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: baigevent-web
 * @Package: top.qingxing.baigeventweb.config
 * @ClassName: LoginHandlerInterceptor
 * @Author: Sober
 * @Description:
 * @Date: 2020/5/27 14:25
 * @Version: 0.0.1
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    private String[] strings = {"/login","/reg","/api/v1/login","/api/v1/reg"};
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        System.out.println("执行了TestInterceptor的preHandle方法");
        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
            UserEntity user=(UserEntity)request.getSession().getAttribute("loginUser");
            if(user!=null){
                for (String s : strings){
                    if (request.getRequestURI().equals(s)){
                        response.sendRedirect(request.getContextPath()+"/");
                    }
                }
                return true;
            }else {
                for (String s : strings){
                    if (request.getRequestURI().equals(s)){
                        return true;
                    }
                }
            }
            response.sendRedirect(request.getContextPath()+"/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }

}
