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
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
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
            query = "INSERT INTO person (username, password, nama, alamat, noKTP, noHP, email, tipePerson, idCabang, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setInt(10, 500000);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Kincup");
            stmt.setString(2, getMd5("receptionist"));
            stmt.setString(3, "Kincup Bieber");
            stmt.setString(4, "Multatuli");
            stmt.setString(5, "0213455777906547");
            stmt.setString(6, "083235675478");
            stmt.setString(7, "kincup@gmail.co.id");
            stmt.setInt(8, 1);
            stmt.setInt(9, 2);
            stmt.setInt(10, 550000);
            stmt.executeUpdate();
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "Bokir");
            stmt.setString(2, getMd5("receptionist"));
            stmt.setString(3, "Bokir Itachi");
            stmt.setString(4, "Rahayu");
            stmt.setString(5, "7013455634243257");
            stmt.setString(6, "082245253654");
            stmt.setString(7, "bokir@gmail.co.id");
            stmt.setInt(8, 1);
            stmt.setInt(9, 3);
            stmt.setInt(10, 400000);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            
            return false;
        }
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
