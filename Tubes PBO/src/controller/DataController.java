/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author maria
 */
public class DataController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList<Hotel> listCabangHotel = getListHotel();

    //select data semua cabang hotel
    private static ArrayList<Hotel> getListHotel() {
        ArrayList<Hotel> listCabangHotel = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM hotel";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idHotel = rs.getInt("idHotel");
                listCabangHotel.add(new Hotel(idHotel, rs.getString("lokasi"), rs.getString("nama"), getListRoom(idHotel)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listCabangHotel);
    }
    
    //select data semua room di satu hotel tertentu
    public static ArrayList<Room> getListRoom(int idHotel) {
        ArrayList<Room> listRoom = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM room WHERE idHotel='" + idHotel + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listRoom.add(new Room(rs.getString("tipe"),rs.getInt("noKamar"),rs.getInt("batasGuest"),rs.getInt("harga")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRoom;
    }
    
    //insert room baru
    public static boolean insertNewRoom(Room room, int idHotel) {
        conn.connect();
        String query = "INSERT INTO room (idHotel,noKamar,tipe,harga) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, idHotel);
            stmt.setInt(2, room.getNoKamar());
            stmt.setString(3, room.getTipeKamar());
            stmt.setDouble(4, room.getHarga());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //update room
    public static boolean updateRoom(Room room, int idHotel) {
        conn.connect();
        String query = "UPDATE room SET tipe = '" + room.getTipeKamar() + " , harga =  " + room.getHarga() + " WHERE idHotel = " + idHotel + " AND noKamar = " + room.getNoKamar();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
