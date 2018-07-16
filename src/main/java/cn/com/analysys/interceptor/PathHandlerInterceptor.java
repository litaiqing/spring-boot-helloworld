package cn.com.analysys.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 路径拦截器
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 15:56
 * @since JDK 1.8
 */
public class PathHandlerInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(PathHandlerInterceptor.class);

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("PathHandlerInterceptor preHandle -> " + request.getServletPath());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
