package cn.com.analysys.configuration;

import cn.com.analysys.http.HttpProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
@Configuration
@PropertySource({ "classpath:properties/project.properties" })
public class BeanConfiguration {

    @Value("${index.result}")
    private String testValue;

    @Bean
    public String test() {
        return testValue;
    }

    // @Bean
    // public MyListener myListener() {
    // return new MyListener();
    // }

    @Bean
    @ConditionalOnClass(HttpProxy.class)
    public HttpProxy httpProxy() {
        return new HttpProxy();
    }

    /**
     * 跨原始资源共享（CORS）是大多数浏览器实现的W3C规范
     * 通过使用自定义的addCorsMappings(CorsRegistry)方法注册WebMvcConfigurer bean来定义全局CORS配置
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/");
            }
        };
    }


    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        // 定制嵌入式的Servlet容器相关的规则
        return container -> container.setPort(8080);
    }

}
