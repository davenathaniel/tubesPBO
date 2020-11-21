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
 * @author Dave
 */
public class MenuManagementData implements ActionListener {

    JFrame managementDataFrame = new JFrame("Management Data Room");
    JLabel judul, filterLabel;
    JPanel createPanel, updatePanel;
    JLabel noKamarLabel, tipeLabel, hargaLabel;
    JLabel noKamarLabel2, tipeLabel2, hargaLabel2;
    JTextField noKamar, tipe, harga;
    JTextField tipe2, harga2;
    JButton createButton, updateButton;
    JButton back = new JButton("Back");
    JComboBox filterHotel, filterRoom;
    int idH = 1;

    public MenuManagementData() {
        managementDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        judul = new JLabel("Room Management ~");
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
            filterRoom.removeAllItems();
            filterRoom.addItem("Choose Room");
            for (int i = 0; i < DataController.listCabangHotel.get(idH - 1).getListRoom().size(); i++) {
                filterRoom.addItem(DataController.listCabangHotel.get(idH - 1).getListRoom().get(i).getNoKamar());
            }
        });

        filterRoom = new JComboBox();
        filterRoom.setBounds(230, 10, 350, 40);
        filterRoom.addItem("Choose Room");
        for (int i = 0; i < DataController.listCabangHotel.get(idH - 1).getListRoom().size(); i++) {
            filterRoom.addItem(DataController.listCabangHotel.get(idH - 1).getListRoom().get(i).getNoKamar());
        }
        filterRoom.addItemListener((e) -> {
            if (filterRoom.getItemCount() != 0) {
                if (!filterRoom.getSelectedItem().equals("Choose Room")) {
                    Room room = CheckController.getDataRoom(idH, (int) filterRoom.getSelectedItem());
                    tipe.setText(room.getTipeKamar());
                    harga.setText(Double.toString(room.getHarga()));
                }
            }
        });

        noKamarLabel = new JLabel("Nomor Kamar  :");
        noKamarLabel.setBounds(10, 10, 200, 40);
        noKamarLabel2 = new JLabel("Nomor Kamar  :");
        noKamarLabel2.setBounds(10, 10, 200, 40);
        noKamar = new JTextField();
        noKamar.setBounds(230, 10, 350, 40);
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
        hargaLabel.setBounds(10, 190, 150, 40);
        harga = new JTextField();
        harga.setBounds(180, 190, 350, 40);
        harga.setBorder(null);

        hargaLabel2 = new JLabel("Harga  :");
        hargaLabel2.setBounds(10, 190, 150, 40);
        harga2 = new JTextField();
        harga2.setBounds(180, 190, 350, 40);
        harga2.setBorder(null);

        createButton = new JButton("CREATE");
        createButton.setBounds(1000, 400, 150, 40);
        createButton.addActionListener(this);
        updateButton = new JButton("UPDATE");
        updateButton.setBounds(1000, 400, 150, 40);
        updateButton.addActionListener(this);

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
        updatePanel.add(filterRoom);
        updatePanel.add(tipeLabel);
        updatePanel.add(tipe);
        updatePanel.add(hargaLabel);
        updatePanel.add(harga);
        updatePanel.add(updateButton);
        updatePanel.setLayout(null);

        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(100, 150, 1200, 500);
        tp.add("CREATE ROOM", createPanel);
        tp.add("UPDATE ROOM", updatePanel);

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
                    int noKamar = (int) this.filterRoom.getSelectedItem();
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
        }
    }
}
