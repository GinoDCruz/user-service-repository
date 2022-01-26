package com.ibm.maill.user.entity;

public class User {

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public User(){}

    public User(Long id, String username, String password, String firstName, String lastname){
        this.id = id;
        this.username= username;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
