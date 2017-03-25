package com.addev.mysqlmelodic.minebrary;

/**
 * Created by MySQL Melodic on 23/09/2016.
 */
public class Jadwal {
    private String makul, jam, rate;
    private int imageUrl,bintang;

    public Jadwal(){

    }

    public Jadwal(int imageUrl, String makul, String jam, int bintang, String rate){
        this.imageUrl = imageUrl;
        this.makul = makul;
        this.jam = jam;
        this.bintang = bintang;
        this.rate = rate;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getBintang() {
        return bintang;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
