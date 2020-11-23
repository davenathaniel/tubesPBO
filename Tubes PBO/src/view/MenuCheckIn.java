/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Room;
import model.TransaksiManager;
import model.enums.StatusBookingEnum;
/**
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuCheckIn implements ActionListener{
    JFrame layoutCheckIn = new JFrame("Check-In Menu");
    JLabel title, labelBooking, labelNamaHotel;
    JPanel panelInput;
    JTextField booking;
    JButton bSubmit;
    
    public MenuCheckIn() {
        layoutCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutCheckIn.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutCheckIn.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("C h e c k - I n   M e n u",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        panelInput = new JPanel();
        panelInput.setLayout(null);
        
        labelBooking = new JLabel("id Transaksi");
        labelBooking.setFont(StyleSheet.formFont);
        labelBooking.setBounds(650,10,200,50);
        
        booking = new JTextField();
        booking.setFont(StyleSheet.formFont);
        booking.setBounds(850,10, 300, 50);
        
        bSubmit = new JButton("Submit");
        bSubmit.setBounds(1180, 10, 100, 50);
        bSubmit.setFont(StyleSheet.formFont);
        
        panelInput.add(labelBooking);
        panelInput.add(booking);
        panelInput.add(bSubmit);
        panelInput.setBounds(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),70 );
        panelInput.setBackground(StyleSheet.backgroundColor);
        
        layoutCheckIn.add(title);
        layoutCheckIn.add(panelInput);
        layoutCheckIn.setLayout(null);
        layoutCheckIn.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Submit":
                break;
        }
    }
}
