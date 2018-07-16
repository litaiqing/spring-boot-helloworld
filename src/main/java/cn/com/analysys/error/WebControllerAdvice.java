package cn.com.analysys.error;

import javax.servlet.http.HttpServletRequest;

import cn.com.analysys.error.exception.PathNoFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Description: 可以定义一个@ControllerAdvice来自定义为特定控制器 and/or 异常类型返回的JSON文档 <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
@ControllerAdvice(basePackages = "cn.com.analysys.controller")
public class WebControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PathNoFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>("WebControllerAdvice -> " + ex.getMessage(), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("java.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
