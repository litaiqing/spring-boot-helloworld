package cn.com.analysys.bean;

import org.springframework.boot.ExitCodeGenerator;
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
public class MyExitCodeGenerator implements ExitCodeGenerator {

    /**
     * 如果希望在应用程序结束时返回特定的退出代码，那么bean可以实现org.springframework.boot.ExitCodeGenerator接口。
     * 
     * @return
     */
    @Override
    public int getExitCode() {
        return 666;
    }
}
