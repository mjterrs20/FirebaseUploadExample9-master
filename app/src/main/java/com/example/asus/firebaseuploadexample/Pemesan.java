package com.example.asus.firebaseuploadexample;

public class Pemesan {

    private String Name;
    private String Noktp;
    private String Jumlah;
    private String Norek;

    public Pemesan(){

    }

    public Pemesan(String name, String noktp, String jumlah, String norek){
        this.Name = name;
        this.Noktp = noktp;
        this.Jumlah = jumlah;
        this.Norek = norek;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public String getNoktp() {
        return Noktp;
    }

    public void setNoktp(String noktp) {
        Noktp = noktp;
    }

    public String getNorek() {
        return Norek;
    }

    public void setNorek(String norek) {
        Norek = norek;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }



}
