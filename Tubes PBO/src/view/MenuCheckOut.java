/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.TransaksiManager;

/**
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuCheckOut implements ActionListener {
    JFrame layoutCheckIn = new JFrame("Check-Out Menu");
    JLabel title, labelBooking;
    JTextField booking;
    JButton bSubmit, backButton;
    JPanel panelInput;
    
    public MenuCheckOut() {
        layoutCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutCheckIn.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutCheckIn.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("C h e c k - O u t   M e n u",JLabel.CENTER);
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
        bSubmit.addActionListener(this);
        
        backButton = new JButton("<< Back");
        backButton.setBounds(900,800,150,70);
        backButton.setFont(StyleSheet.buttonFont);
        backButton.setBackground(StyleSheet.cancelButtonColor);
        backButton.addActionListener(this);
        
        panelInput.add(labelBooking);
        panelInput.add(booking);
        panelInput.add(bSubmit);
        panelInput.setBounds(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),70 );
        panelInput.setBackground(StyleSheet.backgroundColor);
        
        layoutCheckIn.add(title);
        layoutCheckIn.add(panelInput);
        layoutCheckIn.add(backButton);
        layoutCheckIn.setLayout(null);
        layoutCheckIn.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Submit":
                String idTransaksi = this.booking.getText();
                if(idTransaksi.equals("")){
                    JOptionPane.showMessageDialog(null, "Please insert id Transaksi", "Alert", JOptionPane.WARNING_MESSAGE);
                }else{
                    int idTransInt = Integer.parseInt(idTransaksi);
                    TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTransInt));
                    new CheckOutPopUp();
                }
                break;
            case "<< Back":
                layoutCheckIn.dispose();
                new MenuReseptionist();
                break;
        }
    }
}
