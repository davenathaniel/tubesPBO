/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.PersonManager;
import model.TransaksiManager;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuReschedule implements ActionListener{
    JFrame layoutReschedule = new JFrame("Menu Reschedule");
    JLabel title, judul, labelTanggalCheckIn, labelTanggalCheckOut;
    JButton buttonSubmit, buttonCancel;
    JPanel dataPanel;
    JTable table;
    JDatePickerImpl datePicker1, datePicker2;
    UtilDateModel model1, model2;
    Properties p1, p2;
    JDatePanelImpl datePanel1, datePanel2;
    JButton backButton;
    
    public MenuReschedule() {
        layoutReschedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutReschedule.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutReschedule.getContentPane().setBackground(StyleSheet.backgroundColor);
        
        title = new JLabel("R E S C H E D U L E    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(StyleSheet.titleFont);
        
        judul = new JLabel("Daftar Booking : ");
        judul.setBounds(460, 150, 200, 100);
        judul.setFont(StyleSheet.formFont);
        
        DefaultTableModel model = controller.CheckController.getUserActiveTransaction(PersonManager.getInstance().getPerson().getIdPerson());
        table = new JTable(model);
        table.setBounds(460, 250, 1000, 500);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(460, 250, 1000, 500);
        
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
                    layoutReschedule.dispose();
                    new MenuReschedulePopUp();
                }
            }
            
        });
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        backButton = new JButton("Back");
        backButton.setBounds(460, 800, 100, 50);
        backButton.setFont(StyleSheet.formFont);
        backButton.addActionListener(this);
        
        layoutReschedule.add(title);
        layoutReschedule.add(judul);
        layoutReschedule.add(backButton);
        layoutReschedule.add(sp);
        layoutReschedule.setLayout(null);
        layoutReschedule.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Back":
                layoutReschedule.dispose();
                new MenuCustomer();
                break;
        }
    }
}
