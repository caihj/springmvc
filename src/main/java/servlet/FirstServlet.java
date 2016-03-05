package servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chj on 2016/2/3.
 */
public class FirstServlet extends HttpServlet {

    private Logger logger= LogManager.getLogger(FirstServlet.class);

    public FirstServlet()
    {
        logger.info("{} FirstServlet created", Thread.currentThread().getId());
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.info("{} FirstServlet init with config", Thread.currentThread().getId());
    }


    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("{} FirstServlet init", Thread.currentThread().getId());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("{} recv request  {} {}", Thread.currentThread().getId(), req.getMethod(), req.getRequestURI());
        logger.info("{} recv request  {} {}", Thread.currentThread().getId(), req.getMethod(), req.getRequestURL());

        resp.setContentType("text/json");
        resp.getWriter().write("{\"status\":\"ok\"}");
    }
}
