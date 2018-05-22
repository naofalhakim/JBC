package id.co.venport.vendorportalandroidapplication.model;

/**
 * Created by user on 14/05/2018.
 */

public class User {
    private String email, nama, alamat, username, password;
    private int noHP;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public int getNoHP() {
        return noHP;
    }

    public void setNoHP(int noHP) {
        this.noHP = noHP;
    }

    public User(String email, String nama, String alamat, String username, String password, int noHP) {

        this.email = email;
        this.nama = nama;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
        this.noHP = noHP;
    }

    public User() {

    }
}
