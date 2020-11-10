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
                        //person = new Receptionist(rs.getInt("idCabang"), rs.getInt("salary"), rs.getInt("absensi"));
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
