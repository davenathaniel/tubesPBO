/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author
 * 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 * 
 */
public class Room {
    private String tipeKamar;
    private int noKamar;
    private int batasOrang;
    private int harga;
    
    public Room(String tipeKamar,int noKamar, int batasOrang, int harga){
        this.tipeKamar = tipeKamar;
        this.noKamar = noKamar;
        this.batasOrang = batasOrang;
        this.harga = harga;
    }

    public Room() {
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public String getTipeKamar(){
        return tipeKamar;
    }
    
    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }
    
    public int getNoKamar(){
        return noKamar;
    }
    
    public void setNoKamar(int noKamar) {
        this.noKamar = noKamar;
    }
    
    public int getBatasOrang(){
        return batasOrang;
    }
    
    public void setLokasi(int batasOrang) {
        this.batasOrang = batasOrang;
    }
    
    @Override
    public String toString() {
        return "\nNo Kamar : " + noKamar + "\nTipe : " + tipeKamar + "\nHarga : " + harga + "\nBatas Guest : " + batasOrang;
    }
}
