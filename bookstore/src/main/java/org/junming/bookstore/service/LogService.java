package org.junming.bookstore.service;

/**
 * Created by drjr on 17-4-14.
 */
public interface LogService {
    public void logInfo(Class name, String msg);
    public void logDebug(Class name, String msg);
    public void logErr(Class name, String msg);
}
