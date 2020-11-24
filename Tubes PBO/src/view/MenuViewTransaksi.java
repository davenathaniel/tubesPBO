/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.TransaksiManager;

/**
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuViewTransaksi {

    JFrame transactionViewFrame = new JFrame("Transaction");
    JLabel judul, isi;

    public MenuViewTransaksi() {
        transactionViewFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        judul = new JLabel("Detail Transaksi :");
        judul.setBounds(10, 10, 200, 40);

        isi = new JLabel();
        isi.setBounds(10, 30, 690, 720);
        isi.setText(TransaksiManager.getInstance().toString());

        transactionViewFrame.add(judul);
        transactionViewFrame.add(isi);
        transactionViewFrame.setSize(700, 770);
        transactionViewFrame.getContentPane().setBackground(Color.WHITE);
        transactionViewFrame.setLocationRelativeTo(null);
        transactionViewFrame.setLayout(null);
        transactionViewFrame.setVisible(true);
    }
}
