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
 * @author maria
 */
public class MenuCheckIn implements ActionListener{
    JFrame layoutCheckIn = new JFrame("Check-In Menu");
    JLabel title, labelBooking;
    JTextField booking;
    JButton bSubmit;
    JPanel panelInput, panelOutput;
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    
    public MenuCheckIn() {
        layoutCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutCheckIn.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutCheckIn.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("C h e c k - I n   M e n u",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        panelInput = new JPanel();
        panelInput.setLayout(null);
        
        labelBooking = new JLabel("Nomor Booking");
        labelBooking.setFont(formFont);
        labelBooking.setBounds(650,10,200,50);
        
        booking = new JTextField();
        booking.setFont(formFont);
        booking.setBounds(850,10, 300, 50);
        
        bSubmit = new JButton("Submit");
        bSubmit.setBounds(1180, 10, 100, 50);
        bSubmit.setFont(formFont);
        
        panelInput.add(labelBooking);
        panelInput.add(booking);
        panelInput.add(bSubmit);
        panelInput.setBounds(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),70 );
        panelInput.setBackground(new Color(203,202,250));
        
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
