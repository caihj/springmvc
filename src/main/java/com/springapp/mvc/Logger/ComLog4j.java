package com.springapp.mvc.Logger;

import org.apache.commons.logging.Log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.net.Priority;


/**
 * Created by chj on 2016/2/3.
 */
public class ComLog4j implements Log {


    private static final String FQCN = ComLog4j.class.getName();

    /** Log to this logger */
    private transient volatile Logger logger = null;

    /** Logger name */
    private final String name;



    public ComLog4j(String name)
    {
        this.name=name;
    }

    public ComLog4j(Logger logger)
    {
        this.logger=logger;
        this.name=logger.getName();
    }

    public Logger getLogger() {
        Logger result = logger;
        if (result == null) {
            synchronized(this) {
                result = logger;
                if (result == null) {
                    logger = result = LogManager.getLogger(name);
                }
            }
        }
        return result;
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.TRACE</code>.
     * When using a log4j version that does not support the <code>TRACE</code>
     * level, the message will be logged at the <code>DEBUG</code> level.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#trace(Object)
     */
    public void trace(Object message) {
        getLogger().log(Level.TRACE,message,null);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.TRACE</code>.
     * When using a log4j version that does not support the <code>TRACE</code>
     * level, the message will be logged at the <code>DEBUG</code> level.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#trace(Object, Throwable)
     */
    public void trace(Object message, Throwable t) {
        getLogger().log(Level.TRACE,message, t);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.DEBUG</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#debug(Object)
     */
    public void debug(Object message) {
        getLogger().log(Level.DEBUG, message, null);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.DEBUG</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#debug(Object, Throwable)
     */
    public void debug(Object message, Throwable t) {
        getLogger().log( Level.DEBUG, message, t);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.INFO</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#info(Object)
     */
    public void info(Object message) {
        getLogger().log( Level.INFO, message, null);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.INFO</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#info(Object, Throwable)
     */
    public void info(Object message, Throwable t) {
        getLogger().log(Level.INFO, message, t);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.WARN</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#warn(Object)
     */
    public void warn(Object message) {
        getLogger().log( Level.WARN, message, null);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.WARN</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#warn(Object, Throwable)
     */
    public void warn(Object message, Throwable t) {
        getLogger().log( Level.WARN, message, t);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.ERROR</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#error(Object)
     */
    public void error(Object message) {
        getLogger().log( Level.ERROR, message, null);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.ERROR</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#error(Object, Throwable)
     */
    public void error(Object message, Throwable t) {
        getLogger().log( Level.ERROR, message, t);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.FATAL</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#fatal(Object)
     */
    public void fatal(Object message) {
        getLogger().log(Level.FATAL, message, null);
    }

    /**
     * Logs a message with <code>org.apache.log4j.Priority.FATAL</code>.
     *
     * @param message to log
     * @param t log this cause
     * @see org.apache.commons.logging.Log#fatal(Object, Throwable)
     */
    public void fatal(Object message, Throwable t) {
        getLogger().log( Level.FATAL, message, t);
    }
    /**
     * Is debug logging currently enabled?
     * <p/>
     * Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than debug.
     *
     * @return true if debug is enabled in the underlying logger.
     */
    @Override
    public boolean isDebugEnabled() {
       return  getLogger().isDebugEnabled();
    }

    /**
     * Is error logging currently enabled?
     * <p/>
     * Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than error.
     *
     * @return true if error is enabled in the underlying logger.
     */
    @Override
    public boolean isErrorEnabled() {
        return  getLogger().isErrorEnabled();
    }

    /**
     * Is fatal logging currently enabled?
     * <p/>
     * Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than fatal.
     *
     * @return true if fatal is enabled in the underlying logger.
     */
    @Override
    public boolean isFatalEnabled() {
        return  getLogger().isFatalEnabled();
    }

    /**
     * Is info logging currently enabled?
     * <p/>
     * Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than info.
     *
     * @return true if info is enabled in the underlying logger.
     */
    @Override
    public boolean isInfoEnabled() {
        return  getLogger().isInfoEnabled();
    }

    /**
     * Is trace logging currently enabled?
     * <p/>
     * Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than trace.
     *
     * @return true if trace is enabled in the underlying logger.
     */
    @Override
    public boolean isTraceEnabled() {
        return  getLogger().isTraceEnabled();
    }

    /**
     * Is warn logging currently enabled?
     * <p/>
     * Call this method to prevent having to perform expensive operations
     * (for example, <code>String</code> concatenation)
     * when the log level is more than warn.
     *
     * @return true if warn is enabled in the underlying logger.
     */
    @Override
    public boolean isWarnEnabled() {
        return  getLogger().isWarnEnabled();
    }

}
