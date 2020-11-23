/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Controller.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Person;
import model.Receptionist;
import static model.enums.TipePersonEnum.*;

/**
 *
 * @author LENOVO G4-45
 */
public class PembayaranController {

    static DatabaseHandler conn = new DatabaseHandler();

    //Get User Login Data
    public static Person getPersonById(int idUser) {
        Person person = null;
        conn.connect();
        String query = "SELECT * FROM person WHERE idPerson = " + idUser;
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

    // UPDATE PEMBAYARAN
    public static boolean updatePembayaran(int idTransaksi, int idPembayaran) {
        conn.connect();

        String query = "UPDATE bookingtransaksi SET idJenisPembayaran = " + idPembayaran + " WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
