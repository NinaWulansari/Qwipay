package com.example.baka57r.ezpy;

/**
 * Created by baka57r on 03/01/2019.
 */

public class DaftarEzpy {
    private String _id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String loggedIn;
    private String __v;

    public DaftarEzpy(String ide, String namee, String emaile, String passworde, String rolee, String loggedE, String vE)
    {
        this._id = ide;
        this.name = namee;
        this.email = emaile;
        this.password = passworde;
        this.role = rolee;
        this.loggedIn = loggedE;
        this.__v = vE;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getLoggedIn() {
        return loggedIn;
    }

    public String get__v() {
        return __v;
    }
}
