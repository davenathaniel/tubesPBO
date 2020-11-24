/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.Room;
import model.TransaksiManager;
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
public class MenuReschedulePopUp implements ActionListener{
    JFrame layoutReschedulePopUp = new JFrame("Menu Booking");
    JLabel title, judul, labelJumlahGuest, labelTanggalCheckIn, labelTanggalCheckOut;
    JButton buttonSubmit, buttonBack;
    JPanel dataPanel;
    JDatePickerImpl datePicker1, datePicker2;
    UtilDateModel model1, model2;
    Properties p1, p2;
    JDatePanelImpl datePanel1, datePanel2;
    
    public MenuReschedulePopUp(){
        layoutReschedulePopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutReschedulePopUp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutReschedulePopUp.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("R E S C H E D U L E    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        labelTanggalCheckIn = new JLabel("Tanggal Check-In");
        labelTanggalCheckIn.setBounds(710, 60, 200,50);
        labelTanggalCheckIn.setFont(StyleSheet.formFont);
        
        model1 = new UtilDateModel();
        p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        datePanel1 = new JDatePanelImpl(model1, p1);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        datePicker1.setBounds(910,70,300,25);
        datePicker1.setFont(StyleSheet.formFont);
        datePicker1.setBackground(StyleSheet.backgroundColor);
        
        labelTanggalCheckOut = new JLabel("Tanggal Check-Out");
        labelTanggalCheckOut.setBounds(710, 120, 200,50);
        labelTanggalCheckOut.setFont(StyleSheet.formFont);
        
        model2 = new UtilDateModel();
        p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel2 = new JDatePanelImpl(model2, p2);
        datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        datePicker2.setBounds(910,130,300,25);
        datePicker2.setFont(StyleSheet.formFont);
        datePicker2.setBackground(StyleSheet.backgroundColor);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(860,300,150,50);
        buttonBack.setFont(StyleSheet.formFont);
        buttonBack.addActionListener(this);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(1060,300,150,50);
        buttonSubmit.setFont(StyleSheet.formFont);
        buttonSubmit.addActionListener(this);
        
        dataPanel.add(labelTanggalCheckIn);
        dataPanel.add(datePicker1);
        dataPanel.add(labelTanggalCheckOut);
        dataPanel.add(datePicker2);
        dataPanel.add(buttonBack);
        dataPanel.add(buttonSubmit);
        dataPanel.setBounds(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),500);
        dataPanel.setBackground(StyleSheet.backgroundColor);
        
        layoutReschedulePopUp.add(title);
        layoutReschedulePopUp.add(dataPanel);
        layoutReschedulePopUp.setLayout(null);
        layoutReschedulePopUp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Submit" :
                nextButtonAction();
                break;
            case "Back":
                layoutReschedulePopUp.dispose();
                new MenuCustomer();
                break;
        }
    }

    private void nextButtonAction() {
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
            if (checkInDate == null || checkOutDate == null){
                JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
            }else{
                TransaksiManager.getInstance().getTransaction().setCheckIn(checkIn);
                TransaksiManager.getInstance().getTransaction().setCheckOut(checkOut);
                if(controller.CheckController.RescheduleBooking(TransaksiManager.getInstance().getTransaction())){
                    JOptionPane.showMessageDialog(null, "Data updated!");
                    layoutReschedulePopUp.dispose();
                    new MenuReschedulePopUp();
                }else{
                    JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
