package cn.com.analysys.http;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.Authenticator;

/**
 * Description: HTTP代理
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */

public class HttpProxy {

    @Value("http.proxy.host")
    private String proxyHost;

    @Value("http.proxy.port")
    private String proxyPort;

    @Value("http.proxy.non.hosts")
    private String nonHosts;

    @Value("http.proxy.auth.username")
    private String username;

    @Value("http.proxy.auth.password")
    private String password;


    private Logger logger = Logger.getLogger(HttpProxy.class);

    /**
     * 打开代理
     */
    public void openProxy() {

        logger.info("open http proxy");
        logger.info("proxyHost = " + proxyHost);
        logger.info("proxyPort = " + proxyPort);
        logger.info("nonHosts = " + nonHosts);
        logger.info("username = " + username);
        logger.info("password = " + password);


        // 设置代理服务器地址
        System.setProperty("http.proxyHost", proxyHost);

        // 设置代理端口
        System.setProperty("http.proxyPort", proxyPort);

        // 设置不需要代理的主机地址
        System.setProperty("http.nonProxyHosts", nonHosts);

        // 设置代理用户名和密码
        Authenticator.setDefault(new HttpProxyAuthenticator(username, password));

    }

}
