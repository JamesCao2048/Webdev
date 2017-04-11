package org.junming.bookstore.util;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by john on 2017/3/19 0019.
 */

public interface BookPermissionDAO {

    public List<String> getPermissionByRoleList(List<String> roles) throws Exception;
}
