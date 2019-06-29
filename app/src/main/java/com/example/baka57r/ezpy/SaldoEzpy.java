package com.example.baka57r.ezpy;

/**
 * Created by baka57r on 01/01/2019.
 */

public class SaldoEzpy {
    private String _id;
    private String email;
    private String name;
    private String jumlah_uang;
    private String __v;
    private String role;

    public SaldoEzpy(String id, String emil, String namee, String jumang, String vvvv, String rolee)
    {
        this._id = id;
        this.email = emil;
        this.name = namee;
        this.jumlah_uang = jumang;
        this.__v = vvvv;
        this.role = rolee;
    }

    public String get_id() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getJumlah_uang() {
        return jumlah_uang;
    }

    public String get__v() {
        return __v;
    }

    public String getRole() {
        return role;
    }
}
