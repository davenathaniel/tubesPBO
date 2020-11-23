/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CheckController;
import static controller.DataController.*;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class TransaksiManager {

    private static TransaksiManager instance;
    private Transaksi transaction;

    public static TransaksiManager getInstance() {
        if (instance == null) {
            instance = new TransaksiManager();
        }
        return instance;
    }

    public Transaksi getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaksi transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        Person person = getPersonByID(this.transaction.getIdPerson());
        Room room = CheckController.getDataRoom(transaction.getIdHotel(), transaction.getNo_Kamar());
        return "<html><pre>ID Transaksi : " + this.transaction.getIdTransaksi()
                + "<br/>Tanggal Booking : " + (this.transaction.getTanggal_Booking())
                + "<br/>Tanggal Check In : " + (this.transaction.getCheckIn())
                + "<br/>Tanggal Check Out : " + (this.transaction.getCheckOut())
                + "<br/>Lama Inap : " + this.transaction.getLamaInap() + " hari"
                + "<br/>Detail Hotel : <br/>      Nama : " + listCabangHotel.get(this.transaction.getIdHotel() - 1).getNamaHotel()
                + "<br/>      Alamat : " + listCabangHotel.get(this.transaction.getIdHotel() - 1).getLokasi()
                + "<br/>Detail Kamar : <br/>      No Kamar : " + this.transaction.getNo_Kamar()
                + "<br/>      Tipe Kamar : " + room.getTipeKamar()
                + "<br/>      Harga Kamar : " + (room.getHarga())
                + "<br/>Detail User : <br/>      ID User : " + this.transaction.getIdPerson()
                + "<br/>      Telepon : " + person.getNoHP()
                + "<br/>      Nama : " + person.getNama()
                + "<br/>Detail Pembayaran : <br/>      ID Pembayaran : " + this.transaction.getIdJenisPembayaran()
                + "<br/>      Jenis : " + listJenisPembayaran.get(this.transaction.getIdJenisPembayaran() - 1).getJenisPembayaran()
                + "<br/>      Harga Total : " + (transaction.HitungTotalBayar())
                + "<br/>      Harga yang harus dibayar : " + (transaction.getBill())
                + "<br/>Status Transaksi : " + this.transaction.getStatus() + "</pre></html>";
    }
}
