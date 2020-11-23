/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuUtama implements ActionListener{
    JFrame layarUtama = new JFrame("Hotel Harapan Bangsa");
    JButton loginButton, registerButton;
    JLabel title;
    JPanel panelButton;
    
    public MenuUtama(){
        layarUtama.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layarUtama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layarUtama.getContentPane().setBackground(StyleSheet.backgroundColor);
        title = new JLabel("~ H o t e l     H a r a p a n     B a n g s a ~",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        panelButton = new JPanel();
        panelButton.setLayout(null);
        panelButton.setBounds(0, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        panelButton.setBackground(StyleSheet.backgroundColor);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(700, 50, 200,70);
        loginButton.addActionListener(this);
        loginButton.setFont(StyleSheet.buttonFont);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(1020, 50, 200,70);
        registerButton.addActionListener(this);
        registerButton.setFont(StyleSheet.buttonFont);
        
        panelButton.add(loginButton);
        panelButton.add(registerButton);
        
        layarUtama.add(title);
        layarUtama.add(panelButton);
        layarUtama.setLayout(null);
        layarUtama.setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Login" :
                layarUtama.dispose();
                new MenuLogin();
                break;
            case "Register":
                layarUtama.dispose();
                new MenuRegister();
                break;
        }
    }    
}
