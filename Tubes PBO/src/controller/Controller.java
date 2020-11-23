/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import static model.enums.TipePersonEnum.*;

/**
 *
 * @author
 * 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 * 
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    //Get data User Login
    public static Person getPerson(String username){
        Person person = null;
        conn.connect();
        String query = "SELECT * FROM person WHERE username='" + username + "'";
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
                        person = new Receptionist();
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
    
    //Cek username ada atau tidak
    public static boolean cekUsername(String username){
        ArrayList<Person> persons = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM person WHERE username='" + username + "'";
        boolean isExist = false; 
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }
    
    public static boolean cekPassword(String username, String password) {
        ArrayList<Person> persons = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM person WHERE username='" + username + "'";
        boolean isMatch = false;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString("password").equals(getMd5(password))){
                    isMatch = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMatch;
    }

    private static String getMd5(String input) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
        
            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);
            
            String hashtext = no.toString(16);
            while(hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }          
    }
    
    public static boolean insertCustomer(Person person){
        conn.connect();
        String query = "INSERT INTO person (username, password, nama, alamat, noKTP, noHP, email, tipePerson) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, person.getUsername());
            stmt.setString(2, getMd5(person.getPassword()));
            stmt.setString(3, person.getNama());
            stmt.setString(4, person.getAlamat());
            stmt.setString(5, person.getNoKTP());
            stmt.setString(6, person.getNoHP());
            stmt.setString(7, person.getEmail());
            stmt.setInt(8, 0);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertNewReceptionist(Receptionist person){
        conn.connect();
        String query = "INSERT INTO person (username, password, nama, alamat, noKTP, noHP, email, tipePerson, idCabang, salary, absensi)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, person.getUsername());
            stmt.setString(2, person.getPassword());
            stmt.setString(3, person.getNama());
            stmt.setString(4, person.getAlamat());
            stmt.setString(5, person.getNoKTP());
            stmt.setString(6, person.getNoHP());
            stmt.setString(7, person.getEmail());
            stmt.setInt(8, 1);
            stmt.setInt(9, person.getIdCabang());
            stmt.setInt(10, person.getSalary());
            stmt.setInt(11, person.getAbsensi());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertNewAdmin(Person person){
        conn.connect();
        String query = "INSERT INTO person (username, password, nama, alamat, noKTP, noHP, email, tipePerson) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, person.getUsername());
            stmt.setString(2, getMd5(person.getPassword()));
            stmt.setString(3, person.getNama());
            stmt.setString(4, person.getAlamat());
            stmt.setString(5, person.getNoKTP());
            stmt.setString(6, person.getNoHP());
            stmt.setString(7, person.getEmail());
            stmt.setInt(8, 2);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static int getHotelIDbyName(String name) {
        conn.connect();
        String query = "SELECT * FROM hotel WHERE nama='" + name + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Hotel a = new Hotel();
                return rs.getInt("idHotel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getRoomIDbyName(String name) {
        conn.connect();
        String query = "SELECT * FROM hotel WHERE nama='" + name + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("idHotel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    //get nama cabang hotel yang tersedia
    public static String[] getHotelNameList() {
        String[] listNamaHotel = new String[DataController.listCabangHotel.size()];
        for (int counter = 0; counter < DataController.listCabangHotel.size(); counter++) {
            listNamaHotel[counter] = DataController.listCabangHotel.get(counter).getNamaHotel();
        }
        return listNamaHotel;
    }
    
    //get kamar hotel yang tersedia
    public static String[] getRoomNameList(String namaHotel) {
        int a = getHotelIDbyName(String.valueOf(namaHotel));
        int i = DataController.getListRoom(a).size();
        String[] listNamaKamar = new String[i];
        for (int j = 0; j < i; j++) {
            listNamaKamar[j] = "";
        }
        ArrayList<Room> listRoom = controller.DataController.getListRoom(a);
        int j = 0, counter2 = 0;
        for (int counter = 0; counter < i; counter++) {
            boolean isThere = false;
            while (isThere == false && counter2 < i) {
                if (listNamaKamar[counter2].equals(listRoom.get(counter).getTipeKamar())) {
                    isThere = true;
                }
                counter2++;
            }
            if (isThere == false) {
                listNamaKamar[j] = listRoom.get(counter).getTipeKamar();
                j++;
            }
            counter2 = 0;
        }
        return listNamaKamar;
    }
    
    public static int getBatasGuest(int idKamar) {
        conn.connect();
        String query = "SELECT * FROM room WHERE idKamar='" + idKamar + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Hotel a = new Hotel();
                return rs.getInt("batasGuest");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    //Booking Kamar
    public static boolean booking(Transaksi trans){
        
        conn.connect();
        String query = "INSERT INTO bookingtransaksi (idPerson,idHotel,jumlahOrang,tanggalBooking,noKamar,checkIn,checkOut,status) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, trans.getIdPerson());
            stmt.setInt(2, trans.getIdHotel());
            stmt.setInt(3, trans.getJumlahOrang());
            stmt.setDate(4, new java.sql.Date(trans.getTanggal_Booking().getTime()));
            stmt.setInt(5, trans.getNo_Kamar());
            stmt.setDate(6, new java.sql.Date(trans.getCheckIn().getTime()));
            stmt.setDate(7, new java.sql.Date(trans.getCheckOut().getTime()));
            stmt.setString(8, String.valueOf(model.enums.StatusBookingEnum.BOOKED));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
