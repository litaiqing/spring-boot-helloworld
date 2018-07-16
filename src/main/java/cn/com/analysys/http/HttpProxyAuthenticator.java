package cn.com.analysys.http;

import org.springframework.beans.factory.annotation.Value;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Description: 代理验证类
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
public class HttpProxyAuthenticator extends Authenticator {

    private String username;

    private String password;

    public HttpProxyAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }

}
