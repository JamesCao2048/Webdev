package org.junming.bookstore.model;

/**
 * Created by john on 2016/7/7 0007.
 */
public class User {

    private String id;
    private String password;
    private String name;
    private String gender;
    private String email;
    private int age;

    public User(){}

    public User(String id,String p, String n, String g, String e, int a){
        this.id = id;
        this.password=p;
        this.email=e;
        this.age=a;
        this.gender=g;
        this.name=n;
    }
    public void setId(String id) {this.id=id;}
    public String getId(){return id;}
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return this.gender;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String toString()
    {
        return "id " + getId()+" password:  " + getPassword() +
                " email: "+getEmail() + " age: " + getAge() +" gender: " + getGender()
                +" name: "+getName();
    }

}
