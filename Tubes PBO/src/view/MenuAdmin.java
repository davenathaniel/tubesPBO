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
    JButton cekHistory, manageData, logOut;
    
    public MenuAdmin(){
        layoutAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutAdmin.getContentPane().setBackground(new Color(203, 202, 250));
        
        title = new JLabel("~ W E L C O M E      A D M I N ! ~",JLabel.CENTER);
        title.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact", Font.PLAIN,50));
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        
        cekHistory = new JButton("History");
        cekHistory.setBounds(600, 50, 200, 70);
        cekHistory.addActionListener(this);
        cekHistory.setFont(new Font("Impact", Font.PLAIN, 25));
        
        manageData = new JButton("Management Data");
        manageData.setBounds(850, 50, 200, 70);
        manageData.addActionListener(this);
        manageData.setFont(new Font("Impact", Font.PLAIN, 25));
        
        logOut = new JButton("Logout");
        logOut.setBounds(1100, 50, 200, 70);
        logOut.addActionListener(this);
        logOut.setFont(new Font("Impact", Font.PLAIN, 25));
        
        buttonPanel.add(cekHistory);
        buttonPanel.add(manageData);
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
            case "History":
                new MenuHistory();
                break;
            case "Management Data":
                new MenuManagementData();
                break;    
            case "Logout":
                int jawab = JOptionPane.showOptionDialog(null, 
                    "Log Out Now?", 
                    "Log Out", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
    
                if(jawab == JOptionPane.YES_OPTION){
                    layoutAdmin.dispose();
                    new MenuUtama();
                }
                break;
        }
    }
}
