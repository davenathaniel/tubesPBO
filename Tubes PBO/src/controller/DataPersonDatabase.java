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
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DataPersonDatabase {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean insertPerson() {
        conn.connect();
        String query = "INSERT INTO person (username, password, nama, alamat, noKTP, noHP, email, tipePerson) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Maria");
            stmt.setString(2, getMd5("admin"));
            stmt.setString(3, "Maria Vabiolla");
            stmt.setString(4, "Gempol Asri Raya");
            stmt.setString(5, "1234567890111213");
            stmt.setString(6, "081234567890");
            stmt.setString(7, "maria00@gmail.co.id");
            stmt.setInt(8, 2);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Enjel");
            stmt.setString(2, getMd5("customer"));
            stmt.setString(3, "Tridia Enjeliani");
            stmt.setString(4, "Sekeloa");
            stmt.setString(5, "0987654321098765");
            stmt.setString(6, "082167890543");
            stmt.setString(7, "enjel46@gmail.co.id");
            stmt.setInt(8, 0);
            stmt.executeUpdate();
            query = "INSERT INTO person (username, password, nama, alamat, noKTP, noHP, email, tipePerson, idCabang, salary, absensi) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Dave");
            stmt.setString(2, getMd5("receptionist"));
            stmt.setString(3, "Dave Nathaniel");
            stmt.setString(4, "Dago");
            stmt.setString(5, "0213455634243356");
            stmt.setString(6, "083245253467");
            stmt.setString(7, "dave12@gmail.co.id");
            stmt.setInt(8, 1);
            stmt.setInt(9, 1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private static String getMd5(String input) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while(hashtext.length()<32){
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        insertPerson();
    }
}
