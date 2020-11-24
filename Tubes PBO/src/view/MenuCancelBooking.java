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
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.PersonManager;
import model.TransaksiManager;
import static model.enums.TipePersonEnum.CUSTOMER;

/**
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuCancelBooking implements ActionListener{
    JFrame cancelBookingFrame = new JFrame("Cancel Booking Menu");
    JLabel title, judul;
    JTable table;
    JPanel dataPanel;
    JButton back = new JButton("Back");
    Font formFont = new Font("Arial",Font.PLAIN,20);
    
    public MenuCancelBooking(){
        cancelBookingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancelBookingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cancelBookingFrame.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("C A N C E L    B O O K I N G    M E N U",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        judul = new JLabel("Daftar Booking : ");
        judul.setBounds(650, 150, 200, 100);
        judul.setFont(formFont);
        
        DefaultTableModel model = controller.CheckController.getUserActiveTransaction(PersonManager.getInstance().getPerson().getIdPerson());
        table = new JTable(model);
        table.setBounds(650, 250, 700, 500);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(650, 250, 700, 500);
        
        table.setRowSelectionAllowed(true);
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String data = null;
                int row = table.getSelectedRow();
                data = (String) table.getValueAt(row, 0);
                int x = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(x == JOptionPane.YES_OPTION){
                    int idTrans = Integer.parseInt(data);
                    TransaksiManager.getInstance().setTransaction(CheckController.getOneTransaction(idTrans));
                    if(CheckController.CancelBooking(TransaksiManager.getInstance().getTransaction())){
                        JOptionPane.showMessageDialog(null, "Cancelation Successful.");
                        cancelBookingFrame.dispose();
                        new MenuCancelBooking();
                    }else{
                        JOptionPane.showMessageDialog(null, "Cancelation Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        
        dataPanel = new JPanel();
        dataPanel.setLayout(null);
        
        back.setBounds(650, 800, 100, 50);
        back.addActionListener(this);
        
        cancelBookingFrame.add(back);
        cancelBookingFrame.add(title);
        cancelBookingFrame.add(judul);
        cancelBookingFrame.add(sp);
        cancelBookingFrame.add(dataPanel);
        cancelBookingFrame.setLayout(null);
        cancelBookingFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Back":
                cancelBookingFrame.dispose();
                new MenuCustomer();
                break;
        }
    }
}
