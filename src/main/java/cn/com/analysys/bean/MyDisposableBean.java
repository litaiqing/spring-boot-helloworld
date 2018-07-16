package cn.com.analysys.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
@Component
public class MyDisposableBean implements DisposableBean {

    private Logger logger = Logger.getLogger(MyDisposableBean.class);

    /**
     * 每个SpringApplication将注册一个JVM关闭钩子，以确保ApplicationContext在退出时正常关闭。
     * 可以使用所有标准的Spring生命周期回调（例如DisposableBean接口或@PreDestroy注释）
     * 
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        logger.info("JVM is exit!!!");
    }
}
