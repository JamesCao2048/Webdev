package org.junming.bookstore.service;

import org.junming.bookstore.dao.UserDAO;
import org.junming.bookstore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2016/7/7 0007.
 */
@Service
@Transactional
public class UserServiceIml implements UserService, UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceIml.class);
    @Autowired
    private UserDAO userDAO;
    @Override
    public boolean ifExist(String id){
        return userDAO.getUserById(id)!=null;
    }
    @Override
    public boolean checkMatch(String id, String pw){
        if(ifExist(id)){
            /*logger.info(id+":"+pw);
            logger.info(userDAO.getUserById(id).getPassword());
            logger.info(userDAO.getUserById(id).getPassword().equals(pw)?"true":"false");
            System.out.println(id+":"+pw);
            System.out.println(userDAO.getUserById(id).getPassword());
            System.out.println(userDAO.getUserById(id).getPassword().equals(pw));*/
        return userDAO.getUserById(id).getPassword().equals(pw);}
        else
        return false;
    }
    @Override
    public boolean insertUser(User u){
        return userDAO.insertUser(u);
    }
    @Override
    public User getUserById(String id){
        //System.out.println(id);
        return userDAO.getUserById(id);
    }
    @Override
    public List<User> getUsers(){
        return userDAO.getUsers();
    }

    @Override
    public boolean ifAdm(String id){
            return userDAO.getAdmById(id)!=null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        if(userDAO==null)
            throw new UsernameNotFoundException("dao is null");
        User user= getUserById(username);
        if(user !=null){
            List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if(ifAdm(username))
                authorities.add(new SimpleGrantedAuthority("ROLE_ADM"));
        return new org.springframework.security.core.userdetails.User(user.getId(),user.getPassword(),authorities);
        }
        throw new UsernameNotFoundException("User '"+username+"'not found.");
    }
}
