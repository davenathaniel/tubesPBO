/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckController;
import controller.DataController;
import controller.RoomController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Room;

/**
 *
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class MenuManagementData implements ActionListener {

    JFrame managementDataFrame = new JFrame("Management Data Room");
    JLabel judul, filterLabel;
    JPanel createPanel, updatePanel, deletePanel;
    JLabel noKamarLabel, tipeLabel, hargaLabel;
    JLabel noKamarLabel2, tipeLabel2, hargaLabel2;
    JLabel noKamarLabel3;
    JTextField noKamar, tipe, harga;
    JTextField tipe2, harga2;
    JButton createButton, updateButton, deleteButton;
    JButton back = new JButton("Back");
    JComboBox filterHotel, filterRoom1, filterRoom2;
    int idH = 1;

    public MenuManagementData() {
        managementDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        judul = new JLabel("Room Management");
        judul.setBounds(20, 10, 500, 40);

        filterLabel = new JLabel("Choose Hotel : ");
        filterLabel.setBounds(20, 75, 200, 30);
        filterHotel = new JComboBox();
        filterHotel.setBounds(200, 75, 200, 30);
        for (int i = 0; i < DataController.listCabangHotel.size(); i++) {
            filterHotel.addItem(DataController.listCabangHotel.get(i).getNamaHotel());
        }
        filterHotel.addItemListener((e) -> {
            for (int i = 0; i < DataController.listCabangHotel.size(); i++) {
                if (filterHotel.getSelectedItem().equals(DataController.listCabangHotel.get(i).getNamaHotel())) {
                    idH = DataController.listCabangHotel.get(i).getIdHotel();
                    break;
                }
            }
            filterRoom1.removeAllItems();
            filterRoom1.addItem("Choose Room");
            for (int i = 0; i < DataController.listCabangHotel.get(idH - 1).getListRoom().size(); i++) {
                filterRoom1.addItem(DataController.listCabangHotel.get(idH - 1).getListRoom().get(i).getNoKamar());
            }
            filterRoom2.removeAllItems();
            filterRoom2.addItem("Choose Room");
            for (int i = 0; i < DataController.listCabangHotel.get(idH - 1).getListRoom().size(); i++) {
                filterRoom2.addItem(DataController.listCabangHotel.get(idH - 1).getListRoom().get(i).getNoKamar());
            }
        });

        filterRoom1 = new JComboBox();
        filterRoom1.setBounds(180, 10, 350, 40);
        filterRoom1.addItem("Choose Room");
        for (int i = 0; i < DataController.listCabangHotel.get(idH - 1).getListRoom().size(); i++) {
            filterRoom1.addItem(DataController.listCabangHotel.get(idH - 1).getListRoom().get(i).getNoKamar());
        }
        filterRoom1.addItemListener((e) -> {
            if (filterRoom1.getItemCount() != 0) {
                if (!filterRoom1.getSelectedItem().equals("Choose Room")) {
                    Room room = CheckController.getDataRoom(idH, (int) filterRoom1.getSelectedItem());
                    tipe.setText(room.getTipeKamar());
                    harga.setText(Double.toString(room.getHarga()));
                }
            }
        });

        filterRoom2 = new JComboBox();
        filterRoom2.setBounds(180, 10, 350, 40);
        filterRoom2.addItem("Choose Room");
        for (int i = 0; i < DataController.listCabangHotel.get(idH - 1).getListRoom().size(); i++) {
            filterRoom2.addItem(DataController.listCabangHotel.get(idH - 1).getListRoom().get(i).getNoKamar());
        }
        filterRoom2.addItemListener((e) -> {
            if (filterRoom2.getItemCount() != 0) {
                if (!filterRoom2.getSelectedItem().equals("Choose Room")) {
                    Room room = CheckController.getDataRoom(idH, (int) filterRoom2.getSelectedItem());
                    tipe.setText(room.getTipeKamar());
                    harga.setText(Double.toString(room.getHarga()));
                }
            }
        });
        
        noKamarLabel = new JLabel("Nomor Kamar  :");
        noKamarLabel.setBounds(10, 10, 200, 40);
        noKamarLabel2 = new JLabel("Nomor Kamar  :");
        noKamarLabel2.setBounds(10, 10, 200, 40);
        noKamarLabel3 = new JLabel("Nomor Kamar  :");
        noKamarLabel3.setBounds(10, 10, 200, 40);
        noKamar = new JTextField();
        noKamar.setBounds(180, 10, 350, 40);
        noKamar.setBorder(null);

        tipeLabel = new JLabel("Tipe :");
        tipeLabel.setBounds(10, 70, 150, 40);
        tipe = new JTextField();
        tipe.setBounds(180, 70, 350, 40);
        tipe.setBorder(null);

        tipeLabel2 = new JLabel("Tipe :");
        tipeLabel2.setBounds(10, 70, 150, 40);
        tipe2 = new JTextField();
        tipe2.setBounds(180, 70, 350, 40);
        tipe2.setBorder(null);

        hargaLabel = new JLabel("Harga  :");
        hargaLabel.setBounds(10, 130, 150, 40);
        harga = new JTextField();
        harga.setBounds(180, 130, 350, 40);
        harga.setBorder(null);

        hargaLabel2 = new JLabel("Harga  :");
        hargaLabel2.setBounds(10, 130, 150, 40);
        harga2 = new JTextField();
        harga2.setBounds(180, 130, 350, 40);
        harga2.setBorder(null);

        createButton = new JButton("CREATE");
        createButton.setBounds(1000, 400, 150, 40);
        createButton.addActionListener(this);
        updateButton = new JButton("UPDATE");
        updateButton.setBounds(1000, 400, 150, 40);
        updateButton.addActionListener(this);
        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(1000, 400, 150, 40);
        deleteButton.addActionListener(this);
        
        createPanel = new JPanel();
        createPanel.add(noKamarLabel2);
        createPanel.add(noKamar);
        createPanel.add(tipeLabel2);
        createPanel.add(tipe2);
        createPanel.add(hargaLabel2);
        createPanel.add(harga2);
        createPanel.add(createButton);
        createPanel.setLayout(null);

        updatePanel = new JPanel();
        updatePanel.add(noKamarLabel);
        updatePanel.add(filterRoom1);
        updatePanel.add(tipeLabel);
        updatePanel.add(tipe);
        updatePanel.add(hargaLabel);
        updatePanel.add(harga);
        updatePanel.add(updateButton);
        updatePanel.setLayout(null);
        
        deletePanel = new JPanel();
        deletePanel.add(noKamarLabel3);
        deletePanel.add(filterRoom2);
        deletePanel.add(deleteButton);
        deletePanel.setLayout(null);

        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(100, 150, 1200, 500);
        tp.add("CREATE ROOM", createPanel);
        tp.add("UPDATE ROOM", updatePanel);
        tp.add("DELETE ROOM", deletePanel);

        back.setBounds(20, 700, 100, 30);
        back.addActionListener(this);
        managementDataFrame.add(back);
        managementDataFrame.add(judul);
        managementDataFrame.add(filterLabel);
        managementDataFrame.add(tp);
        managementDataFrame.add(filterHotel);
        managementDataFrame.getContentPane().setBackground(Color.WHITE);
        managementDataFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        managementDataFrame.setLocationRelativeTo(null);
        managementDataFrame.setLayout(null);
        managementDataFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        switch (button) {
            case "Back":
                managementDataFrame.dispose();
                new MenuAdmin();
                break;
            case "CREATE":
                int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (a == JOptionPane.YES_OPTION) {
                    String noKamar = this.noKamar.getText();
                    String tipe = this.tipe2.getText();
                    String harga = this.harga2.getText();
                    if (noKamar.length() == 0 || tipe.length() == 0 || harga.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (RoomController.cekKetersedianRoom(idH, Integer.parseInt(noKamar))) {
                            JOptionPane.showMessageDialog(null, "There is already room with that number!", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Room room = new Room(tipe, Integer.parseInt(noKamar), Integer.parseInt(harga), idH);
                            JOptionPane.showMessageDialog(null, "Room Data : \n idHotel : " + idH + "\n noKamar : " + noKamar + "\n Tipe : " + tipe
                                    + "\n Harga " + harga);
                            if (DataController.insertNewRoom(room, idH)) {
                                JOptionPane.showMessageDialog(null, "Create New Room Succeed");
                                managementDataFrame.dispose();
                                new MenuAdmin();
                            } else {
                                JOptionPane.showMessageDialog(null, "Insert failed!", "Alert", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                }
                break;
            case "UPDATE":
                a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (a == JOptionPane.YES_OPTION) {
                    int noKamar = (int) this.filterRoom1.getSelectedItem();
                    String tipe = this.tipe.getText();
                    String harga = this.harga.getText();
                    if (tipe.length() == 0 || harga.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Room room = new Room(tipe, noKamar, Integer.parseInt(harga), idH);
                        JOptionPane.showMessageDialog(null, "Room Data : \n idHotel : " + idH + "\n noKamar : " + noKamar + "\n Tipe : " + tipe
                                + "\n Harga " + harga);
                        if (DataController.updateRoom(room, idH)) {
                            JOptionPane.showMessageDialog(null, "Update Room Succeed");
                            managementDataFrame.dispose();
                            new MenuAdmin();
                        } else {
                            JOptionPane.showMessageDialog(null, "Update failed!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                break;
                case "DELETE":
                a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (a == JOptionPane.YES_OPTION) {
                    int noKamar = (int) this.filterRoom2.getSelectedItem();
                    if (DataController.deleteRoom(noKamar, idH)) {
                        JOptionPane.showMessageDialog(null, "Delete Room Succeed");
                        managementDataFrame.dispose();
                        new MenuAdmin();
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete failed!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
                break;
        }
    }
}
