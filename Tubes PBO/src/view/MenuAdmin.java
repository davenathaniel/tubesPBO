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
 * @author Dave
 */
public class MenuAdmin implements ActionListener{
    JFrame layoutAdmin = new JFrame("Menu Admin");
    JLabel title;
    JPanel buttonPanel;
    JButton cekHistory, createCabang, updateCabang, deleteCabang, logOut;
    
    public MenuAdmin(){
        layoutAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutAdmin.getContentPane().setBackground(new Color(203, 202, 250));
        
        title = new JLabel("~ W E L C O M E      A D M I N ! ~",JLabel.CENTER);
        title.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact", Font.PLAIN,50));
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        
        cekHistory = new JButton("Check History");
        cekHistory.setBounds(100, 50, 200, 70);
        cekHistory.addActionListener(this);
        cekHistory.setFont(new Font("Impact", Font.PLAIN, 25));
        
        createCabang = new JButton("Create Cabang");
        createCabang.setBounds(350, 50, 200, 70);
        createCabang.addActionListener(this);
        createCabang.setFont(new Font("Impact", Font.PLAIN, 25));
        
        updateCabang = new JButton("Update Cabang");
        updateCabang.setBounds(600, 50, 200, 70);
        updateCabang.addActionListener(this);
        updateCabang.setFont(new Font("Impact", Font.PLAIN, 25));
        
        deleteCabang = new JButton("Delete Cabang");
        deleteCabang.setBounds(850, 50, 200, 70);
        deleteCabang.addActionListener(this);
        deleteCabang.setFont(new Font("Impact", Font.PLAIN, 25));
        
        logOut = new JButton("Logout");
        logOut.setBounds(1100, 50, 200, 70);
        logOut.addActionListener(this);
        logOut.setFont(new Font("Impact", Font.PLAIN, 25));
        
        buttonPanel.add(cekHistory);
        buttonPanel.add(createCabang);
        buttonPanel.add(updateCabang);
        buttonPanel.add(deleteCabang);
        buttonPanel.add(logOut);
        buttonPanel.setBounds(0, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        buttonPanel.setBackground(new Color(203,202,250));
        
        layoutAdmin.add(title);
        layoutAdmin.add(buttonPanel);
        layoutAdmin.setLayout(null);
        layoutAdmin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Check History":
                JFrame f1;    
                f1 = new JFrame();  
                JOptionPane.showMessageDialog(f1, "Feature Coming Soon!", "Alert",JOptionPane.WARNING_MESSAGE);
                break;
            case "Create Cabang":
                JFrame f2;    
                f2 = new JFrame();  
                JOptionPane.showMessageDialog(f2, "Feature Coming Soon!", "Alert",JOptionPane.WARNING_MESSAGE);
                break;
            case "Update Cabang":
                JFrame f3;    
                f3 = new JFrame();  
                JOptionPane.showMessageDialog(f3, "Feature Coming Soon!", "Alert",JOptionPane.WARNING_MESSAGE);
                break;
            case "Delete Cabang":
                JFrame f4;    
                f4 = new JFrame();  
                JOptionPane.showMessageDialog(f4, "Feature Coming Soon!", "Alert",JOptionPane.WARNING_MESSAGE);
                break;    
            case "Logout":
                layoutAdmin.dispose();
                new MenuUtama();
                break;
        }
    }
}
