/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author
 * 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 * 
 */
public class Transaksi {
    private int idTransaksi;
    private int no_Kamar;
    private int idUser;
    private Date tanggal_Booking;
    private Date checkIn;
    private Date checkOut;
    private int jumlahOrang;
    private int idJenisPembayaran;

    public Transaksi(){
    
    }
    
    public Transaksi(int idTransaksi, int no_Kamar, int idUser, Date tanggal_Booking, Date checkIn, Date checkOut, int jumlahOrang, int idJenisPembayaran) {
        this.idTransaksi = idTransaksi;
        this.no_Kamar = no_Kamar;
        this.idUser = idUser;
        this.tanggal_Booking = tanggal_Booking;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.jumlahOrang = jumlahOrang;
        this.idJenisPembayaran = idJenisPembayaran;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getNo_Kamar() {
        return no_Kamar;
    }

    public void setNo_Kamar(int no_Kamar) {
        this.no_Kamar = no_Kamar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getTanggal_Booking() {
        return tanggal_Booking;
    }

    public void setTanggal_Booking(Date tanggal_Booking) {
        this.tanggal_Booking = tanggal_Booking;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public int getIdJenisPembayaran() {
        return idJenisPembayaran;
    }

    public void setIdJenisPembayaran(int idJenisPembayaran) {
        this.idJenisPembayaran = idJenisPembayaran;
    }
    
    
    
    
}
