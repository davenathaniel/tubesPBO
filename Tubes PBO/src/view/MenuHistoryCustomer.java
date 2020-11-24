/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckController;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.PersonManager;
import model.TransaksiManager;

/**
 *
 * @author User
 */
public class MenuHistoryCustomer implements ActionListener{
    JFrame historyCustomerFrame = new JFrame("History Menu");
    JLabel title, judul;
    JTable table;
    JPanel dataPanel;
    JButton backButton;
    
    public MenuHistoryCustomer(){
        historyCustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        historyCustomerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        historyCustomerFrame.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("C U S T O M E R       H I S T O R Y       M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        judul = new JLabel("Daftar Transaksi : ");
        judul.setBounds(360, 150, 200, 100);
        judul.setFont(StyleSheet.formFont);
        
        DefaultTableModel model = controller.CheckController.getAllTransaction();
        table = new JTable(model);
        table.setBounds(360, 250, 1200, 500);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(360, 250, 1200, 500);
        
        table.setRowSelectionAllowed(true);
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String data = null;
                int row = table.getSelectedRow();
                data = (String) table.getValueAt(row, 0);
                int x = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(x == JOptionPane.YES_OPTION){
                    int idTrans = Integer.parseInt(data);
                    TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTrans));
                    new MenuCustomer();
                }
            }
            
        });
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        backButton = new JButton("Back");
        backButton.setBounds(360, 800, 150, 50);
        backButton.setFont(StyleSheet.formFont);
        backButton.addActionListener(this);
          
        historyCustomerFrame.add(title);
        historyCustomerFrame.add(judul);
        historyCustomerFrame.add(sp);
        historyCustomerFrame.add(dataPanel);
        historyCustomerFrame.add(backButton);
        historyCustomerFrame.setLayout(null);
        historyCustomerFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Back":
                historyCustomerFrame.dispose();
                new MenuCustomer();
                break;
        }
    }
}
