/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class DataHotelDatabase {
    
    static DatabaseHandler conn = new DatabaseHandler();

    // INSERT
    public static void insertHotel() {
        conn.connect();
        String query = "INSERT INTO hotel (nama,lokasi) VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Hotel Queen Maria");
            stmt.setString(2, "Jalan Dipati Ukur No. 100, Bandung");
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Hotel Lady Enjel");
            stmt.setString(2, "Jalan Dago Atas No. 105, Bandung");
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Hotel Jester Nathan");
            stmt.setString(2, "Jalan Cihampelas No. 110, Bandung");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // INSERT
    public static void insertJenisPembayaran() {
        conn.connect();
        String query = "INSERT INTO jenispembayaran (jenis) VALUES(?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Cash");
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Debit Card");
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "M-Banking");
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "OVO");
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Gopay");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT
    public static void insertRoom() {
        conn.connect();
        String query = "INSERT INTO room (noKamar,tipe,harga,idHotel) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 1101);
            stmt.setString(2, "Single Room");
            stmt.setInt(3, 2000000);
            stmt.setInt(4, 1);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 1102);
            stmt.setString(2, "Single Room");
            stmt.setInt(3, 2000000);
            stmt.setInt(4, 1);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 2101);
            stmt.setString(2, "Double Room");
            stmt.setInt(3, 4000000);
            stmt.setInt(4, 1);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 2102);
            stmt.setString(2, "Double Room");
            stmt.setInt(3, 4000000);
            stmt.setInt(4, 1);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 3101);
            stmt.setString(2, "VIP Room");
            stmt.setInt(3, 5500000);
            stmt.setInt(4, 1);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 2201);
            stmt.setString(2, "Double Room");
            stmt.setInt(3, 4000000);
            stmt.setInt(4, 2);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 2202);
            stmt.setString(2, "Double Room");
            stmt.setInt(3, 4000000);
            stmt.setInt(4, 2);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 3201);
            stmt.setString(2, "VIP Room");
            stmt.setInt(3, 5500000);
            stmt.setInt(4, 2);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 3202);
            stmt.setString(2, "VIP Room");
            stmt.setInt(3, 5500000);
            stmt.setInt(4, 2);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 1301);
            stmt.setString(2, "Single Room");
            stmt.setInt(3, 2000000);
            stmt.setInt(4, 3);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 1302);
            stmt.setString(2, "Single Room");
            stmt.setInt(3, 2000000);
            stmt.setInt(4, 3);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 2301);
            stmt.setString(2, "Double Room");
            stmt.setInt(3, 4000000);
            stmt.setInt(4, 3);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 2302);
            stmt.setString(2, "Double Room");
            stmt.setInt(3, 4000000);
            stmt.setInt(4, 3);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertHotel();
        insertJenisPembayaran();
        insertRoom();
    }

}
