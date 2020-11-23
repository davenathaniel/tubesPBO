/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.PersonManager;
import model.Room;
import model.Transaksi;
import model.enums.StatusBookingEnum;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import static view.StyleSheet.formatter;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuBooking implements ActionListener, ItemListener{
    JFrame layoutBooking = new JFrame("Menu Booking");
    JLabel title, labelHotel, labelTipeKamar, labelJumlahGuest, labelTanggalCheckIn, labelTanggalCheckOut, labelJumlahKamar;
    JComboBox cabangHotel, tipeKamar;
    JButton buttonSubmit, buttonCancel;
    JSpinner jumlahGuest, jumlahKamar;
    JPanel dataPanel;
    JDatePickerImpl datePicker1, datePicker2;
    UtilDateModel model1, model2;
    Properties p1, p2;
    JDatePanelImpl datePanel1, datePanel2;
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    
    public MenuBooking() {
        layoutBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutBooking.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutBooking.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("B O O K I N G    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        labelHotel = new JLabel("Cabang hotel");
        labelHotel.setBounds(650,10,200,50);
        labelHotel.setFont(formFont);
        cabangHotel = new JComboBox(controller.Controller.getHotelNameList());
        cabangHotel.addItemListener(this);
        cabangHotel.setSelectedIndex(0);
        cabangHotel.setBounds(900,10,300,50);
        cabangHotel.setFont(formFont);
        
        labelTipeKamar = new JLabel("Tipe Kamar");
        labelTipeKamar.setBounds(650, 70,200,50);
        labelTipeKamar.setFont(formFont);
        tipeKamar = new JComboBox();
        int i = controller.DataController.getListRoom(controller.Controller.getHotelIDbyName(String.valueOf(cabangHotel.getSelectedItem()))).size();
        String[] listNamaKamar = controller.Controller.getRoomNameList(String.valueOf(cabangHotel.getSelectedItem()));
        for (int counter = 0; counter < i; counter++) {
            if (!"".equals(listNamaKamar[counter])) {
                tipeKamar.addItem(listNamaKamar[counter]);
            }
        }
        tipeKamar.addItemListener(this);
        tipeKamar.setSelectedIndex(0);
        tipeKamar.setBounds(900, 70, 300,50);
        tipeKamar.setFont(formFont);
        
        labelJumlahGuest = new JLabel("Jumlah Guest");
        labelJumlahGuest.setBounds(650, 130,200,50);
        labelJumlahGuest.setFont(formFont);
        
        SpinnerModel value1 = new SpinnerNumberModel(0, 0, 10, 1);
        jumlahGuest = new JSpinner(value1);
        jumlahGuest.setBounds(900, 130,300,50);
        jumlahGuest.setFont(formFont);
        
        labelTanggalCheckIn = new JLabel("Tanggal Check-In");
        labelTanggalCheckIn.setBounds(650, 190, 200,50);
        labelTanggalCheckIn.setFont(formFont);
        
        model1 = new UtilDateModel();
        p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        datePanel1 = new JDatePanelImpl(model1, p1);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        datePicker1.setBounds(900,200,300,25);
        datePicker1.setFont(formFont);
        datePicker1.setBackground(new Color(203,202,250));
        
        labelTanggalCheckOut = new JLabel("Tanggal Check-Out");
        labelTanggalCheckOut.setBounds(650, 260, 200,50);
        labelTanggalCheckOut.setFont(formFont);
        
        model2 = new UtilDateModel();
        p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel2 = new JDatePanelImpl(model2, p2);
        datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        datePicker2.setBounds(900,270,300,25);
        datePicker2.setFont(formFont);
        datePicker2.setBackground(new Color(203,202,250));
        
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(900,380,150,50);
        buttonCancel.setFont(formFont);
        buttonCancel.addActionListener(this);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(1100,380,150,50);
        buttonSubmit.setFont(formFont);
        buttonSubmit.addActionListener(this);
        
        dataPanel.add(labelHotel);
        dataPanel.add(cabangHotel);
        dataPanel.add(labelTipeKamar);
        dataPanel.add(tipeKamar);
        dataPanel.add(labelJumlahGuest);
        dataPanel.add(jumlahGuest);
        dataPanel.add(labelTanggalCheckIn);
        dataPanel.add(datePicker1);
        dataPanel.add(labelTanggalCheckOut);
        dataPanel.add(datePicker2);
        dataPanel.add(buttonCancel);
        dataPanel.add(buttonSubmit);
        dataPanel.setBounds(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),500);
        dataPanel.setBackground(new Color(203,202,250));
        
        layoutBooking.add(title);
        layoutBooking.add(dataPanel);
        layoutBooking.setLayout(null);
        layoutBooking.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Submit" :
                layoutBooking.dispose();
                booking();
                break;
            case "Cancel":
                layoutBooking.dispose();
                new MenuCustomer();
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cabangHotel) {
            cabangHotel.setSelectedItem(e);
            tipeKamar.removeAllItems();
            int i = controller.DataController.getListRoom(controller.Controller.getHotelIDbyName(String.valueOf(cabangHotel.getSelectedItem()))).size();
            String[] listNamaKamar = controller.Controller.getRoomNameList(String.valueOf(cabangHotel.getSelectedItem()));
            for (int counter = 0; counter < i; counter++) {
                if (listNamaKamar[counter] != "") {
                    tipeKamar.addItem(listNamaKamar[counter]);
                }
            }
            tipeKamar.setSelectedIndex(0);
        } else if (e.getSource() == tipeKamar) {
            tipeKamar.setSelectedItem(e);
        }
    }
    
    public void booking(){
        int jumlahGuest = (int) this.jumlahGuest.getValue();
        java.util.Date checkIn = null, checkOut = null;
        try{
            checkIn = formatter.parse(this.datePicker1.getJFormattedTextField().getText());
            checkOut = formatter.parse(this.datePicker2.getJFormattedTextField().getText());
        }catch (ParseException ex){
            Logger.getLogger(MenuBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date checkInDate = new java.sql.Date(checkIn.getTime());
        java.sql.Date checkOutDate = new java.sql.Date(checkOut.getTime());
        int x = JOptionPane.showConfirmDialog(null, "Are you sure?");
        if(x == JOptionPane.YES_OPTION){
            if(checkInDate == null || checkOutDate == null || jumlahGuest == 0){
                JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
            }else{
                Transaksi trans = new Transaksi();
                trans.setIdPerson(PersonManager.getInstance().getPerson().getIdPerson());
                trans.setIdHotel(controller.Controller.getHotelIDbyName(String.valueOf(cabangHotel.getSelectedItem())));
                trans.setJumlahOrang(jumlahGuest);
                trans.setTanggal_Booking(new Date());
                int idHotel = controller.Controller.getHotelIDbyName(String.valueOf(cabangHotel.getSelectedItem()));
                ArrayList listRoomKosong = controller.RoomController.cekRoomKosong(idHotel, String.valueOf(tipeKamar.getSelectedItem()));
                if(listRoomKosong.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Room Full! Please select another room", "Alert", JOptionPane.WARNING_MESSAGE);
                }else{
                    Room kamar = (Room) listRoomKosong.remove(0);
                    trans.setNo_Kamar(kamar.getNoKamar());
                    trans.setCheckIn(checkInDate);
                    trans.setCheckOut(checkOutDate);
                    trans.setStatus(StatusBookingEnum.BOOKED);
                    if(jumlahGuest > kamar.getBatasOrang()){
                        JOptionPane.showMessageDialog(null, "Sorry we only permit " + kamar.getBatasOrang() + " in one room", "Alert", JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(controller.Controller.booking(trans)){
                            JOptionPane.showMessageDialog(null, "Please pay to confirm your booking");
                            layoutBooking.dispose();
                            new MenuBookingPopUp();
                        }else {
                            JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
    }
}
