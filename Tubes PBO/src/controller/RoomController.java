/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DataController.listCabangHotel;
import static controller.RoomController.cekTransaksi;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;
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
