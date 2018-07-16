package cn.com.analysys.servlet;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/11 16:35
 * @since JDK 1.8
 */
public class SimpleServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(SimpleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("SimpleServlet doGet -> " + req.getServletPath());
        resp.getWriter().write("This is Simple Servlet Get Data");
    }

}
