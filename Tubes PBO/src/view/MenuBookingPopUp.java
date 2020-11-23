/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DataController;
import controller.PembayaranController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.PersonManager;
import model.TransaksiManager;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuBookingPopUp implements ActionListener {

    JFrame roomBookingPopUpFrame = new JFrame("Booking Payment");
    JLabel judulBagianPembayaran;
    ArrayList<JRadioButton> listRButtonPembayaran = new ArrayList<>();
    ButtonGroup buttonGroup = new ButtonGroup();
    JButton nextButton;
    JButton back = new JButton("<< Back");
    int penanda, noKamar;

    public MenuBookingPopUp() {
        roomBookingPopUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        judulBagianPembayaran = new JLabel("Pembayaran : ");
        judulBagianPembayaran.setBounds(20, 15, 300, 40);

        int height = 60;
        int j = 0;
        for (int i = 1; i < DataController.listJenisPembayaran.size(); i++) {
            String jenisBayar = DataController.listJenisPembayaran.get(i).getJenisPembayaran();
            listRButtonPembayaran.add(new JRadioButton(jenisBayar));
            listRButtonPembayaran.get(j).setBounds(20, height, 200, 30);
            height += 38;
            buttonGroup.add(listRButtonPembayaran.get(j));
            roomBookingPopUpFrame.add(listRButtonPembayaran.get(j));
            j++;
        }

        nextButton = new JButton("Next >>");
        nextButton.setBounds(500, 320, 150, 30);
        nextButton.setEnabled(true);
        nextButton.addActionListener(this);

        back.setBounds(20, 500, 100, 30);
        back.addActionListener(this);

        roomBookingPopUpFrame.add(back);
        roomBookingPopUpFrame.add(judulBagianPembayaran);
        roomBookingPopUpFrame.add(nextButton);
        roomBookingPopUpFrame.setBackground(Color.WHITE);
        roomBookingPopUpFrame.setSize(700, 750);
        roomBookingPopUpFrame.setLocationRelativeTo(null);
        roomBookingPopUpFrame.setLayout(null);
        roomBookingPopUpFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        switch (choice) {
            case "<< Back":
                roomBookingPopUpFrame.dispose();
                new MenuCustomer();
                break;
            case "Next >>":
                nextButtonAction();
                break;
        }
    }

    public void nextButtonAction() {
        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (a == JOptionPane.YES_OPTION) {
            boolean pilihan = false;
            for (int i = 0; i < listRButtonPembayaran.size(); i++) {
                if (listRButtonPembayaran.get(i).isSelected()) {
                    pilihan = true;
                    break;
                }
            }
            if (pilihan) {
                a = JOptionPane.showOptionDialog(null, "Total yang harus dibayar : " + TransaksiManager.getInstance().getTransaction().getBill() + "\nLanjutkan Pembayaran?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (a == JOptionPane.YES_OPTION) {
                    if (!PembayaranController.updatePembayaran(TransaksiManager.getInstance().getTransaction().getIdTransaksi(), TransaksiManager.getInstance().getTransaction().getIdJenisPembayaran())) {
                        JOptionPane.showMessageDialog(null, "Failed to make payment!", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment succeed!");
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
