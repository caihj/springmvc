package com.springapp.mvc.session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by chj on 2016/2/22.
 */
public class LocalSession implements HttpSession {

    private Map<String,Object> store=new HashMap<String, Object>();;

    private int i;

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return this.hashCode()+"0";
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int i) {
        this.i=i;
    }

    @Override
    public int getMaxInactiveInterval() {
        return i;
    }

    /**
     * @deprecated
     */
    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return store.get(s);
    }

    /**
     * @param s
     * @deprecated
     */
    @Override
    public Object getValue(String s) {
        return store.get(s);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    /**
     * @deprecated
     */
    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String s, Object o) {
        store.put(s,o);
    }

    /**
     * @param s
     * @param o
     * @deprecated
     */
    @Override
    public void putValue(String s, Object o) {
        store.put(s,o);
    }

    @Override
    public void removeAttribute(String s) {
        store.remove(s);
    }

    /**
     * @param s
     * @deprecated
     */
    @Override
    public void removeValue(String s) {
        store.remove(s);
    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
