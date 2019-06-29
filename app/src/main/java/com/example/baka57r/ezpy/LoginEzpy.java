package com.example.baka57r.ezpy;
/**
 * Created by baka57r on 01/01/2019.
 */

public class LoginEzpy {
    private String Nama;
    private String token;
    private String Role;

    public LoginEzpy(String nama, String token, String rolee){
        this.Nama = nama;
        this.token = token;
        this.Role = rolee;
    }

    public String getNama() {
        return Nama;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return Role;
    }
}
