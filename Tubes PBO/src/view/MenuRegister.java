/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Person;
import model.enums.TipePersonEnum;

/**
 *
 * @author maria
 */
public class MenuRegister implements ActionListener {
    JFrame registerForm = new JFrame("Registration Page");
    JLabel title, namaLabel, alamatLabel, message, ktpLabel, teleponLabel, usernameLabel, passwordLabel, emailLabel;
    JTextField nama, ktp, telepon, username, alamat, email;
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
        
        emailLabel = new JLabel("Email",JLabel.LEFT);
        emailLabel.setBounds(10,190,150,50);
        emailLabel.setFont(formFont);
        email = new JTextField();
        email.setBounds(180,190,320,50);
        email.setFont(formFont);
        
        teleponLabel =  new JLabel("Telepon",JLabel.LEFT);
        teleponLabel.setBounds(10,250,150,50);
        teleponLabel.setFont(formFont);
        telepon = new JTextField();
        telepon.setBounds(180,250,320,50);
        telepon.setFont(formFont);
        
        message = new JLabel("Username Already Exist");
        message.setBounds(200,560,300,70);
        message.setFont(formFont);
        message.setForeground(Color.red);
        
        usernameLabel = new JLabel("Username",JLabel.LEFT);
        usernameLabel.setBounds(10,310, 150,50);
        usernameLabel.setFont(formFont);
        username = new JTextField();
        username.setBounds(180,310,320,50);
        username.setFont(formFont);
        username.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(Controller.cekUsername(username.getText())){
                    registerButton.setEnabled(false);
                    message.setText("username already taken");
                }else{
                    registerButton.setEnabled(true);
                    message.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(Controller.cekUsername(username.getText())){
                    registerButton.setEnabled(false);
                    message.setText("username already taken");
                }else{
                    registerButton.setEnabled(true);
                    message.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        passwordLabel = new JLabel("Password",JLabel.LEFT);
        passwordLabel.setBounds(10,370,150,50);
        passwordLabel.setFont(formFont);
        password = new JPasswordField();
        password.setBounds(180,370,320,50);
        password.setFont(formFont);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(30,480,150,70);
        cancelButton.setFont(formFont);
        cancelButton.addActionListener(this);
        cancelButton.setBackground(new Color(255, 179, 179));
        
        registerButton = new JButton("Register");
        registerButton.setBounds(320,480,150,70);
        registerButton.setFont(formFont);
        registerButton.addActionListener(this);
        
        dataPanel.add(namaLabel);
        dataPanel.add(nama);
        dataPanel.add(alamatLabel);
        dataPanel.add(alamat);
        dataPanel.add(ktpLabel);
        dataPanel.add(ktp);
        dataPanel.add(emailLabel);
        dataPanel.add(email);
        dataPanel.add(teleponLabel);
        dataPanel.add(telepon);
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
                String nama = this.nama.getText();
                String alamat = this.alamat.getText();
                String noKTP = this.ktp.getText();
                String email = this.telepon.getText();
                String noHP = this.telepon.getText();
                String uname = username.getText();
                String pass = new String(password.getPassword());
                int x = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(x == JOptionPane.YES_OPTION){
                    if(nama.length() == 0 || alamat.length() == 0 || noKTP.length() == 0 || email.length() == 0 || noHP.length() == 0 || uname.length() == 0 || pass.length() == 0){
                        JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }else{
                        Person newPerson = new Person();
                        newPerson.setUsername(uname);
                        newPerson.setPassword(pass);
                        newPerson.setNama(nama);
                        newPerson.setAlamat(alamat);
                        newPerson.setNoKTP(noKTP);
                        newPerson.setNoHP(noHP);
                        newPerson.setEmail(email);
                        newPerson.setTipePerson(TipePersonEnum.CUSTOMER);
                        if(Controller.insertCustomer(newPerson)){
                            JOptionPane.showMessageDialog(null, "Registration Complete!\nPlease Login!");
                            registerForm.dispose();
                            new MenuLogin();
                        }else{
                            JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    
                }
                break;      
        }
    } 
}
