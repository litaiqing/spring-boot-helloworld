package cn.com.analysys.configuration;

import cn.com.analysys.interceptor.PathHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 15:46
 * @since JDK 1.8
 */
// 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
// @EnableWebMvc
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        // 浏览器发送 /p 请求来到 /page/1/1
        registry.addViewController("/p").setViewName("/page/1/1");
    }

    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean // 将组建注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            // 注册链接跳转
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // super.addViewControllers(registry);
                registry.addViewController("/").setViewName("/p");
            }

            // 注册拦截器

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // super.addInterceptors(registry);
                registry.addInterceptor(new PathHandlerInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/", "/page/**");
            }
        };
        return adapter;
    }

}
