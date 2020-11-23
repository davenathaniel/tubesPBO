/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.PembayaranController.conn;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import static model.enums.TipePersonEnum.*;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class DataController {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList<Hotel> listCabangHotel = getListHotel();
    public static ArrayList<JenisPembayaran> listJenisPembayaran = getAllJenisPembayaran();

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
    
    //Select data semua Jenis Pembayaran
    public static ArrayList<JenisPembayaran> getAllJenisPembayaran(){
        ArrayList<JenisPembayaran> pembayaran = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jenispembayaran";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                JenisPembayaran jenis = new JenisPembayaran();
                jenis.setIdJenisPembayaran(rs.getInt("idJenis"));
                jenis.setJenisPembayaran(rs.getString("jenis"));
                pembayaran.add(jenis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pembayaran);
    }
    
    //Get User By ID
    public static Person getPersonByID(int idUser) {
        Person person = null;
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson=" + idUser;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int tipePerson = rs.getInt("tipePerson");
                switch(tipePerson){
                    case 0:
                        person = new Person();
                        person.setTipePerson(CUSTOMER);
                        break;
                    case 1:
                        person = new Receptionist(rs.getInt("idCabang"), rs.getInt("salary"), rs.getInt("absensi"));
                        person.setTipePerson(RECEPTIONIST);
                        break;
                    case 2:
                        person = new Person();
                        person.setTipePerson(ADMIN);
                        break;
                    default:
                        person = new Person();
                        break;
                }
                person.setIdPerson(rs.getInt("idPerson"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setNama(rs.getString("nama"));
                person.setAlamat(rs.getString("alamat"));
                person.setNoKTP(rs.getString("noKTP"));
                person.setNoHP(rs.getString("noHP"));
                person.setEmail(rs.getString("email"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return (person);
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
