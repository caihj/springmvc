package com.springapp.mvc.session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chj on 2016/2/22.
 */
public class SessionManager {

    private Logger logger= LogManager.getLogger(SessionManager.class);

    private Map<String,LocalSession> store=new HashMap<String, LocalSession>();

    public LocalSession getSession(String sessionId)
    {
        logger.info("getSession");
        if(store.get(sessionId)==null)
        {
            logger.info("create new session");
            LocalSession session=new LocalSession();
            store.put(sessionId,session);
            return  session;
        }
        else
        {
            logger.info("return exist session");
            return store.get(sessionId);
        }
    }


    public Map<String, LocalSession> getStore() {
        return store;
    }

    public void setStore(Map<String, LocalSession> store) {
        this.store = store;
    }
}
