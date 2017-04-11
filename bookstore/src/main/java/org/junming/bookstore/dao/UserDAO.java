package org.junming.bookstore.dao;

import org.apache.ibatis.annotations.Param;
import org.junming.bookstore.model.Adm;
import org.junming.bookstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by john on 2016/7/7 0007.
 */
@Repository
public interface UserDAO {
    //public boolean ifExist(String username);
    //public boolean checkMatch(String username, String password);
    //public boolean insertUser(User u);
    public User getUserById(@Param("id") String id);
    public boolean insertUser(@Param("user") User user);
    public List<User> getUsers();
    public Adm getAdmById(@Param("id") String id);
}
