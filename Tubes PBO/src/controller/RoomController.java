/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DataController.listCabangHotel;
import static controller.RoomController.cekTransaksi;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Room;
import model.Transaksi;
import model.TransaksiManager;
import model.enums.StatusBookingEnum;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class RoomController {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean cekKetersedianRoom(int idHotel, int noKamar){
        conn.connect();
        boolean isExist = false;
        String query = "SELECT * FROM room WHERE idHotel = " + idHotel + " AND noKamar = " + noKamar;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (isExist);
    }
    
    public static ArrayList<Room> cekRoomKosong(int idHotel, String tipeKamar){
        ArrayList<Room> listRoomKosong = new ArrayList<>();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        for (int i = 0; i < listCabangHotel.get(idHotel - 1).getListRoom().size(); i++){
            if(listCabangHotel.get(idHotel - 1).getListRoom().get(i).getTipeKamar().equals(tipeKamar)){
                if(!cekTransaksi(idHotel, listCabangHotel.get(idHotel - 1).getListRoom().get(i).getNoKamar(), date)){
                    listRoomKosong.add(listCabangHotel.get(idHotel - 1).getListRoom().get(i));
                }
            }
        }
        return (listRoomKosong);
    }
    
    public static boolean cekTransaksi(int idHotel, int noKamar, Date date){
        conn.connect();
        boolean isExist = false;
        String query = "SELECT * FROM bookingtransaksi WHERE idHotel = " + idHotel + " AND noKamar = " + noKamar + " AND (status = '" + StatusBookingEnum.BOOKED.toString() + "' OR status = '" + StatusBookingEnum.CHECKEDIN.toString() + "')" + " AND checkIn <= '" + date + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (isExist);
    }
    
    public static boolean updateRoomBaru(int noKamar, int idTransaksi) {
        conn.connect();
        String query = "UPDATE bookingtransaksi SET noKamar = " + noKamar + " WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }

    }
    
    public static boolean makeNewTransaction(Transaksi newTransaction, StatusBookingEnum status) {
        conn.connect();
        String query = "INSERT INTO bookingtransaksi (idHotel,noKamar,idPerson,tanggalBooking,checkIn,checkOut,jumlahOrang,idJenis,status) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt;
            stmt = conn.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, newTransaction.getIdHotel());
            stmt.setInt(2, newTransaction.getNo_Kamar());
            stmt.setInt(3, newTransaction.getIdPerson());
            stmt.setDate(4, new java.sql.Date(newTransaction.getTanggal_Booking().getTime()));
            stmt.setDate(5, new java.sql.Date(newTransaction.getCheckIn().getTime()));
            stmt.setDate(6, new java.sql.Date(newTransaction.getCheckOut().getTime()));
            stmt.setInt(7, newTransaction.getJumlahOrang());
            stmt.setInt(9, newTransaction.getIdJenisPembayaran());
            stmt.setString(10, status.toString());
            stmt.executeUpdate();
            int idTransaksiBaru = 0;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idTransaksiBaru = rs.getInt(1);
            }
            TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTransaksiBaru));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void makeCheckOutTransaction(int idTransaksi, int uangMuka) {
        conn.connect();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String query = "UPDATE bookingtransaksi SET checkOut = '" + date + " WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTransaksi));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateCheckOutDate(int idTransaksi, Date newDate) {
        conn.connect();
        String query = "UPDATE bookingtransaksi SET checkOut = '" + newDate + "' WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTransaksi));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static String getRoomTypebyRN(int RN) {
        conn.connect();
        String query = "SELECT * FROM room WHERE noKamar='" + RN + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getString("tipe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
