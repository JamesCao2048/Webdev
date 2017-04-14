package org.junming.bookstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by drjr on 17-4-14.
 */
@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class LogServiceIml implements LogService {
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void logInfo(Class name, String msg){
        LoggerFactory.getLogger(name).info(msg);
    }
    @Override
    public void logDebug(Class name, String msg){
        LoggerFactory.getLogger(name).debug(msg);
    }
    @Override
    
    public void logErr(Class name, String msg){
        LoggerFactory.getLogger(name).error(msg);
    }
}
