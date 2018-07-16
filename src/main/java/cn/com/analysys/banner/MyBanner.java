package cn.com.analysys.banner;

import java.io.IOException;
import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${tsme}
 * @since JDK 1.8
 */
public class MyBanner implements Banner {

    @Override
    public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {

        String text = "My banner is low !!!";

        try {
            printStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
