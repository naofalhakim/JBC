package id.co.venport.vendorportalandroidapplication.model;

/**
 * Created by user on 14/05/2018.
 */

public class Event {
    private String judul, deskripsi, tempat, waktu, pembuat, status, tanggal;
    private int id,image;

    public Event() {
    }

    public Event(String judul, String deskripsi, String tempat, String waktu, String pembuat, int id, int gambar, String status, String tanggal) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tempat = tempat;
        this.waktu = waktu;
        this.pembuat = pembuat;
        this.id = id;
        this.image = gambar;
        this.status = status;
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getPembuat() {
        return pembuat;
    }

    public void setPembuat(String pembuat) {
        this.pembuat = pembuat;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
