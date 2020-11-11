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
public class MenuLogin implements ActionListener{
    JFrame loginPage = new JFrame("Login Page");
    JLabel title,usernameLabel, passwordLabel;
    JTextField username;
    JPasswordField password;
    JPanel dataPanel;
    JButton cancelButton, loginButton, registerButton;
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    public MenuLogin(){
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginPage.getContentPane().setBackground(new Color(203,202,250));

        title = new JLabel("L O G I N",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10,10,150,50);
        usernameLabel.setFont(formFont);
        username = new JTextField();
        username.setBounds(180,10,320,50);
        username.setFont(formFont);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,80,150,50);
        passwordLabel.setFont(formFont);
        password = new JPasswordField();
        password.setBounds(180, 80, 320, 50);
        password.setFont(formFont);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(30,170,150,70);
        cancelButton.setFont(formFont);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(new Color(255, 179, 179));
        
        loginButton = new JButton("Login");
        loginButton.setBounds(320,170,150,70);
        loginButton.setFont(formFont);
        loginButton.addActionListener(this);
        
        registerButton = new JButton("Click here to register new account");
        registerButton.setBounds(90,250,300,50);
        registerButton.setFont(formFont);
        registerButton.setBorder(null);
        registerButton.setBackground(new Color(203,202,250));
        registerButton.addActionListener(this);
        
        dataPanel.add(usernameLabel);
        dataPanel.add(username);
        dataPanel.add(passwordLabel);
        dataPanel.add(password);
        dataPanel.add(cancelButton);
        dataPanel.add(loginButton);
        dataPanel.add(registerButton);
        dataPanel.setBounds(710, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,500,700);
        dataPanel.setBackground(new Color(203,202,250));
        
        
        
        loginPage.add(title);
        loginPage.add(dataPanel);
        loginPage.setLayout(null);
        loginPage.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Cancel" :
                loginPage.dispose();
                new MenuUtama();
                break;
            case "Login":
                loginPage.dispose();
                //new menu apalah yg nampilin per user kan?
                break;
            case "Click here to register new account":
                loginPage.dispose();
                new MenuRegister();
                break;
        }
    } 
}
