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
public class MenuRegister implements ActionListener {
    JFrame registerForm = new JFrame("Registration Page");
    JLabel title, namaLabel, alamatLabel, ktpLabel, teleponLabel, usernameLabel, passwordLabel;
    JTextField nama, ktp, telepon, username, alamat;
    JPasswordField password;
    JPanel dataPanel;
    JButton registerButton, cancelButton;
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    public MenuRegister() {
        registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registerForm.getContentPane().setBackground(new Color(203,202,250));

        title = new JLabel("R e g i s t r a t i o n    F o r m",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));

        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        namaLabel = new JLabel("Nama",JLabel.LEFT);
        namaLabel.setBounds(10,10,150,50);
        namaLabel.setFont(formFont);
        nama = new JTextField();
        nama.setBounds(180,10,320,50);
        nama.setFont(formFont);
        
        alamatLabel = new JLabel("Alamat",JLabel.LEFT);
        alamatLabel.setBounds(10,70,150,50);
        alamatLabel.setFont(formFont);
        alamat = new JTextField();
        alamat.setBounds(180,70,320,50);
        alamat.setFont(formFont);
        
        ktpLabel = new JLabel("NO. KTP",JLabel.LEFT);
        ktpLabel.setBounds(10,130,150,50);
        ktpLabel.setFont(formFont);
        ktp = new JTextField();
        ktp.setBounds(180,130,320,50);
        ktpLabel.setFont(formFont);
        
        usernameLabel = new JLabel("Username",JLabel.LEFT);
        usernameLabel.setBounds(10,190, 150,50);
        usernameLabel.setFont(formFont);
        username = new JTextField();
        username.setBounds(180,190,320,50);
        username.setFont(formFont);
        
        passwordLabel = new JLabel("Password",JLabel.LEFT);
        passwordLabel.setBounds(10,250,150,50);
        passwordLabel.setFont(formFont);
        password = new JPasswordField();
        password.setBounds(180,250,320,50);
        password.setFont(formFont);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(30,370,150,70);
        cancelButton.setFont(formFont);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(new Color(255, 179, 179));
        
        registerButton = new JButton("Register");
        registerButton.setBounds(320,370,150,70);
        registerButton.setFont(formFont);
        registerButton.addActionListener(this);
        
        dataPanel.add(namaLabel);
        dataPanel.add(nama);
        dataPanel.add(alamatLabel);
        dataPanel.add(alamat);
        dataPanel.add(ktpLabel);
        dataPanel.add(ktp);
        dataPanel.add(usernameLabel);
        dataPanel.add(username);
        dataPanel.add(passwordLabel);
        dataPanel.add(password);
        dataPanel.add(cancelButton);
        dataPanel.add(registerButton);
        dataPanel.setBounds(710, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5,500,700);
        dataPanel.setBackground(new Color(203,202,250));
        
        registerForm.add(title);
        registerForm.add(dataPanel);
        registerForm.setLayout(null);
        registerForm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Cancel" :
                registerForm.dispose();
                new MenuUtama();
                break;
            case "Register":
                registerForm.dispose();
                new MenuLogin();
                break;
        }
    } 
}
