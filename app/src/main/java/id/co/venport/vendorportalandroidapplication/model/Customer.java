package id.co.venport.vendorportalandroidapplication.model;

/**
 * Created by user on 14/05/2018.
 */

public class Customer extends User {
    private String TTL, noKtp;

    public Customer(String TTL) {
        this.TTL = TTL;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public Customer(String email, String nama, String alamat, String username, String password, int noHP, String TTL, String noKtp) {
        super(email, nama, alamat, username, password, noHP);
        this.TTL = TTL;
        this.noKtp = noKtp;
    }
}
