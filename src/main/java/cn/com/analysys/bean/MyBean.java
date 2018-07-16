package cn.com.analysys.bean;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
@Component
public class MyBean {

    private Logger logger  = Logger.getLogger(MyBean.class);

    /**
     * ApplicationArguments接口提供对原始String []参数以及解析选项和非选项参数的访问
     * @param args
     */
    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        if (debug) {
            List<String> argsList = args.getNonOptionArgs();
            argsList.stream().forEach(a -> logger.debug(a));
        }
    }

}
