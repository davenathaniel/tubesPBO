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
    private int jumlahOrang;
    private int lamaInap;
    
    public Room(String tipeKamar,int noKamar, int jumlahOrang, int lamaInap){
        this.tipeKamar = tipeKamar;
        this.noKamar = noKamar;
        this.jumlahOrang = jumlahOrang;
        this.lamaInap = lamaInap;
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
    
    public int getJumlahOrang(){
        return jumlahOrang;
    }
    
    public void setLokasi(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }
    
    public int getLamaMenginap(){
        return lamaInap;
    }
    
    public void setLamaInap(int lamaInap) {
        this.lamaInap = lamaInap;
    }
}
