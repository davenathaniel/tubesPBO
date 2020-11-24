/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.TransaksiManager;

/**
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuHistoryAdmin implements ActionListener{
    JFrame historyFrame = new JFrame("History Menu");
    JLabel title, judul;
    JTable table;
    JPanel dataPanel;
    JButton back;
    
    public MenuHistoryAdmin(){
        historyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        historyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        historyFrame.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("H I S T O R Y    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        judul = new JLabel("Daftar Transaksi : ");
        judul.setBounds(650, 150, 200, 100);
        judul.setFont(StyleSheet.formFont);
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        DefaultTableModel model = controller.CheckController.getAllTransaction();
        table = new JTable(model);
        table.setBounds(100, 150, 1200, 500);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setRowSelectionAllowed(true);
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int row = table.getSelectedRow();
                Data = (String) table.getValueAt(row, 0);
                int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (a == JOptionPane.YES_OPTION) {
                    int idTransaksi = Integer.parseInt(Data);
                    TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTransaksi));
                    new MenuViewTransaksi();
                }
            }
        });
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100, 150, 1200, 500);
        
        back = new JButton("Back");
        back.setBounds(650, 600, 100, 50);
        back.setFont(StyleSheet.formFont);
        back.addActionListener(this);
        
        historyFrame.add(back);
        historyFrame.add(title);
        historyFrame.add(sp);
        historyFrame.add(judul);
        historyFrame.add(dataPanel);
        historyFrame.setLayout(null);
        historyFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Back":
                historyFrame.dispose();
                new MenuAdmin();
                break;
        }
    }
}
