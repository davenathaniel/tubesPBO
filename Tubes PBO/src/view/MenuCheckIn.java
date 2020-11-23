/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Room;
import model.TransaksiManager;
import model.enums.StatusBookingEnum;
/**
 *
 * @author maria
 */
public class MenuCheckIn implements ActionListener, ItemListener{
    JFrame layoutCheckIn = new JFrame("Check-In Menu");
    JLabel title, labelBooking, labelNamaHotel;
    Font formFont = new Font("Arial",Font.PLAIN,20);
    JComboBox namaHotel;
    JTable table;
    
    public MenuCheckIn() {
        layoutCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutCheckIn.setExtendedState(JFrame.MAXIMIZED_BOTH);
        layoutCheckIn.getContentPane().setBackground(new Color(203,202,250));
        
        title = new JLabel("C h e c k - I n   M e n u",JLabel.CENTER);
        title.setBounds(0,0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/5);
        title.setFont(new Font("Impact",Font.PLAIN,50));
        
        labelNamaHotel = new JLabel("Nama Hotel");
        labelNamaHotel.setBounds(700,200,200,50);
        labelNamaHotel.setFont(formFont);
        
        namaHotel = new JComboBox();
        namaHotel.setBounds(950, 200, 250, 50);
        namaHotel.setFont(formFont);
        namaHotel.addItem("Choose Hotel Name");
        for (int i = 0; i < controller.DataController.listCabangHotel.size(); i++) {
            namaHotel.addItem(controller.DataController.listCabangHotel.get(i).getNamaHotel());
        }
        namaHotel.addItemListener(this);
        
        DefaultTableModel model = controller.CheckController.getTransactionByStatus(2, StatusBookingEnum.BOOKED);
        table = new JTable(model);
        table.setBounds(100, 150, 1200, 500);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(100, 150, 1200, 500);

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
                    TransaksiManager.getInstance().setTransaction(controller.CheckController.getOneTransaction(idTransaksi));
                    if (controller.CheckController.updateCheckIn(idTransaksi)) {
                        TransaksiManager.getInstance().getTransaction().setStatus(StatusBookingEnum.CHECKEDIN);
                        Room room = controller.CheckController.getDataRoom(TransaksiManager.getInstance().getTransaction().getIdHotel(), TransaksiManager.getInstance().getTransaction().getNo_Kamar());
                        String str = "ID Transaksi : " + TransaksiManager.getInstance().getTransaction().getIdTransaksi() + "\nRincian Kamar : " + room.toString();
                        JOptionPane.showMessageDialog(null, str);
                        layoutCheckIn.dispose();
                        new MenuReseptionist();
                    } else {
                        JOptionPane.showMessageDialog(null, "Check In Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
  
        
        layoutCheckIn.add(title);
        layoutCheckIn.add(labelNamaHotel);
        layoutCheckIn.add(namaHotel);
        layoutCheckIn.add(sp);
        layoutCheckIn.setLayout(null);
        layoutCheckIn.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Submit":
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int idHotel = 0;
        for (int i = 0; i < controller.DataController.listCabangHotel.size(); i++) {
            if (namaHotel.getSelectedItem().equals(controller.DataController.listCabangHotel.get(i).getNamaHotel())) {
                idHotel = controller.DataController.listCabangHotel.get(i).getIdHotel();
                break;
            }
        }
        DefaultTableModel model = controller.CheckController.getTransactionByStatus(idHotel, StatusBookingEnum.BOOKED);
        table.setModel(model);
    }
    
    
}
