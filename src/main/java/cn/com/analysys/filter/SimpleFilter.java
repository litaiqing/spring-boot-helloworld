package cn.com.analysys.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 16:37
 * @since JDK 1.8
 */
public class SimpleFilter implements Filter {

    private Logger logger = Logger.getLogger(SimpleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("SimpleFilter init -> " + filterConfig.getInitParameterNames());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("SimpleFilter doFilter -> " + request.getParameterNames());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("SimpleFilter destroy <- ");
    }
}
