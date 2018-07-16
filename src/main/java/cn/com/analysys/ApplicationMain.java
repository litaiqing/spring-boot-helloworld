package cn.com.analysys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;

import cn.com.analysys.http.HttpProxy;

/**
 * @ClassName ApplicationMain
 * @Description
 * @Author litaiqing
 * @Date 2018/7/9 14:01
 * @Version 1.0
 **/
@SpringBootApplication
public class ApplicationMain
        extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationMain.class);
    }

    /**
     * Test
     *
     * @param args
     */
    public static void main(String[] args) {

        // 完全禁用重新启动支持
        // System.setProperty("spring.devtools.restart.enabled", "false");

        // SpringApplication app = new SpringApplication(ApplicationMain.class);

        // 关闭 Banner
        // app.setBannerMode(Banner.Mode.OFF);

        // 使用自定义 Banner
        // app.setBanner(new MyBanner());

        // 启动 Spring Boot
        // app.run(args);
        // SpringApplication.run(ApplicationMain.class, args);
        SpringApplication app = new SpringApplication(ApplicationMain.class);
        // app.addListeners(new MyListener());
        app.setWebEnvironment(true);
        app.run(args)
           .getBean(HttpProxy.class)
           .openProxy();

    }

}
