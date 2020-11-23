/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import model.Hotel;
import model.Room;
import model.Transaksi;
import model.TransaksiManager;
import model.enums.StatusBookingEnum;
import static model.enums.StatusBookingEnum.*;
import static view.StyleSheet.formatter;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
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
    
    // SELECT ALL TRANSACTION
    public static DefaultTableModel getAllTransaction() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Transaksi", "ID Hotel", "ID User", "No. Kamar", "Tanggal Booking", "Check In", "Check Out", "Jumlah Guest", "ID Pembayaran", "Status"}, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        conn.connect();

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

        String query = "SELECT * FROM bookingtransaksi";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String idT = Integer.toString(rs.getInt("idTransaksi"));
                String idH = Integer.toString(rs.getInt("idHotel"));
                String noKamar = Integer.toString(rs.getInt("noKamar"));
                String idU = Integer.toString(rs.getInt("idPerson"));
                String booking = formatter.format(rs.getDate("tanggalBooking"));
                String checkin = formatter.format(rs.getDate("checkIn"));
                String checkout = formatter.format(rs.getDate("checkOut"));
                String jumlahGuest = Integer.toString(rs.getInt("jumlahOrang"));
                String idJenisPembayaran = Integer.toString(rs.getInt("idJenis"));
                String status = rs.getString("status");
                model.addRow(new Object[]{idT, idH, idU, noKamar, booking, checkin, checkout, jumlahGuest, idJenisPembayaran, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (model);
    }

    // SELECT TRANSACTION BY STATUS
    public static DefaultTableModel getTransactionByStatus(int idHotel, StatusBookingEnum status) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Transaksi", "ID Hotel", "ID Person", "Tipe Kamar", "Tanggal Booking", "Check In", "Check Out"}, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        conn.connect();
        String query = "SELECT * FROM bookingtransaksi WHERE status = '" + status.toString() + "'";
        if (idHotel > 0) {
            query = "SELECT * FROM bookingtransaksi WHERE status = '" + status.toString() + "' AND idHotel = " + idHotel;
        }
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String idT = Integer.toString(rs.getInt("idTransaksi"));
                String idH = Integer.toString(rs.getInt("idHotel"));
                String idU = Integer.toString(rs.getInt("idPerson"));
                String tipe = getDataRoom(rs.getInt("idHotel"), rs.getInt("noKamar")).getTipeKamar();
                String booking = formatter.format(rs.getDate("tanggalBooking"));
                String checkin = formatter.format(rs.getDate("checkIn"));
                String checkout = formatter.format(rs.getDate("checkOut"));
                model.addRow(new Object[]{idT, idH, idU, tipe, booking, checkin, checkout});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (model);
    }

    // GET ONE TRANSACTION
    public static Transaksi getOneTransaction(int idTransaksi) {
        Transaksi transaksi = new Transaksi();
        conn.connect();

        String query = "SELECT * FROM bookingtransaksi WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                transaksi.setIdTransaksi(rs.getInt("idTransaksi"));
                transaksi.setIdHotel(rs.getInt("idHotel"));
                transaksi.setIdPerson(rs.getInt("idPerson"));
                transaksi.setNo_Kamar(rs.getInt("noKamar"));
                transaksi.setTanggal_Booking(rs.getDate("tanggalBooking"));
                transaksi.setCheckIn(rs.getDate("checkIn"));
                transaksi.setCheckOut(rs.getDate("checkOut"));
                transaksi.setJumlahOrang(rs.getInt("jumlahOrang"));
                transaksi.setIdJenisPembayaran(rs.getInt("idJenis"));
                transaksi.setStatus(StatusBookingEnum.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (transaksi);
    }

    // UPDATE CHECK IN STATUS
    public static boolean updateCheckIn(int idTransaksi) {
        conn.connect();

        String query = "UPDATE bookingtransaksi SET status = '" + StatusBookingEnum.CHECKEDIN.toString() + "' WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // UPDATE CHECK OUT STATUS
    public static boolean updateCheckOut(int idTransaksi) {
        conn.connect();
        TransaksiManager.getInstance().getTransaction().setStatus(CHECKEDOUT);
        String query = "UPDATE bookingtransaksi SET status = '" + StatusBookingEnum.CHECKEDOUT.toString() + "' WHERE idTransaksi = " + idTransaksi;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    //CheckBooking, Cancel Booking, Reschedule Booking
    public static DefaultTableModel getUserActiveTransaction(int idUser) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Transaksi", "Nama Hotel", "Tipe Kamar", "Tanggal Booking", "Check In", "Check Out", "Jumlah Orang"}, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };
        conn.connect();

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

        String query = "SELECT * FROM bookingtransaksi WHERE idPerson='" + idUser + "' AND status='BOOKED'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String idT = Integer.toString(rs.getInt("idTransaksi"));
                String namaHotel = controller.DataController.listCabangHotel.get(rs.getInt("idHotel") - 1).getNamaHotel();
                String typeKamar = controller.RoomController.getRoomTypebyRN(rs.getInt("noKamar"));
                String booking = formatter.format(rs.getDate("tanggalBooking"));
                String checkin = formatter.format(rs.getDate("checkIn"));
                String checkout = formatter.format(rs.getDate("checkOut"));
                String jumlahGuest = Integer.toString(rs.getInt("jumlahOrang"));
                model.addRow(new Object[]{idT, namaHotel, typeKamar, booking, checkin, checkout, jumlahGuest});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (model);
    }

    //Untuk cancel booking
    public static boolean CancelBooking(Transaksi trans) {
        conn.connect();
        String query = "UPDATE bookingtransaksi SET  status='" + StatusBookingEnum.CANCELLED + "' "
                + "WHERE idTransaksi='" + trans.getIdTransaksi() + "' ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    //Untuk reschedule booking
    public static boolean RescheduleBooking(Transaksi trans) {
        conn.connect();
        String query = "UPDATE bookingtransaksi SET  checkIn='" + new java.sql.Date(trans.getCheckIn().getTime()) + "', "
                + "checkOut='" + new java.sql.Date(trans.getCheckOut().getTime()) + "' "
                + "WHERE idTransaksi='" + trans.getIdTransaksi() + "' ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
