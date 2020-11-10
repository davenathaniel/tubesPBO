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
public class MenuBooking implements ActionListener{
    JFrame layoutBooking = new JFrame("Menu Booking");
    JLabel title, labelHotel, labelTipeKamar, labelJumlahGuest, labelTanggalCheckIn, labelTanggalCheckOut;
    JTextField jumlahGuest;
    JButton buttonSubmit, buttonCancel;
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
        
        labelTipeKamar = new JLabel("Tipe Kamar");
        labelTipeKamar.setBounds(650, 70,200,50);
        labelTipeKamar.setFont(formFont);
        
        labelJumlahGuest = new JLabel("Jumlah Guest");
        labelJumlahGuest.setBounds(650, 130,200,50);
        labelJumlahGuest.setFont(formFont);
        
        jumlahGuest = new JTextField();
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
        buttonCancel.setBounds(900,320,150,50);
        buttonCancel.setFont(formFont);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(1100,320,150,50);
        buttonSubmit.setFont(formFont);
        
        dataPanel.add(labelHotel);
        dataPanel.add(labelTipeKamar);
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
                break;
            case "Cancel":
                layoutBooking.dispose();
                new MenuCustomer();
                break;
        }
    }
}
