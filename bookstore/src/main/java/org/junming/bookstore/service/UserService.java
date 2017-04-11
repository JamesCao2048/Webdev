package org.junming.bookstore.service;

import org.junming.bookstore.model.User;

import java.util.List;

/**
 * Created by john on 2017/3/17 0017.
 */
public interface UserService {

    public User getUserById(String id);
    public boolean ifExist(String id);
    public boolean checkMatch(String id, String pw);
    public boolean insertUser(User u);
    public List<User> getUsers();
    public boolean ifAdm(String id);

}
