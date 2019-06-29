package com.example.baka57r.ezpy;

/**
 * Created by baka57r on 05/01/2019.
 */

public class TransaksiEzpy {
    private String _id;
    private String penjual;
    private String pembeli;
    private String tgl_transaksi;
    private String bulan_transaksi;
    private String tahun_transaksi;
    private String jumlah_transaksi;
    private String __v;

    public TransaksiEzpy(String _id, String penjual, String pembeli, String tgl_transaksi, String bulan_transaksi, String tahun_transaksi, String jumlah_transaksi, String __v) {
        this._id = _id;
        this.penjual = penjual;
        this.pembeli = pembeli;
        this.tgl_transaksi = tgl_transaksi;
        this.bulan_transaksi = bulan_transaksi;
        this.tahun_transaksi = tahun_transaksi;
        this.jumlah_transaksi = jumlah_transaksi;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public String getPenjual() {
        return penjual;
    }

    public String getPembeli() {
        return pembeli;
    }

    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    public String getBulan_transaksi() {
        return bulan_transaksi;
    }

    public String getTahun_transaksi() {
        return tahun_transaksi;
    }

    public String getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public String get__v() {
        return __v;
    }
}
