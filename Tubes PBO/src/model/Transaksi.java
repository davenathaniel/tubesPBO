/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.enums.StatusBookingEnum;

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
    private int idPerson;
    private Date tanggal_Booking;
    private Date checkIn;
    private Date checkOut;
    private int jumlahOrang;
    private int idJenisPembayaran;
    private int idHotel;
    private StatusBookingEnum status; 

    public Transaksi(){
    
    }
    
    public Transaksi(int idTransaksi, int idHotel, int idPerson, Date tanggal_Booking, Date checkIn, Date checkOut, int jumlahOrang, int idJenisPembayaran, int no_Kamar, StatusBookingEnum status) {
        this.idTransaksi = idTransaksi;
        this.no_Kamar = no_Kamar;
        this.idPerson = idPerson;
        this.tanggal_Booking = tanggal_Booking;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.jumlahOrang = jumlahOrang;
        this.idJenisPembayaran = idJenisPembayaran;
        this.idHotel = idHotel;
        this.status = status;
    }
    
    public Transaksi(int no_Kamar, int idPerson, Date tanggal_Booking, Date checkIn, Date checkOut, int jumlahOrang, int idJenisPembayaran, int idHotel, StatusBookingEnum status) {
        this.no_Kamar = no_Kamar;
        this.idPerson = idPerson;
        this.tanggal_Booking = tanggal_Booking;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.jumlahOrang = jumlahOrang;
        this.idJenisPembayaran = idJenisPembayaran;
        this.idHotel = idHotel;
        this.status = status;
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

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public void setStatus(StatusBookingEnum status) {
        this.status = status;
    }

    public StatusBookingEnum getStatus() {
        return status;
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
