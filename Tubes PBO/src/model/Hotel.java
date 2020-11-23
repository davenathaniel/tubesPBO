/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author
 * 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 * 
 */
public class Hotel {
    private int idHotel;
    private String lokasi;
    private String namaHotel;
    private ArrayList<Room> listRoom;
    
    public Hotel(int idHotel,String lokasi, String namaHotel, ArrayList<Room> listRoom){
        this.idHotel = idHotel;
        this.lokasi = lokasi;
        this.namaHotel = namaHotel;
        this.listRoom = listRoom;
    }

    public Hotel() {
        
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
    public String getLokasi(){
        return lokasi;
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }
    
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    public String getNamaHotel(){
        return namaHotel;
    }
    
    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }
    
    @Override
    public String toString() {
        return "Data Hotel :\n" + "Nama : " + namaHotel + "\nLokasi : " + lokasi;
    }
}
