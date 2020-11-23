/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */

public class MenuReseptionist implements ActionListener{
    JFrame layoutReseptionist = new JFrame("Menu Reseptionist");
    JLabel title;
    JPanel buttonPanel;
    JButton checkIn, checkOut, cekHistory, logOut;
    
    public MenuReseptionist(){
        layoutReseptionist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutReseptionist.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutReseptionist.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("~ W E L C O M E      R E S E P T I O N I S T ! ~",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        
        checkIn = new JButton("Check-In");
        checkIn.setBounds(470, 50, 200,70);
        checkIn.addActionListener(this);
        checkIn.setFont(StyleSheet.buttonFont);
        
        checkOut = new JButton("Check-Out");
        checkOut.setBounds(720, 50, 200,70);
        checkOut.addActionListener(this);
        checkOut.setFont(StyleSheet.buttonFont);
        
        cekHistory = new JButton("Cek History");
        cekHistory.setBounds(970, 50, 200,70);
        cekHistory.addActionListener(this);
        cekHistory.setFont(StyleSheet.buttonFont);
        
        logOut = new JButton("Log Out");
        logOut.setBounds(1220, 50, 200,70);
        logOut.addActionListener(this);
        logOut.setFont(StyleSheet.buttonFont);
        
        buttonPanel.add(checkIn);
        buttonPanel.add(checkOut);
        buttonPanel.add(cekHistory);
        buttonPanel.add(logOut);
        buttonPanel.setBounds(0, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        buttonPanel.setBackground(StyleSheet.backgroundColor);
        
        layoutReseptionist.add(title);
        layoutReseptionist.add(buttonPanel);
        layoutReseptionist.setLayout(null);
        layoutReseptionist.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Check-In" :
                layoutReseptionist.dispose();
                new MenuCheckIn();
                break;
            case "Check-Out":
                layoutReseptionist.dispose();
                new MenuCheckOut();
                break;
            case "Cek History":
                layoutReseptionist.dispose();
                break;
            case "Log Out":
                layoutReseptionist.dispose();
                new MenuLogin();
                break;
        }
    }
}
