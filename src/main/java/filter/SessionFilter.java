package filter;

import com.springapp.mvc.session.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by chj on 2016/2/22.
 */
public class SessionFilter implements Filter {

    private org.apache.logging.log4j.Logger logger= LogManager.getLogger(SessionFilter.class);

    private static  SessionManager manager=new SessionManager();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        SessionRequest mRequest=new SessionRequest((HttpServletRequest)servletRequest,manager,servletResponse);

        filterChain.doFilter(mRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}


class SessionRequest extends HttpServletRequestWrapper{

    private static String sessionKey="FSESSION";

    private ServletResponse resp;


    private org.apache.logging.log4j.Logger logger= LogManager.getLogger(SessionRequest.class);

    private SessionManager manager;

    public SessionRequest(HttpServletRequest request,SessionManager manager,ServletResponse resp) {
        super(request);
        this.manager=manager;
        this.resp=resp;
    }

    @Override
    public HttpSession getSession(boolean create) {

        logger.info("request getsession "+create);

        return super.getSession(create);
    }

    @Override
    public String getRequestedSessionId()
    {
        HttpServletRequest req=(HttpServletRequest)this.getRequest();

        if(req.getCookies()!=null){

            for(Cookie cookie:req.getCookies())
            {
                if(cookie.getName().equals(sessionKey))
                {
                    return cookie.getValue();
                }
            }
        }

        HttpServletResponse resp=(HttpServletResponse)this.resp;

        String uuid=UUID.randomUUID().toString();

        resp.addCookie(new Cookie(sessionKey,uuid));

        return uuid;
    }


    @Override
    public HttpSession getSession() {

        String sessionId=this.getRequestedSessionId();

        logger.info("sessionId:" + sessionId);

        return manager.getSession(sessionId);
    }

}


