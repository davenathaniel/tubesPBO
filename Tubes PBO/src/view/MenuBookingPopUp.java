/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DataController;
import controller.PembayaranController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import model.TransaksiManager;
import static view.StyleSheet.formFont;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuBookingPopUp implements ActionListener {
    JFrame roomBookingPopUpFrame = new JFrame("Menu Booking Pop Up");
    JLabel judulBagianPembayaran, title;
    ArrayList<JRadioButton> listRBPembayaran = new ArrayList<>();
    ButtonGroup BGroup = new ButtonGroup();
    JButton nextButton;
    JButton backButton;

    public MenuBookingPopUp() {
        roomBookingPopUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        roomBookingPopUpFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        roomBookingPopUpFrame.getContentPane().setBackground(new Color(203,202,250));

        title = new JLabel("P E M B A Y A R A N       B O O K I N G",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        judulBagianPembayaran = new JLabel("Pembayaran : ");
        judulBagianPembayaran.setBounds(650, 150, 200, 100);
        judulBagianPembayaran.setFont(StyleSheet.formFont);

        int y = 300;
        int j = 0;
        for (int i = 0; i < DataController.getAllJenisPembayaran().size(); i++){
            String jenisPembayaran = DataController.getAllJenisPembayaran().get(i).getJenisPembayaran();
            listRBPembayaran.add(new JRadioButton(jenisPembayaran));
            listRBPembayaran.get(j).setFont(formFont);
            listRBPembayaran.get(j).setBounds(850, y, 250, 50);
            y += 70;
            BGroup.add(listRBPembayaran.get(j));
            roomBookingPopUpFrame.add(listRBPembayaran.get(j));
            j++;
        }
        
        nextButton = new JButton("Submit");
        nextButton.setBounds(1000, 700, 200, 50);
        nextButton.setFont(StyleSheet.formFont);
        nextButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(750, 700, 200, 50);
        backButton.setFont(StyleSheet.formFont);
        backButton.addActionListener(this);

        roomBookingPopUpFrame.add(backButton);
        roomBookingPopUpFrame.add(judulBagianPembayaran);
        roomBookingPopUpFrame.add(nextButton);
        roomBookingPopUpFrame.add(title);
        roomBookingPopUpFrame.setLayout(null);
        roomBookingPopUpFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        switch (choice) {
            case "Back":
                roomBookingPopUpFrame.dispose();
                new MenuCustomer();
                break;
            case "Submit":
                nextButtonAction();
                break;
        }
    }

    public void nextButtonAction() {
        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (a == JOptionPane.YES_OPTION) {
            boolean pilihan = false;
            for (int i = 0; i < listRBPembayaran.size(); i++) {
                if (listRBPembayaran.get(i).isSelected()) {
                    TransaksiManager.getInstance().getTransaction().setIdJenisPembayaran(i + 1);
                    pilihan = true;
                    break;
                }
            }
            if (pilihan) {
                a = JOptionPane.showOptionDialog(null, "Total yang harus dibayar : " + TransaksiManager.getInstance().getTransaction().HitungTotalBayar() + "\nLanjutkan Pembayaran?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (a == JOptionPane.YES_OPTION) {
                    if (!PembayaranController.updatePembayaran(TransaksiManager.getInstance().getTransaction().getIdTransaksi(), TransaksiManager.getInstance().getTransaction().getIdJenisPembayaran())) {
                        JOptionPane.showMessageDialog(null, "Failed to make payment!", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment succeed!");
                        JOptionPane.showMessageDialog(null, (TransaksiManager.getInstance().getTransaction().getIdTransaksi()));
                        roomBookingPopUpFrame.dispose();
                        new MenuCustomer();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Choose payment!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
