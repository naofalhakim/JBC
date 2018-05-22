package id.co.venport.vendorportalandroidapplication.model;

/**
 * Created by user on 14/05/2018.
 */

public class Vendor extends User{
    private String deskripsi;
    private int id, image;

    public Vendor() {
    }

    public Vendor(String email, String nama, String alamat, String username, String password, int noHP, String deskripsi, int id, int image) {
        super(email, nama, alamat, username, password, noHP);
        this.deskripsi = deskripsi;
        this.id = id;
        this.image = image;
    }

    public String getDeskripsi() {
        return deskripsi;
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
