package id.co.venport.vendorportalandroidapplication.model;

import java.util.ArrayList;

/**
 * Created by user on 23/05/2018.
 */

public class Vendor extends User {
    private String namaVendor;
    private ArrayList<Barang> barangs;

    public Vendor(String email, String nama, String alamat, String username, String password, String noHP, String namaVendor) {
        super(email, nama, alamat, username, password, noHP);
        this.namaVendor = namaVendor;
        this.barangs = new ArrayList();
    }

    public Vendor(String namaVendor, ArrayList<Barang> barangs) {
        this.namaVendor = namaVendor;
        this.barangs = barangs;
    }

    public Vendor() {
    }

    public String getNamaVendor() {
        return namaVendor;
    }

    public void setNamaVendor(String namaVendor) {
        this.namaVendor = namaVendor;
    }

    public void tambahBarang(Barang barang){
        barangs.add(barang);
    }

    public void isiBarang(ArrayList<Barang> barang){
        this.barangs = barang;
    }

    public Barang getBarang(int i){
        return barangs.get(i);
    }

    public ArrayList<Barang> getBarangs() {
        return barangs;
    }
}
