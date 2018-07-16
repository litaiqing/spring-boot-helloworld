package cn.com.analysys.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = Logger.getLogger(MyListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("试图触发 MyListener onApplicationEvent ...");
        // 父容器（Parent为null的容器）启动时将会执行相应的业务操作
        if (event.getApplicationContext().getParent() != null) {
            return;
        }
        logger.info("我是中文 MyListener Event: parent->" + event.getApplicationContext().getParent());
    }

}
