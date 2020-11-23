/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.PersonManager;
import model.enums.TipePersonEnum;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuLogin implements ActionListener{
    JFrame loginPage = new JFrame("Login Page");
    JLabel title,usernameLabel, passwordLabel;
    JTextField username;
    JPasswordField password;
    JPanel dataPanel;
    JButton cancelButton, loginButton, registerButton;
    
    public MenuLogin(){
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginPage.getContentPane().setBackground(StyleSheet.backgroundColor);

        title = new JLabel("L O G I N",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10,10,150,50);
        usernameLabel.setFont(StyleSheet.formFont);
        username = new JTextField();
        username.setBounds(180,10,320,50);
        username.setFont(StyleSheet.formFont);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,80,150,50);
        passwordLabel.setFont(StyleSheet.formFont);
        password = new JPasswordField();
        password.setBounds(180, 80, 320, 50);
        password.setFont(StyleSheet.formFont);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(30,170,150,70);
        cancelButton.setFont(StyleSheet.formFont);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(StyleSheet.cancelButtonColor);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(320,170,150,70);
        loginButton.setFont(StyleSheet.formFont);
        loginButton.addActionListener(this);
        
        registerButton = new JButton("Click here to register new account");
        registerButton.setBounds(90,250,300,50);
        registerButton.setFont(StyleSheet.formFont);
        registerButton.setBorder(null);
        registerButton.setBackground(StyleSheet.backgroundColor);
        registerButton.addActionListener(this);
        
        dataPanel.add(usernameLabel);
        dataPanel.add(username);
        dataPanel.add(passwordLabel);
        dataPanel.add(password);
        dataPanel.add(cancelButton);
        dataPanel.add(loginButton);
        dataPanel.add(registerButton);
        dataPanel.setBounds(710, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,500,700);
        dataPanel.setBackground(StyleSheet.backgroundColor);
        
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
                String uname = username.getText();
                String pass = new String(password.getPassword());
                if (uname.equals("") && pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please insert username and password!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else if (uname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please insert username!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else if (pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please insert password!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else if (Controller.cekPassword(uname, pass)) {
                    PersonManager.getInstance().setPerson(Controller.getPerson(uname));
                    if (PersonManager.getInstance().getPerson().getTipePerson() == TipePersonEnum.ADMIN) {
                        loginPage.dispose();
                        new MenuAdmin();
                    } else if (PersonManager.getInstance().getPerson().getTipePerson() == TipePersonEnum.RECEPTIONIST) {
                        loginPage.dispose();
                        new MenuReseptionist();
                    } else if (PersonManager.getInstance().getPerson().getTipePerson() == TipePersonEnum.CUSTOMER) {
                        loginPage.dispose();
                        new MenuCustomer();
                    } else {
                        loginPage.dispose();
                        new MenuUtama();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insert username and password correctly!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Click here to register new account":
                loginPage.dispose();
                new MenuRegister();
                break;
        }
    } 
}
