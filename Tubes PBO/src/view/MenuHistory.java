/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Dave
 */
public class MenuHistory implements ActionListener{
    JFrame historyFrame = new JFrame("History Menu");
    JLabel title, judul;
    JTable table;
    JPanel dataPanel;
    JButton back = new JButton("Back");
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    public MenuHistory(){
        historyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        historyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        historyFrame.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("H I S T O R Y    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        judul = new JLabel("Daftar Transaksi : ");
        judul.setBounds(650, 150, 200, 100);
        judul.setFont(formFont);
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        back.setBounds(650, 600, 100, 50);
        back.addActionListener(this);
        
        historyFrame.add(back);
        historyFrame.add(title);
        historyFrame.add(judul);
        historyFrame.add(dataPanel);
        historyFrame.setLayout(null);
        historyFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Back":
                historyFrame.dispose();
                new MenuAdmin();
                break;
        }
    }
}
