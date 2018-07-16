package cn.com.analysys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Description: <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 16:03
 * @since JDK 1.8
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
@ApiIgnore
public class BasicErrorController extends AbstractErrorController {

    public BasicErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    private static final Logger logger = Logger.getLogger(BasicErrorController.class);

    @Value("${server.error.path:${error.path:/error}}")
    private static String errorPath = "/error";

    @RequestMapping(produces = "text/html")
    public ModelAndView handleHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    private static final String PATTERN_500_PATH = "/**";
    private static final String PATTERN_404_PATH = "/**";

    /**
     * 500 错误
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView serverError(HttpServletRequest request, HttpServletResponse response, Exception ex)
            throws Exception {
        PathMatcher matcher = new AntPathMatcher();
        String reuqestPath = request.getServletPath();
        if (matcher.match(PATTERN_500_PATH, reuqestPath)) {
            logger.error("500 Server Error !!! -> " + reuqestPath);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String msg = objectMapper.writeValueAsString("Hello Error!");
            return handleJSONError(response, msg, HttpStatus.OK);
        } else {
            throw ex;
        }
    }

    /**
     * 404 未找到
     */
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> notFound(HttpServletRequest request, HttpServletResponse response, Exception ex)
            throws Exception {
        logger.error("404 Not Fount !!! -> " + request.getServletPath());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String msg = objectMapper.writeValueAsString("Hello Not Found!");
        handleJSONError(response, msg, HttpStatus.OK);
        return null;
    }

    /**
     * 参数不完整
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView methodArgumentNotValidException(HttpServletRequest request, HttpServletResponse response,
                                                        MethodArgumentNotValidException ex) throws Exception{
        PathMatcher matcher = new AntPathMatcher();
        String reuqestPath = request.getRequestURL().toString();
        if(matcher.match(PATTERN_404_PATH, reuqestPath)) {
            BindingResult bindingResult = ex.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuffer msg = new StringBuffer();
            fieldErrors.stream().forEach(f -> msg.append("[").append(f.getField()).append(",").append(f.getDefaultMessage()).append("]"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return handleJSONError(response, msg.toString(), HttpStatus.OK);
        } else {
            throw ex;
        }
    }

    /**
     * JSON 信息输出
     * 
     * @param rsp
     * @param errorMessage
     * @param status
     * @return
     * @throws IOException
     */
    protected ModelAndView handleJSONError(HttpServletResponse rsp, String errorMessage, HttpStatus status)
            throws IOException {
        rsp.setCharacterEncoding("UTF-8");
        rsp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        rsp.setStatus(status.value());
        PrintWriter writer = rsp.getWriter();
        writer.write(errorMessage);
        writer.flush();
        writer.close();
        return null;
    }

}
