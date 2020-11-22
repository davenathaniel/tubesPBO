/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DataController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class BookingPopUp implements ActionListener{
    JFrame bookingPopUp = new JFrame("Payment");
    JLabel title ;
    ArrayList<JRadioButton> listRBPembayaran = new ArrayList<>();
    ButtonGroup BGroup = new ButtonGroup();
    JButton nextButton;
    JButton back = new JButton("Back");
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    public BookingPopUp(){
        bookingPopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookingPopUp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        bookingPopUp.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("P E M B A Y A R A N       B O O K I N G",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        int height = 300;
        int j = 0;
        for (int i = 0; i < DataController.getAllJenisPembayaran().size(); i++){
            String jenisPembayaran = DataController.getAllJenisPembayaran().get(i).getJenisPembayaran();
            listRBPembayaran.add(new JRadioButton(jenisPembayaran));
            listRBPembayaran.get(j).setFont(formFont);
            listRBPembayaran.get(j).setBounds(850, height, 200, 30);
            height += 38;
            BGroup.add(listRBPembayaran.get(j));
            bookingPopUp.add(listRBPembayaran.get(j));
            j++;
        }
        
        bookingPopUp.add(title);
        bookingPopUp.setLayout(null);
        bookingPopUp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
