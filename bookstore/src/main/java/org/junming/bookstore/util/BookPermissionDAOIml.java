package org.junming.bookstore.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 2017/3/19 0019.
 */

public class BookPermissionDAOIml implements BookPermissionDAO {
    @Override
    public List<String> getPermissionByRoleList(List<String> roles ) throws Exception{
        Map<String,List<String>> map= LoadBookPermission.loadBookPermission();
        List<String> result= new ArrayList<String>();
        for(String role: roles)
            result.addAll(map.get(role));
        return result;
    }
}
