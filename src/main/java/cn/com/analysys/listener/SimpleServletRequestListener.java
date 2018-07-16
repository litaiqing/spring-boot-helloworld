package cn.com.analysys.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 16:40
 * @since JDK 1.8
 */
public class SimpleServletRequestListener implements ServletRequestListener {

    private Logger logger = Logger.getLogger(SimpleServletRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("SimpleServletListener requestDestroyed -> " + sre.getServletRequest().getParameterNames());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("SimpleServletListener requestInitialized -> " + sre.getServletRequest().getParameterNames());
    }

}
