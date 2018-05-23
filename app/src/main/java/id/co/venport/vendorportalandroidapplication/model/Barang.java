package id.co.venport.vendorportalandroidapplication.model;

import android.support.annotation.StringRes;

/**
 * Created by user on 14/05/2018.
 */

public class Barang {
    private String nama;
    private String spesifikasi;
    private String bonus;

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;
    private int harga, stock, id;

    public Barang() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getImage() {
        return image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Barang(String nama, String spesifikasi, int harga, String image, int stock, int id, String bonus) {

        this.nama = nama;
        this.spesifikasi = spesifikasi;
        this.harga = harga;
        this.image = image;
        this.stock = stock;
        this.id = id;
        this.bonus = bonus;
    }
}
