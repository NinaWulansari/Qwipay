package com.example.baka57r.ezpy;

/**
 * Created by baka57r on 11/10/2018.
 */

public class Users {
    String username;
    String password;

    public Users()
    {

    }

    public Users(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsers()
    {
        return username;
    }

    public String getPass()
    {
        return password;
    }

    public void SetUsers(String username)
    {
        this.username = username;
    }

    public void SetPass(String password)
    {
        this.password = password;
    }
}
