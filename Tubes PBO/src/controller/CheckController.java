/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import model.Hotel;
import model.Room;

/**
 *
 * @author Dave
 */
public class CheckController {

    static DatabaseHandler conn = new DatabaseHandler();

    //GET ROOM INDEX IN ARRAY HOTEL
    public static Room getDataRoom(int idHotel, int noKamar) {
        Hotel hotel = DataController.listCabangHotel.get(idHotel - 1);
        Room room = null;
        for (int i = 0; i < hotel.getListRoom().size(); i++) {
            if (hotel.getListRoom().get(i).getNoKamar() == noKamar) {
                room = hotel.getListRoom().get(i);
                break;
            }
        }
        return room;
    }
}
