/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author maria
 */
public class MenuReschedule implements ActionListener{
    JFrame layoutReschedule = new JFrame("Menu Reschedule");
    JLabel title, labelHotel,labelNoBooking,labelTipeKamar,labelJumlahGuest, labelTanggalCheckIn, labelTanggalCheckOut, labelJumlahKamar;
    JTextField nomorBooking, jumlahGuest, jumlahKamar;
    JComboBox cabangHotel, tipeKamar;
    JButton buttonSubmit, buttonCancel;
    JPanel dataPanel;
    JDatePickerImpl datePicker1, datePicker2;
    UtilDateModel model1, model2;
    Properties p1, p2;
    JDatePanelImpl datePanel1, datePanel2;
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    
    public MenuReschedule() {
        layoutReschedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutReschedule.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutReschedule.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("R E S C H E D U L E    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        labelNoBooking =  new JLabel("Nomor Booking");
        labelNoBooking.setBounds(700,10,200,50);
        labelNoBooking.setFont(formFont);
        
        nomorBooking = new JTextField();
        nomorBooking.setBounds(950, 10,300,50);
        nomorBooking.setFont(formFont);
        
        labelHotel = new JLabel("Cabang hotel");
        labelHotel.setBounds(700,70,200,50);
        labelHotel.setFont(formFont);
        cabangHotel = new JComboBox();
        cabangHotel.setBounds(950,70,300,50);
        cabangHotel.setFont(formFont);
        
        labelTipeKamar = new JLabel("Tipe Kamar");
        labelTipeKamar.setBounds(700, 130,200,50);
        labelTipeKamar.setFont(formFont);
        tipeKamar = new JComboBox();
        tipeKamar.setBounds(950, 130, 300,50);
        tipeKamar.setFont(formFont);
        
        labelJumlahGuest = new JLabel("Jumlah Guest");
        labelJumlahGuest.setBounds(700, 190,200,50);
        labelJumlahGuest.setFont(formFont);
        
        jumlahGuest = new JTextField();
        jumlahGuest.setBounds(950, 190,300,50);
        jumlahGuest.setFont(formFont);
        
        labelTanggalCheckIn = new JLabel("Tanggal Check-In");
        labelTanggalCheckIn.setBounds(700, 260, 200,50);
        labelTanggalCheckIn.setFont(formFont);
        
        model1 = new UtilDateModel();
        p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        datePanel1 = new JDatePanelImpl(model1, p1);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        datePicker1.setBounds(950,270,300,25);
        datePicker1.setFont(formFont);
        datePicker1.setBackground(new Color(203,202,250));
        
        labelTanggalCheckOut = new JLabel("Tanggal Check-Out");
        labelTanggalCheckOut.setBounds(700, 320, 200,50);
        labelTanggalCheckOut.setFont(formFont);
        
        model2 = new UtilDateModel();
        p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel2 = new JDatePanelImpl(model2, p2);
        datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        datePicker2.setBounds(950,330,300,25);
        datePicker2.setFont(formFont);
        datePicker2.setBackground(new Color(203,202,250));
        
        labelJumlahKamar = new JLabel("Jumlah Kamar");
        labelJumlahKamar.setBounds(700, 380, 200,50);
        labelJumlahKamar.setFont(formFont);
        jumlahKamar = new JTextField();
        jumlahKamar.setBounds(950, 380,300,50);
        jumlahKamar.setFont(formFont);
        
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(950,440,150,50);
        buttonCancel.setFont(formFont);
        buttonCancel.addActionListener(this);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(1150,440,150,50);
        buttonSubmit.setFont(formFont);
        buttonSubmit.addActionListener(this);
        
        dataPanel.add(labelNoBooking);
        dataPanel.add(nomorBooking);
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
        dataPanel.add(labelJumlahKamar);
        dataPanel.add(jumlahKamar);
        dataPanel.add(buttonCancel);
        dataPanel.add(buttonSubmit);
        dataPanel.setBounds(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),500);
        dataPanel.setBackground(new Color(203,202,250));
        
        layoutReschedule.add(title);
        layoutReschedule.add(dataPanel);
        layoutReschedule.setLayout(null);
        layoutReschedule.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Submit" :
                layoutReschedule.dispose();
                break;
            case "Cancel":
                layoutReschedule.dispose();
                new MenuCustomer();
                break;
        }
    }
}
