/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.PersonManager;
import static model.enums.TipePersonEnum.CUSTOMER;

/**
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuCancelBooking implements ActionListener{
    JFrame cancelBookingFrame = new JFrame("Cancel Booking Menu");
    JLabel title, judul;
    JTable table;
    JPanel dataPanel;
    JButton back = new JButton("Back");
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    public MenuCancelBooking(){
        cancelBookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancelBookingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cancelBookingFrame.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("C A N C E L    B O O K I N G    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        judul = new JLabel("Daftar Booking : ");
        judul.setBounds(650, 150, 200, 100);
        judul.setFont(formFont);
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        back.setBounds(650, 800, 100, 50);
        back.addActionListener(this);
        
        cancelBookingFrame.add(back);
        cancelBookingFrame.add(title);
        cancelBookingFrame.add(judul);
        cancelBookingFrame.add(dataPanel);
        cancelBookingFrame.setLayout(null);
        cancelBookingFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Back":
                cancelBookingFrame.dispose();
                new MenuCustomer();
                break;
        }
    }
}
