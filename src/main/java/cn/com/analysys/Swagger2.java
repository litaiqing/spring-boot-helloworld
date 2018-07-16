package cn.com.analysys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/12 13:44
 * @since JDK 1.8
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                                                      .select()
                                                      //.apis(RequestHandlerSelectors.basePackage("cn.com.analysys"))
                                                      //.paths(PathSelectors.any())
                                                      .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Hello World RESTful APIs")
                                   .description("我是备注,这个是我的测试项目")
                                   .termsOfServiceUrl("http://www.baidu.com/")
                                   .contact("BanTom")
                                   .version("1.0")
                                   .build();
    }

}
