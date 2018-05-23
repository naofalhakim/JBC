package id.co.venport.vendorportalandroidapplication.model;

/**
 * Created by user on 14/05/2018.
 */

public class Sandang {
    private String nama, deskripsi;
    private int id, image, harga;

    public Sandang() {
    }

    public Sandang(String nama, String deskripsi, int id, int image, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.id = id;
        this.image = image;
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
