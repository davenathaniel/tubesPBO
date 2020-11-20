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

/**
 *
 * @author maria
 */
public class MenuCustomer implements ActionListener{
    JFrame layoutCustomer = new JFrame("Menu Customer");
    JLabel title;
    JPanel buttonPanel;
    JButton bBooking, bReschedule,bCancel , cekHistory, logOut;
    
    public MenuCustomer(){
        layoutCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutCustomer.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutCustomer.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("~ W E L C O M E      *UserName Customer*! ~",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        
        bBooking = new JButton("Booking");
        bBooking.setBounds(600, 50, 200,70);
        bBooking.addActionListener(this);
        bBooking.setFont(new Font("Impact", Font.PLAIN, 25));
        
        bReschedule = new JButton("Reschedule");
        bReschedule.setBounds(850, 50, 200,70);
        bReschedule.addActionListener(this);
        bReschedule.setFont(new Font("Impact", Font.PLAIN, 25));
        
        bCancel = new JButton("Cancel Booking");
        bCancel.setBounds(1100, 50, 200,70);
        bCancel.addActionListener(this);
        bCancel.setFont(new Font("Impact", Font.PLAIN, 25));
        
        cekHistory = new JButton("Cek History");
        cekHistory.setBounds(730, 140, 200,70);
        cekHistory.addActionListener(this);
        cekHistory.setFont(new Font("Impact", Font.PLAIN, 25));
        
        logOut = new JButton("Log Out");
        logOut.setBounds(980, 140, 200,70);
        logOut.addActionListener(this);
        logOut.setFont(new Font("Impact", Font.PLAIN, 25));
        
        buttonPanel.add(bBooking);
        buttonPanel.add(bReschedule);
        buttonPanel.add(bCancel);
        buttonPanel.add(cekHistory);
        buttonPanel.add(logOut);
        buttonPanel.setBounds(0, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        buttonPanel.setBackground(new Color(203,202,250));
        
        layoutCustomer.add(title);
        layoutCustomer.add(buttonPanel);
        layoutCustomer.setLayout(null);
        layoutCustomer.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Booking" :
                layoutCustomer.dispose();
                new MenuBooking();
                break;
            case "Reschedule":
                layoutCustomer.dispose();
                new MenuReschedule();
                break;
            case "Cancel Booking":
                layoutCustomer.dispose();
                new MenuCancelBooking();
                break;
            case "Cek History":
                layoutCustomer.dispose();
                break;
            case "Log Out":
                layoutCustomer.dispose();
                new MenuLogin();
                break;
        }
    }
}
