package cn.com.analysys.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * Description:默认的安全配置在SecurityAutoConfiguration和从那里导入的类中实现（用于Web安全的SpringBootWebSecurityConfiguration和用于认证配置的AuthenticationManagerConfiguration，这在非Web应用程序中也是相关的）。
 * 要完全关闭默认的Web应用程序安全配置，您可以使用@EnableWebSecurity添加一个bean（这不会禁用身份验证管理器配置或Actuator的安全性）。
 * 要定制它，您通常使用WebSecurityConfigurerAdapter类型的外部属性和bean（例如添加基于表单的登录）。
 * 要关闭身份验证管理器配置，您可以添加AuthenticationManager类型的bean，或者通过将AuthenticationManagerBuilder自动连接到您的一个@Configuration类中的方法来配置全局AuthenticationManager。
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
@Configuration
public class SecurityBean /*extends WebSecurityConfiguration*/ {







}
