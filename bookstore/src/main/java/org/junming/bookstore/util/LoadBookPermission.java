package org.junming.bookstore.util;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Created by john on 2017/3/19 0019.
 */
public class LoadBookPermission {
    public static Map<String,List<String>> loadBookPermission() throws Exception{
        Map<String,List<String>> result=new HashMap<String, List<String>>();

        Properties bookPerm= new Properties();
        String path=new File("").getCanonicalPath();
        System.out.println("new file path:" + new File("").getCanonicalPath());
        //new FileInputStream("/ToDoList");
        bookPerm.load(new FileInputStream("permission/bookPermission.properties"));
        Properties bookType= new Properties();
        bookType.load(new FileInputStream("permission/bookType.properties"));

        Enumeration e= bookPerm.propertyNames();
        while(e.hasMoreElements()){
            String ek=e.nextElement().toString();
            List<String> p=new ArrayList<>(Arrays.asList(bookPerm.getProperty(ek).split(",")));
            result.put(ek,p);
        }

        e=bookType.propertyNames();
        while(e.hasMoreElements()){
            String ek=e.nextElement().toString();
            List<String> matchedRoles= matchPrototype(result,ek);
            for(String role : matchedRoles)
                result.get(role).addAll(Arrays.asList(bookType.getProperty(ek).split(",")));
        }
        return result;
    }

    public static List<String> matchPrototype(Map<String,List<String>> map, String prototype){
        List<String> matchedRoles = new ArrayList<String>();

        for(String k: map.keySet()){
            if(map.get(k).contains(prototype))
                matchedRoles.add(k);
        }
        return matchedRoles;
    }
}
