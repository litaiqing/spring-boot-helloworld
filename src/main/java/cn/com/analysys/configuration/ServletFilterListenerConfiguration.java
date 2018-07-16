package cn.com.analysys.configuration;

import cn.com.analysys.filter.SimpleFilter;
import cn.com.analysys.listener.SimpleServletRequestListener;
import cn.com.analysys.servlet.SimpleServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Description: 注册Servlet三大组件【Servlet、Filter、Listener】
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 16:34
 * @since JDK 1.8
 */
@Configuration
public class ServletFilterListenerConfiguration {

    /**
     * 注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new SimpleServlet(), "/servlet");
    }

    /**
     * 注册Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SimpleFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/p", "/servlet"));
        return filterRegistrationBean;
    }

    /**
     * 注册Listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SimpleServletRequestListener> servletListenerRegistrationBean
                = new ServletListenerRegistrationBean<>(new SimpleServletRequestListener());
        return servletListenerRegistrationBean;
    }

}
